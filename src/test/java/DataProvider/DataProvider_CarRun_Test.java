package DataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtils;

public class DataProvider_CarRun_Test {
	
	@Test(dataProvider = "getdata")
	public void execute(String name, String details) throws EncryptedDocumentException, IOException {
		
		System.out.println(name+"--->"+details);
		
	}

	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		
		ExcelUtils eLibs = new ExcelUtils();
		 Object[][] value = eLibs.getRowCellTestNG("Car");
		
		return value;
	}
	
	
}
