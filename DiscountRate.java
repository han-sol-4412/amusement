package amusement;
	//우대 종류에 따른 할인율 정하는 클래스
public class DiscountRate {
	public double discount(int discountCode) {
		double discountRate = 0.0;
		if(discountCode==ConstValue.DISABLE_DISCOUNT_CODE) {
			discountRate = 1 - ConstValue.DISABLE_DISCOUNT_RATE;
		} else if(discountCode==ConstValue.MERIT_DISCOUNT_CODE) {
			discountRate = 1 - ConstValue.MERIT_DISCOUNT_RATE;
		} else if(discountCode==ConstValue.MULTICHILD_DISCOUNT_CODE) {
			discountRate = 1 - ConstValue.MULTICHILD_DISCOUNT_RATE;
		} else if(discountCode==ConstValue.PREGNANT_DISCOUNT_CODE) {
			discountRate = 1 - ConstValue.PREGNANT_DISCOUNT_RATE;
		} else {
			discountRate = 1;
		}
		return discountRate;
	}
}
