package amusement;
	//주문 내역 저장 변수만 모아놓은 클래스
public class SaveValue {
	String ticketTypeCode; //티켓권종코드
	String ageCode; //연령코드 
	int ticketCount; // 티켓수량
	int originalPrice; // 할인을 적용하기 전 가격
	String discountType; // 할인 적용 코드
	int finalPrice; //할인을 적용한 후 가격
	
	//생성자로 값 저장하기
	public SaveValue(int ticketTypeCode, int ageCode, int ticketCount, int originalPrice, int discountCode, int finalPrice) {
		if(ticketTypeCode==ConstValue.DAY_CODE) {
			this.ticketTypeCode = "주간권";
		} else {
			this.ticketTypeCode = "야간권";
		}
		
		if(ageCode == ConstValue.ADULT_CODE) {
			this.ageCode ="대인";
		} else if(ageCode == ConstValue.TEEN_CODE) {
			this.ageCode ="청소년";
		} else if(ageCode == ConstValue.CHILD_CODE) {
			this.ageCode ="소인";
		} else if(ageCode == ConstValue.OLD_CODE) {
			this.ageCode ="경로";
		} else {
			this.ageCode ="유아(무료)";
		}

		this.ticketCount = ticketCount;
		this.originalPrice = originalPrice;
		
		if(discountCode == ConstValue.DISABLE_DISCOUNT_CODE) {
			discountType="장애인";
		} else if(discountCode == ConstValue.MERIT_DISCOUNT_CODE) {
			discountType="국가유공자";
		} else if(discountCode == ConstValue.MULTICHILD_DISCOUNT_CODE) {
			discountType="다자녀";
		} else if(discountCode == ConstValue.PREGNANT_DISCOUNT_CODE){
			discountType="임산부";
		} else {
			discountType="없음";
		}
		this.finalPrice = finalPrice;
	}
	
}
