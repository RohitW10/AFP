package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private Sheet sheet;

	public ExcelUtils(String filePath, String sheetName) {

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = new XSSFWorkbook(fis)) {
			this.sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getCellData(int rowNum, int colNum) {
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);

		if (cell == null)
			return "";

		switch (cell.getCellType()) {

		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell))
				return String.valueOf(cell.getDateCellValue());
			else
				return String.valueOf(cell.getNumericCellValue());
		case BOOLEAN:
			String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			cell.getCellFormula();
		default:
			return "";

		}
	}

	public int getRowCount() {
		return sheet.getLastRowNum() + 1;
	}

	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}
}
