package sprint1;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String[][] getExcelData()  {
		
	
		String filenameLocation ="C:\\Testleaf\\SalesforceAutomation\\src\\test\\resources\\testdata\\LoginDetails.xlsx";
		
		XSSFWorkbook wbook = null;
		try {
			wbook = new XSSFWorkbook(filenameLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wbook.getSheetAt(0);
		
		int rowCount = sheet.getLastRowNum();//Find Row
		System.out.println("The Total no of rows:"+rowCount);
		
		
		short columnCount = sheet.getRow(rowCount).getLastCellNum();//Find Column
		System.out.println("The total no of column:"+columnCount);
		

		String[][] data = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			
			for (int j = 0; j < columnCount; j++) {
				XSSFCell cell = eachRow.getCell(j);
				DataFormatter dft =new DataFormatter();
				String value =dft.formatCellValue(cell);
				
				System.out.println(value);
				data[i-1][j]=value;
			}
			
		}
		try {
			wbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
}
	}


