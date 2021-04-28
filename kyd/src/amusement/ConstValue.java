package amusement;

import java.util.Calendar;

//상수 클래스
public class ConstValue {
	//권종 구분 코드
	final static int DAY_CODE = 1;
	final static int NIGHT_CODE = 2;
	
	final static int CALCULATE_EXIT = 2; //계산하고 종료하는 코드
	
	//나이 구분 코드
	final static int ADULT_CODE = 1;
	final static int TEEN_CODE = 2;
	final static int CHILD_CODE = 3;
	final static int OLD_CODE = 4;
	final static int BABY_CODE = 5;
	
	// 권종과 나이에 따른 가격
	final static int ADULT_DAY_PRICE = 56000;
	final static int TEEN_DAY_PRICE = 47000;
	final static int CHILD_DAY_PRICE = 44000;
	final static int OLD_DAY_PRICE = 44000;
	final static int BABY_DAY_PRICE = 0;
	
	final static int ADULT_NiGHT_PRICE = 46000;
	final static int TEEN_NiGHT_PRICE = 40000;
	final static int CHILD_NiGHT_PRICE = 37000;
	final static int OLD_NiGHT_PRICE = 37000;
	final static int BABY_NiGHT_PRICE = 0;
	
	//우대할인 코드
	final static int NO_DISCOUNT_CODE = 1; 
	final static int DISABLE_DISCOUNT_CODE = 2; 
	final static int MERIT_DISCOUNT_CODE = 3;
	final static int MULTICHILD_DISCOUNT_CODE = 4;
	final static int PREGNANT_DISCOUNT_CODE = 5;
	
	//우대 할인율
	final static double DISABLE_DISCOUNT_RATE = 0.4; 
	final static double MERIT_DISCOUNT_RATE = 0.5;
	final static double MULTICHILD_DISCOUNT_RATE = 0.2;
	final static double PREGNANT_DISCOUNT_RATE = 0.15;
	
	//파일저장 경로
	final static String FILEPATH = "C:\\Users\\sol\\Desktop\\amusement.csv";

}
