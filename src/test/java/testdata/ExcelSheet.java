package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] readData(String sheetname){
		FileInputStream file=null;
		
		try {
			file=new FileInputStream("C:\\Users\\abhig\\eclipse-workspace\\orangeart\\src\\test\\java\\testdata\\Details.xlsx");
		}
		catch(FileNotFoundException f) {
			f.printStackTrace();
		}
		
		try {
		book = WorkbookFactory.create(file);
		}
		catch(IOException a) {
			a.printStackTrace();
		}
		
		
		 sheet = book.getSheet(sheetname);
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				
				
			}//nested for loop ends here
			
		}//for loop ends here
		
	return data;
		
	}//readData method ends here

}//Class ExcelSheet ends here
