package amusement;

import java.text.SimpleDateFormat;
import java.util.Calendar;
//주민등록번호 처리하여 할인전 금액을 구하는 클래스
public class OriginalPrice_By_IdNum {
	//주민등록번호에서 생일 년도 처리하기
	public int birth(String idNum) {
		if(idNum.substring(6, 7).equals("1") || idNum.substring(6, 7).equals("2")) {
			return 1900 + Integer.parseInt(idNum.substring(0, 2));
		} else {
			return 2000 + Integer.parseInt(idNum.substring(0, 2));
		}
	}
	
	//생일년도로 나이추출하기
	public int age(int birthYear) {
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY"); 
		Calendar cal = Calendar.getInstance(); 
		int currentYear = Integer.parseInt(sdt.format(cal.getTime()));
		return currentYear - birthYear +1;
	}
	
	//주민등록번호에 따른 나이 추출 및 나이 코드 적용
	public int agePrice(int age) {
		if(age>=19 && age <=64) {
			return ConstValue.ADULT_CODE;
		} else if(age >=13 && age <=18) {
			return ConstValue.TEEN_CODE;
		} else if(age >=3 && age <=12) {
			return ConstValue.CHILD_CODE;
		} else if(age >=65) {
			return ConstValue.OLD_CODE;
		} else {
			return ConstValue.BABY_CODE;
		}
	}
	
	// 나이와 권종 코드에 따른 할인이 적용되기 전 금액구하는 함수
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
