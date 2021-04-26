package amusement;
	//주민등록번호에 따른 나이 추출 및 나이 코드 적용
public class ProcessingAgeGroup {
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
}
