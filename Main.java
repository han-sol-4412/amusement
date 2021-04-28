package amusement;

import java.io.IOException;

import kyd.FileOutput;

public class Main {
	//메인클래스
	public static void main(String[] args) throws IOException{
		Input in = new Input(); //입력 클래스
		OriginalPrice_By_IdNum op = new OriginalPrice_By_IdNum(); //주민등록번호 처리하여 할인전 금액을 구하는 클래스
		DiscountRate discount = new DiscountRate(); //우대적용코드에 따른 할인율 구하는 클래스
		CalculatorPrice price = new CalculatorPrice(); //가격을 구하는 클래스
		OutputPrint print = new OutputPrint(); //콘솔창에 결과를 출력하는 클래스
		OutputFile fw = new OutputFile(); //결과를 파일에 저장하는 클래스
		SaveValue[] saveV = new SaveValue[10]; // 결과를 변수로 모아 놓은 클래스
		int count =0; //SaveValue클래스 배열저장 인덱스 번호
		int totalPrice = 0; //총합
		
		while(true) {
			int ticketType = in.ticketType(); // 권종 입력받기
			String idNum = in.idNum(); // 주민등록번호 입력받기
			int ticketCount = in.ticketCount(); //티켓 갯수 입력받기
			int discountCode = in.discountCode(); //우대사항 입력받기
			
			int year = op.birth(idNum); //주민등록번호 받아 생년월일 추출
			int age = op.age(year); // 생년월일에서 나이 추출
			int agecode = op.agePrice(age); //나이에서 나이 코드로 변환
			int originalPrice = op.originalPrice(ticketType, agecode); // 나이코드와 권종코드에 따른 할인전 가격 구하기
			
			double discountRate = discount.discount(discountCode); //우대적용 코드에 따른 할인율 구하기
			int finalPrice = price.eachPrice(originalPrice, ticketCount, discountRate); // 할인율을 적용한 중간가격 구하기
			
			saveV[count] = new SaveValue(ticketType,agecode,ticketCount,originalPrice,discountCode,finalPrice); //결과값 저장하기
			print.printEachPrice(saveV[count]); //중간가격 출력
			
			//파일로 저장하기
			fw = new OutputFile();
			fw.headerWrite();
			fw.dataWrite(saveV[count]);
			fw.fileClose();
			
			count++;
			
			int continueBuyTicket = in.continueBuyTicket(); //발권 진행여부 입력받기
			if(continueBuyTicket==ConstValue.CALCULATE_EXIT) break; //반복문 종료하고 계산결과 출력
		}
		
		print.header(); //출력헤더
		for(int i=0; i<count; i++) {
			print.totalInfo(saveV[i]); // 각 출력 정보
			totalPrice = price.totalPrice(saveV[i].finalPrice); // 최종금액 구하는 함수 호출
		}
		print.totalPrice(totalPrice); //최종금액 출력
	}

}
