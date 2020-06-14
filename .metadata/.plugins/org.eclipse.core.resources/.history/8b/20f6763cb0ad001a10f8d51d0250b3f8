package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fileInputs = null ; 

	public FileInputStream getFileInputStream() 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/testdata/UserData.xlsx"; 
		File sourceFile = new File(filePath);

		try {
			fileInputs = new FileInputStream(sourceFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found : Check the file");
			System.exit(0);
		}
		return fileInputs; 
	}

	public Object[][] getExcelData() throws IOException
	{
		fileInputs = getFileInputStream(); 

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = 8; 

		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 

		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) 
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		workbook.close();
		return arrayExcelData; 
	}
}
