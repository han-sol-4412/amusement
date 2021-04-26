package amusement;

public class Main {
	//메인클래스
	public static void main(String[] args) {
		Input in = new Input();
		ProcessingIdNum idnum = new ProcessingIdNum();
		ProcessingAgeGroup ag = new ProcessingAgeGroup();
		ProcessingOriginPrice op = new ProcessingOriginPrice();
		ProcessingDiscount discount = new ProcessingDiscount();
		CalculatorPrice price = new CalculatorPrice();
		OutputPrint print = new OutputPrint();
		SaveValue[] saveV = new SaveValue[10];
		int count =0;
		while(true) {
			int ticketType = in.ticketType();
			String idNum = in.idNum();
			int ticketCount = in.ticketCount();
			int discountCode = in.discountCode();
			
			int year = idnum.birth(idNum);
			int age = idnum.age(year);
			int agecode = ag.agePrice(age);
			int originalPrice = op.originalPrice(ticketType, agecode);
			double discountRate = discount.discount(discountCode);
			int finalPrice = price.eachPrice(originalPrice, ticketCount, discountRate);
			
			//결과값 저장하기
			saveV[count] = new SaveValue(ticketType,agecode,ticketCount,originalPrice,discountCode,finalPrice);
			print.printEachPrice(saveV[count]);
			count++;
			
			int continueBuyTicket;
			continueBuyTicket = in.continueBuyTicket();
			if(continueBuyTicket==2) break;
		}
		
		int totalPrice = 0;
		print.header();
		for(int i=0; i<count; i++) {
			print.totalInfo(saveV[i]);
			totalPrice+=saveV[i].finalPrice;
		}
		print.totalPrice(totalPrice);
		
	}

}
