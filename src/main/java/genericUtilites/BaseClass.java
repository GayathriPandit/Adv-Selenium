package genericUtilites;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;
/**
 * This method consists of basic configurations
 * @author Gayathri_93
 *
 */
public class BaseClass
{
	public ProprtyFileUtility pUtil = new ProprtyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public WebDriver driver;
	
	
	//for listeners
	public static WebDriver sDriver;
	
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("=====DB Connection successful=====");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String URL = pUtil.readDataFromPropertyFile("url");
		
		driver = new EdgeDriver();
		
		/*if(BROWSER.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new EdgeDriver(); 
		}*/
		sUtil.maximizewindow(driver);
		sUtil.addImplicitlywait(driver);
		
		driver.get(URL);
		
		//for listeners
		sDriver=driver;
		
		System.out.println("=====Browser launch successful=====");
	}

	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("=====Login to App successful=====");
	}
	//@AfterTest
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws Throwable
	{
		Thread.sleep(10);
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		
		System.out.println("=====Logout of App successful=====");
	}
	
	@AfterSuite(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("=====Browser closure successful=====");
	}
}
