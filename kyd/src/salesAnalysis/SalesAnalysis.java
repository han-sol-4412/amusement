package salesAnalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class SalesAnalysis {
	public static ArrayList<String> data = new ArrayList<String>();
	public static String[][] dataArray;
	public void readFile() throws IOException{
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\sol\\Desktop\\amusement.csv");
		InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "MS949");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		
		String line;
		while((line = reader.readLine()) != null) {
			//System.out.println(line);
			data.add(line);
		}
		dataArray = new String[data.size()][];
		for(int i=0; i<data.size(); i++) {
			dataArray[i] = data.get(i).split(",");	
		}
	}
	
	public void fullInfo() {
		System.out.println("-------------------------------------amusement.csv------------------------------------------");
		System.out.printf("%s\t\t%s\t\t%s\t%s\t\t%s\t\t%s\n",
				dataArray[0][0],dataArray[0][1],dataArray[0][2],dataArray[0][3],dataArray[0][4],dataArray[0][5]);
		
		
		for(int i=1; i<data.size(); i++) {
			System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
					dataArray[i][0],dataArray[i][1],dataArray[i][2],dataArray[i][3],dataArray[i][4],dataArray[i][5]);
		}
		System.out.println("--------------------------------------------------------------------------------------------");
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
				day_cnt++;
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
				night_cnt++;
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
		
		System.out.println("\n------------------------------------권종별 매출현황-----------------------------------------");
		System.out.println("주간원 총 "+day_cnt+"매");
		System.out.printf("유아 %d매\t 어린이 %d매\t 청소년 %d매\t 어른 %d매\t 노인 %d매\n",baby_day,child_day,teem_day,adult_day,old_day);
		System.out.println("주간권 매출 : "+day_price);
		System.out.println();
		System.out.println("야간원 총 "+night_cnt+"매");
		System.out.printf("유아 %d매\t 어린이 %d매\t 청소년 %d매\t 어른 %d매\t 노인 %d매\n",baby_night,child_night,teem_night,adult_night,old_night);
		System.out.println("야간권 매출 : "+night_price);
		System.out.println("--------------------------------------------------------------------------------------------");
		
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
		
		System.out.println("\n------------------------------------일자별 판매현황-----------------------------------------");
		for(int i=0; i<dateData.size(); i++) {
			System.out.printf("%s년 %s월 %s일 : %d원 \n",(dateData.get(i)+"").substring(0, 4),(dateData.get(i)+"").substring(4, 6),(dateData.get(i)+"").substring(6, 8),totalPrice[i]);
		}
		System.out.println("--------------------------------------------------------------------------------------------");
	
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
		
		System.out.println("\n------------------------------------우대권 판매현황-----------------------------------------");
		System.out.printf("%s\t\t : %d매\n","총 판매 티켓수",totalCnt);
		System.out.printf("%s\t\t : %d매\n","우대 없음",noDiscount);
		System.out.printf("%s\t\t\t : %d매\n","장애인",disable);
		System.out.printf("%s\t\t : %d매\n","국가유공자",merit);
		System.out.printf("%s\t\t\t : %d매\n","다자녀",multichild);
		System.out.printf("%s\t\t\t : %d매\n","임산부",pregnant);
		System.out.println("--------------------------------------------------------------------------------------------");
		
		
	}
	
}
