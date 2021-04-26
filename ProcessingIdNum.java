package amusement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

//주민등록번호 처리하는 클래스 => 생년월일 추출 => 나이추출, 성별 추출
public class ProcessingIdNum {
	//주민등록번호에서 생일 년도 처리하기
	public int birth(String idNum) {
		if(idNum.length()!=13) {
			return 0;
		}
		if(idNum.substring(6, 7).equals("1") || idNum.substring(6, 7).equals("2")) {
			return 1900 + Integer.parseInt( idNum.substring(0, 2));
		} else {
			return 2000 + Integer.parseInt( idNum.substring(0, 2));
		}
	}
	
	//생일년도로 나이추출하기
	public int age(int birthYear) {
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY"); 
		Calendar cal = Calendar.getInstance(); 
		int currentYear = Integer.parseInt(sdt.format(cal.getTime()));
		return currentYear - birthYear +1;
	}
}
