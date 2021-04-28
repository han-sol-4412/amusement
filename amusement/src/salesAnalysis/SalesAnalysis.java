package salesAnalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class SalesAnalysis {
	public static ArrayList<String> data = new ArrayList<String>();
	public static String[][] dataArray;
	public static PrintSales print;
	
	public SalesAnalysis() {
		print = new PrintSales();
	}

	public void readFile() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sol\\Desktop\\amusement.csv");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		String line;
		while((line = reader.readLine()) != null) {
			data.add(line);
		}
		dataArray = new String[data.size()][];
		for(int i=0; i<data.size(); i++) {
			dataArray[i] = data.get(i).split(",");	
		}
	}
	
	public void fullInfo() {
		print.fullInfo(data,dataArray);
	}
	
	public void ticketType_age() {
		int day_cnt = 0;
		int night_cnt= 0;
		int day_price = 0;
		int night_price= 0;
		
		int adult_day =0;
		int teem_day = 0;
		int child_day = 0;
		int old_day = 0;
		int baby_day = 0;
		
		int adult_night =0;
		int teem_night = 0;
		int child_night = 0;
		int old_night = 0;
		int baby_night = 0;
		
		for(int i=1; i<data.size(); i++) {
			if(dataArray[i][1].equals("주간권")) {
				day_cnt+= Integer.parseInt(dataArray[i][3]);
				day_price += Integer.parseInt(dataArray[i][4]);
				if(dataArray[i][2].equals("대인")) {
					adult_day+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][2].equals("청소년")) {
					teem_day+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][2].equals("소인")) {
					child_day+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][2].equals("경로")) {
					old_day+= Integer.parseInt(dataArray[i][3]);
				} else {
					baby_day+= Integer.parseInt(dataArray[i][3]);
				}
			} else {
				night_cnt+= Integer.parseInt(dataArray[i][3]);
				night_price += Integer.parseInt(dataArray[i][4]);
				if(dataArray[i][2].equals("대인")) {
					adult_night+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][2].equals("청소년")) {
					teem_night+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][2].equals("소인")) {
					child_night+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][2].equals("경로")) {
					old_night+= Integer.parseInt(dataArray[i][3]);
				} else {
					baby_night+= Integer.parseInt(dataArray[i][3]);
				}
			}
		}
		
		TicketType_Age ta = new TicketType_Age(day_cnt, night_cnt, day_price, night_price, adult_day, teem_day, child_day,
								old_day, baby_day, adult_night, teem_night, child_night, old_night, baby_night);
		print.ticketType_age(ta);
	}
	
	public void dateAnalysis() {
		HashSet<Integer> date = new HashSet<Integer>();
		for(int i=1; i<data.size(); i++) {
			date.add(Integer.parseInt(dataArray[i][0]));
		}
		
		ArrayList<Integer> dateData = new ArrayList<Integer>(date); // hashSet -> arrayList
		dateData.sort(null);
		
		int[] totalPrice = new int[100];
		
		for(int i=0; i<dateData.size(); i++) {
			for(int j=0; j<dataArray.length; j++) {
				if(dataArray[j][0].equals(dateData.get(i)+"")) {
					totalPrice[i]+=Integer.parseInt(dataArray[j][4]);
				}
			}
		}
		print.dateAnalysis(dateData, totalPrice);
	}
	
	public void discountAnalysis() {
		int totalCnt = 0;
		int noDiscount = 0;
		int disable = 0;
		int merit = 0;
		int multichild = 0;
		int pregnant = 0;
		
		for(int i=1; i<data.size(); i++) {
				totalCnt++;
				if(dataArray[i][5].equals("장애인")) {
					disable+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][5].equals("국가유공자")) {
					merit+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][5].equals("다자녀")) {
					multichild+= Integer.parseInt(dataArray[i][3]);
				} else if(dataArray[i][5].equals("임산부")) {
					pregnant+= Integer.parseInt(dataArray[i][3]);
				} else {
					noDiscount+= Integer.parseInt(dataArray[i][3]);
				}
		}
		
		Discount dis = new Discount(totalCnt, noDiscount, disable, merit, multichild, pregnant);
		print.discountAnalysis(dis);
	}
	
}

