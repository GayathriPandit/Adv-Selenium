package genericUtilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Gayathri_93
 *
 */

public class ExcelFileUtility 
{
	//26/02/24
	/**
	 * This method will read data from excel file and return the value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetname, int rowNo, int cellNo) throws Throwable
	{
		FileInputStream fis	=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return  value;
	}
	public double readNumericDataFromExcel(String sheetname, int rowNo, int cellNo) throws Throwable
	{
		FileInputStream fis	=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		double value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		return  value;
	}
}
