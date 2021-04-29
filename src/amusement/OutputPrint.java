package amusement;
	//출력클래스
public class OutputPrint {
	public void printEachPrice(SaveValue saveV) {
		System.out.printf("가격은 %d원 입니다.\n",saveV.finalPrice);
	}
	
	public void header() {
		System.out.println("===============에버랜드================");
	}
	
	public void totalInfo(SaveValue saveV) {
		System.out.printf("%s  %s  x  %d    %d    *우대적용(%s)\n",
				saveV.ticketTypeCode, saveV.ageCode, saveV.ticketCount, saveV.originalPrice*saveV.ticketCount, saveV.discountType);
	}
	
	public void totalPrice(int totalPrice) {
		System.out.printf("입장료 총액은 %d입니다.\n",totalPrice);
	}
}
