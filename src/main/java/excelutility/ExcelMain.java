package excelutility;
import java.io.IOException;

public class ExcelMain {

	public static void main(String[] args)throws IOException{
		
	// TODO Auto-generated method stub
		String s=ReadExcelcode.readStringData(1, 0);
		System.out.println(s);
		String s1=ReadExcelcode.readIntegerData(1, 1);
		System.out.println(s1);
	}

}
