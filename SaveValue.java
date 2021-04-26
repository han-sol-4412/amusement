package amusement;
	//주문 내역 저장 변수만 모아놓은 클래스
public class SaveValue {
	int ticketTypeCode; //티켓권종코드
	int ageCode; //연령코드 
	int ticketCount; // 티켓수량
	int originalPrice; // 할인을 적용하기 전 가격
	int discountCode; // 할인 적용 코드
	int finalPrice; //할인을 적용한 후 가격
	
	//생성자로 값 저장하기
	public SaveValue(int ticketTypeCode, int ageCode, int ticketCount, int originalPrice, int discountCode, int finalPrice) {
		this.ticketTypeCode = ticketTypeCode;
		this.ageCode = ageCode;
		this.ticketCount = ticketCount;
		this.originalPrice = originalPrice;
		this.discountCode = discountCode;
		this.finalPrice = finalPrice;
	}
	
	
}
