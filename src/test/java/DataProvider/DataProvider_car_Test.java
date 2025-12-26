package DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataProvider_car_Test {

	@DataProvider(name = "car_details")
	public Object[][] details() throws EncryptedDocumentException, IOException {
		
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\organisation.xlsx");
		Workbook work = WorkbookFactory.create(fi);
		Sheet sheet = work.getSheet("Car");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][cellcount];
		
		for(int i=0;i<rowcount;i++) {
			for(int j=0;j<cellcount;j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}	
		}
		return obj;
	}
	
}
