package amusement;
	// 나이와 권종에 따른 할인이 적용되기 전 금액구하는 클래스
public class ProcessingOriginPrice {
	public int originalPrice(int ticketType, int ageCode) {
		int originalPrice =0;
		if(ticketType == ConstValue.DAY_CODE) {
			
			if(ageCode == ConstValue.ADULT_CODE) {
				originalPrice = ConstValue.ADULT_DAY_PRICE;
			} else if(ageCode == ConstValue.TEEN_CODE) {
				originalPrice = ConstValue.TEEN_DAY_PRICE;
			} else if(ageCode == ConstValue.CHILD_CODE) {
				originalPrice = ConstValue.CHILD_DAY_PRICE;
			} else if(ageCode == ConstValue.OLD_CODE) {
				originalPrice = ConstValue.OLD_DAY_PRICE;
			} else {
				originalPrice = ConstValue.BABY_DAY_PRICE;
			}
			
		}
		
		if(ticketType == ConstValue.NIGHT_CODE) {
			if(ageCode == ConstValue.ADULT_CODE) {
				originalPrice = ConstValue.ADULT_NiGHT_PRICE;
			} else if(ageCode == ConstValue.TEEN_CODE) {
				originalPrice = ConstValue.TEEN_NiGHT_PRICE;
			} else if(ageCode == ConstValue.CHILD_CODE) {
				originalPrice = ConstValue.CHILD_NiGHT_PRICE;
			} else if(ageCode == ConstValue.OLD_CODE) {
				originalPrice = ConstValue.OLD_NiGHT_PRICE;
			} else {
				originalPrice = ConstValue.BABY_NiGHT_PRICE;
			}
		}
		return originalPrice;
	}
}
