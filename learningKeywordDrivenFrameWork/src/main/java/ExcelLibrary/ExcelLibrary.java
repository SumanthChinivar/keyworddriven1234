package ExcelLibrary;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public ArrayList<String> readFromExcel() throws EncryptedDocumentException, IOException{
		File file=new File("./src/test/resources/ExcelData/TestCase.xlsx");
		FileInputStream fis=new FileInputStream(file);
		
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet("Sheet1");
		
		int rowNum=sheet.getPhysicalNumberOfRows();
		int colNum=sheet.getRow(0).getPhysicalNumberOfCells();
		
		ArrayList<String> keywords=new ArrayList<>();
		
		for(int i=1;i<rowNum;i++) {
			String data=sheet.getRow(i).getCell(3).toString();
			keywords.add(data);
			}
		return keywords;
	}
	
}
