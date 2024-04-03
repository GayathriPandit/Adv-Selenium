package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Scenario5WithDDT 
{
	public static void main(String[] args) throws IOException {
		//Read data from property file
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		
		 String URL = p.getProperty("url");
		 String USERNAME = p.getProperty("usernamr");
		 String PASSWORD = p.getProperty("password");
		 
		 //Read data from excel file
		 FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		 Workbook wb = WorkbookFactory.create(fise);
		 
		 
		
	}

}
