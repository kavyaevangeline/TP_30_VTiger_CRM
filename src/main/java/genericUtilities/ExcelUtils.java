package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;



public class ExcelUtils {

	/**
	 * This method is used to read single data from excel
	 * @author Kavya
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Exception
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetname, int rowNo, int cellNo) throws Exception, IOException {
		
		FileInputStream singleCell = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(singleCell);
		Sheet sheet = work.getSheet(sheetname);
		String value = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	/**
	 * This method is used to read number from excel
	 *@author Kavya
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readnumberFromExcel(String sheetname, int rowNo, int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream singleCell = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(singleCell);
		Sheet sheet = work.getSheet(sheetname);
		Cell cel = sheet.getRow(rowNo).getCell(cellNo);
		DataFormatter data= new DataFormatter();
		String value= data.formatCellValue(cel);
		return value;
		
		
	}
	/**
	 * This method is used to read multiple data from excel
	 * @author Kavya
	 * @param sheetname
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> readMultipleDataFromExcel(String sheetname) throws Exception {
		
		FileInputStream multiCell = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(multiCell);
		Sheet sheet = work.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(0).getLastCellNum();
		
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=0;i<=rowCount;i++) {
			for(int j=0;j<cellCount;j++) {
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
		return list;
	}
	
	
	/**
	 * This method is used to get row count
	 * @author Kavya
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public int getRowCount(String sheetName) throws Exception {
		
		FileInputStream fi = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(fi);
		Sheet sheet = work.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		return rowcount;
		
	}
	
	/**
	 * This method is used to get cell count
	 * @author Kavya
	 * @param sheetName
	 * @return
	 * @throws Exception
	 */
	public int getCellCount(String sheetName) throws Exception {
		
		FileInputStream fi = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(fi);
		Sheet sheet = work.getSheet(sheetName);
		int cellcount=sheet.getRow(0).getLastCellNum();
		return cellcount;
	}
	
/**
 * This method is used to write data into excel
 * @author Kavya
 * @param sheetName
 * @param value
 * @throws IOException 
 * @throws EncryptedDocumentException 
 * @throws Exception
 */
	public void writeDataIntoExcel(String sheetName, String  value) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(fi);
		Sheet sheet=work.getSheet(sheetName);
		Row row=sheet.getRow(0);
		Cell cel = row.createCell(0);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(value);
		
		FileOutputStream fo = new FileOutputStream(IpathConstants.excelpath);
		work.write(fo);
		work.close();
		
	}
	
	@DataProvider
	public Object[][] getRowCellTestNG(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi = new FileInputStream(IpathConstants.excelpath);
		Workbook work = WorkbookFactory.create(fi);
		Sheet sheet = work.getSheet(sheetName);
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
