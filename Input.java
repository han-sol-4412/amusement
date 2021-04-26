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
		return stdIn.nextInt();
	}
	
	public String idNum() {
		//주민번호 입력받기
		System.out.println("주민번호를 입력하세요. (\"-\"를 제외하고 입력하시오.)");
		return stdIn.next();
	}
	
	public int ticketCount() {
		//티켓 갯수 입력받기
		System.out.println("몇개를 주문하시겠습니까? (최대 10개)");
		return stdIn.nextInt();
	}
	
	public int discountCode() {
		// 우대사항 입력받기
		System.out.println("우대사항을 선택하세요.\n"
				+ "1. 없음 (나이 우대 자동처리)\n"
				+ "2. 장애인 \n"
				+ "3. 국가 유공자\n"
				+ "4. 다자녀 \n"
				+ "5. 임산부");
		return stdIn.nextInt();
	}
	
	public int continueBuyTicket() {
		// 발권 진행 여부 입력받기
		System.out.println("계속 발권하시겠습니까?\n"
				+ "1. 티켓 발권\n"
				+ "2. 종료");
		return stdIn.nextInt();
	}
	
}
