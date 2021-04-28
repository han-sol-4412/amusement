package salesAnalysis;

import java.util.ArrayList;

public class PrintSales {

	public void fullInfo(ArrayList<String> data,String[][] dataArray) {
		System.out.println("-------------------------------------amusement.csv------------------------------------------");
		System.out.printf("%s\t\t%s\t\t%s\t%s\t\t%s\t\t%s\n",
				dataArray[0][0],dataArray[0][1],dataArray[0][2],dataArray[0][3],dataArray[0][4],dataArray[0][5]);
		
		
		for(int i=1; i<data.size(); i++) {
			System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t\t%s\n",
					dataArray[i][0],dataArray[i][1],dataArray[i][2],dataArray[i][3],dataArray[i][4],dataArray[i][5]);
		}
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void ticketType_age(TicketType_Age ta) {
		System.out.println("\n------------------------------------권종별 매출현황-----------------------------------------");
		System.out.println("주간원 총 "+ta.day_cnt+"매");
		System.out.printf("유아 %d매\t 어린이 %d매\t 청소년 %d매\t 어른 %d매\t 노인 %d매\n",ta.baby_day,ta.child_day,ta.teem_day,ta.adult_day,ta.old_day);
		System.out.println("주간권 매출 : "+ta.day_price);
		System.out.println();
		System.out.println("야간원 총 "+ta.night_cnt+"매");
		System.out.printf("유아 %d매\t 어린이 %d매\t 청소년 %d매\t 어른 %d매\t 노인 %d매\n",ta.baby_night,ta.child_night,ta.teem_night,ta.adult_night,ta.old_night);
		System.out.println("야간권 매출 : "+ta.night_price);
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void dateAnalysis(ArrayList<Integer> dateData, int[] totalPrice) {
		System.out.println("\n------------------------------------일자별 판매현황-----------------------------------------");
		for(int i=0; i<dateData.size(); i++) {
			System.out.printf("%s년 %s월 %s일 : %d원 \n",(dateData.get(i)+"").substring(0, 4),(dateData.get(i)+"").substring(4, 6),(dateData.get(i)+"").substring(6, 8),totalPrice[i]);
		}
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	public void discountAnalysis(Discount dis) {
		System.out.println("\n------------------------------------우대권 판매현황-----------------------------------------");
		System.out.printf("%s\t\t : %d매\n","총 판매 티켓수",dis.totalCnt);
		System.out.printf("%s\t\t : %d매\n","우대 없음",dis.noDiscount);
		System.out.printf("%s\t\t\t : %d매\n","장애인",dis.disable);
		System.out.printf("%s\t\t : %d매\n","국가유공자",dis.merit);
		System.out.printf("%s\t\t\t : %d매\n","다자녀",dis.multichild);
		System.out.printf("%s\t\t\t : %d매\n","임산부",dis.pregnant);
		System.out.println("--------------------------------------------------------------------------------------------");
	}
}

