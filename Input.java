package amusement;

import java.util.Scanner;

public class Input {
	//입력클래스
	Scanner stdIn = null;
	
	public Input() { 
		//생성자
		stdIn = new Scanner(System.in); 
	}
	
	protected void finalize() {
		//소멸자
		stdIn.close();
	}
	
	public int ticketType() {
		// 권종 입력받기
		System.out.println("권종을 선택하세요.\n"
				+ "1. 주간권\n"
				+ "2. 야간권");
		
		int ticketType = stdIn.nextInt();
		if(!(ticketType == 1 || ticketType == 2)) {
			System.out.println("잘못된 숫자를 입력했습니다. 다시 입력하세요.");
			this.ticketType();
		}
		return ticketType;
	}
	
	public String idNum() {
		//주민번호 입력받기
		System.out.println("주민번호를 입력하세요. (\"-\"를 제외하고 입력하시오.)");
		String idNum = stdIn.next();
		if(idNum.length()!=13) {
			System.out.println("잘못된 주민등록번호를 입력했습니다. 다시 입력하세요");
			this.idNum();
		}
		return idNum;
	}
	
	public int ticketCount() {
		//티켓 갯수 입력받기
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		int ticketCount = stdIn.nextInt();
		if(ticketCount >10) {
			System.out.println("최대 10개의 표를 구매할 수 있습니다.");
			this.ticketCount();
		}
		return ticketCount;
	}
	
	public int discountCode() {
		// 우대사항 입력받기
		System.out.println("우대사항을 선택하세요.\n"
				+ "1. 없음 (나이 우대 자동처리)\n"
				+ "2. 장애인 \n"
				+ "3. 국가 유공자\n"
				+ "4. 다자녀 \n"
				+ "5. 임산부");
		int discountCode = stdIn.nextInt();
		if(!(discountCode == 1 || discountCode == 2 || discountCode == 3 || discountCode == 4 || discountCode == 5 )) {
			System.out.println("잘못된 숫자를 입력했습니다. 다시 입력하세요.");
			this.discountCode();
		}
		return discountCode;
	}
	
	public int continueBuyTicket() {
		// 발권 진행 여부 입력받기
		System.out.println("계속 발권주문을 하시겠습니까?\n"
				+ "1. 주문하기\n"
				+ "2. 계산하기");
		return stdIn.nextInt();
	}
	
}
