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
		return 0;
	}
	
	public String idNum() {
		//주민번호 입력받기
		return null;
	}
	
	public int ticketCount() {
		//티켓 갯수 입력받기
		return 0;
	}
	
	public int discountCode() {
		// 우대사항 입력받기
		return 0;
	}
	
	public int continueBuyTicket() {
		// 발권 진행 여부 입력받기
		return 0;
	}
	
}
