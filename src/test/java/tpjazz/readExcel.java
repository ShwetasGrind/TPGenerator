package tpjazz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcel {

	public static String getExcelData(String ExcelPath, String Sheet, int row, int column) throws IOException {
		File source = new File(ExcelPath);
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet(Sheet);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		wb.close();
		return data;
	}

	public static int getRowCount(String ExcelPath, String Sheet) throws IOException {
		File source = new File(ExcelPath);
		FileInputStream fis = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheet(Sheet);
		int rowCount = sheet1.getLastRowNum();
		return rowCount;

	}

}
