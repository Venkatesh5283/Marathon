package Marathon_Salesforce;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import defaultpackage.BaseClass;

public class ExcelIntegrationMarathon  {
	
	public static String[][] excelDataFetching(String filename) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./InputFiles/"+filename+".xlsx");
		
		XSSFSheet sheetAt = wb.getSheetAt(0);
		
		int lastRowNum = sheetAt.getLastRowNum();
		
		int lastCellNum = sheetAt.getRow(0).getLastCellNum();
		
		String[][] data = new String[lastRowNum][lastCellNum];
		
		for (int i = 1; i <=lastRowNum; i++) {
			
			XSSFRow row = sheetAt.getRow(i);
			
			for (int j = 0; j < lastCellNum; j++) {
				
				String stringCellValue = row.getCell(j).getStringCellValue();
				
				System.out.println(stringCellValue);
				
				data[i-1][j]=stringCellValue;
				
			}
			
		}
		wb.close();
		return data;
	}
		
		
}
