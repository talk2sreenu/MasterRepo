package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils{

	private static XSSFSheet wSheet;
	private static XSSFWorkbook wBook;
	private static XSSFCell wCell;
	
	String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\excelUtils\\TestData.xlsx";
	
	public void testDriverFile() {
		System.out.println("This is for testing purpose");
		try {
			FileInputStream fis = new FileInputStream(filePath);
			wBook = new XSSFWorkbook(fis);
			wSheet = wBook.getSheetAt(0);
			int rwCnt = wSheet.getLastRowNum() - wSheet.getFirstRowNum();
			for(int i =1;i<=rwCnt;i++)
			{
				Row row = wSheet.getRow(i);
				String temp = row.getCell(2).getStringCellValue();
				String tcName = row.getCell(0).getStringCellValue();
				String tcDesc = row.getCell(1).getStringCellValue();
				if(temp.equalsIgnoreCase("Yes"))
				System.out.println(tcName+" has "+tcDesc+" value with driver set to "+temp);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
