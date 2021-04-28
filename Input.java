package amusement;

import java.util.Scanner;

public class Input {
	//입력클래스
	Scanner stdIn = null;
	
	public Input() { //생성자
		stdIn = new Scanner(System.in); 
	}
	
	protected void finalize() { //소멸자
		stdIn.close();
	}
	
	public int ticketType() {
		// 권종 입력받기
		System.out.println("권종을 선택하세요.\n"
				+ "1. 주간권\n"
				+ "2. 야간권");
		String ticketType= stdIn.next();
		if(!(ticketType.equals("1") || ticketType.equals("2"))) {
			System.out.println("잘못된 숫자를 입력했습니다. 다시 입력하세요.");
			ticketType= this.ticketType()+"";
		}
		return Integer.parseInt(ticketType);
	}
	
	public String idNum() {
		//주민번호 입력받기
		System.out.println("주민번호를 입력하세요. (\"-\"를 제외하고 입력하시오.)");
		String idNum = stdIn.next();
		if(idNum.length()!=13) {
			System.out.println("잘못된 주민등록번호를 입력했습니다. 다시 입력하세요");
			idNum = this.idNum();
		}
		return idNum;
	}
	
	public int ticketCount() {
		//티켓 갯수 입력받기
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		String ticketCount = stdIn.next();
		if(!(ticketCount.equals("1") || ticketCount.equals("2") || ticketCount.equals("3") || ticketCount.equals("4") || ticketCount.equals("5")
				|| ticketCount.equals("6") || ticketCount.equals("7") || ticketCount.equals("8") || ticketCount.equals("9") || ticketCount.equals("10"))) {
			System.out.println("최대 10개의 표를 구매할 수 있습니다.");
			ticketCount = this.ticketCount()+"";
		}
		return Integer.parseInt(ticketCount);
	}
	
	public int discountCode() {
		// 우대사항 입력받기
		System.out.println("우대사항을 선택하세요.\n"
				+ "1. 없음 (나이 우대 자동처리)\n"
				+ "2. 장애인 \n"
				+ "3. 국가 유공자\n"
				+ "4. 다자녀 \n"
				+ "5. 임산부");
		String discountCode = stdIn.next();
		if(!(discountCode.equals("1") || discountCode.equals("2") || discountCode.equals("3") || discountCode.equals("4") || discountCode.equals("5"))) {
			System.out.println("잘못된 숫자를 입력했습니다. 다시 입력하세요.");
			discountCode = this.discountCode()+"";
		}
		return  Integer.parseInt(discountCode);
	}
	
	public int continueBuyTicket() {
		// 발권 진행 여부 입력받기
		System.out.println("계속 발권주문을 하시겠습니까?\n"
				+ "1. 주문하기\n"
				+ "2. 계산하기");
		String continueValue =  stdIn.next();
		if(!(continueValue.equals("1") || continueValue.equals("2"))) {
			System.out.println("잘못된 숫자를 입력했습니다. 다시 입력하세요.");
			continueValue =  this.continueBuyTicket()+"";
		}
		return Integer.parseInt(continueValue);
	}	
}
