package amusement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import kyd.Variable;

//파일 출력 클래스
public class OutputFile {
	public boolean isFileExist;
	public BufferedWriter writer;
	
	public OutputFile() throws IOException{
		File file = new File(ConstValue.FILEPATH);
		if(file.exists()) { //존재하면
			isFileExist = true; 
		} else {
			isFileExist = false;
		}
		writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ConstValue.FILEPATH,true), "euc-kr"));
	}
	
	public void headerWrite() throws IOException{
		if(!isFileExist) {
			String header = "날짜,권종,연령구분,수량,가격,우대사항\n"; 
			writer.write(header);
		}
	}
	
	public void dataWrite(SaveValue saveV) throws IOException{ //데이터 쓰기
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); 
		Calendar calt = Calendar.getInstance(); 
	
		String s = sdt.format(calt.getTime())+","+saveV.ticketTypeCode+","+saveV.ageCode+","+saveV.ticketCount+","+saveV.finalPrice+","+saveV.discountType+"\n";
		writer.write(s);	
	}
	
	public void fileClose() throws IOException{ //파일 쓰기 종료
		writer.close();
	}
}
