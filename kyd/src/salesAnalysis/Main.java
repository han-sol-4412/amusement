package salesAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException{
		SalesAnalysis sale = new SalesAnalysis();
		sale.readFile();
		sale.fullInfo();
		sale.ticketType_age();

		
	}
}
