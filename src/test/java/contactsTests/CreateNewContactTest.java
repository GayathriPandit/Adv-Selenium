package contactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilites.BaseClass;
import genericUtilites.ExcelFileUtility;
import genericUtilites.ProprtyFileUtility;
import genericUtilites.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(value = genericUtilites.ListenersImplementation.class)
public class CreateNewContactTest extends BaseClass
{
	@Test(groups = {"SmokeSuite","RegressionSuite"})
	public void createContactWithMandatoryfeilds() throws Throwable 
	
	{
				
		/*Read data from excel file*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		//Step 3: Navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Step 4: Click on Create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.createContact();
		 //Assert.fail();
		
		 //Step 5; Create Contact with mandatory fields and save
		 CreateNewContactPage cncp = new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME);
		 
		
		 
		   //Step 6: Validate for Contact
		  ContactInfoPage cip = new ContactInfoPage(driver);
		  String contactHeader = cip.captureHeaderText();
		  Assert.assertTrue(contactHeader.contains(LASTNAME));
		  System.out.println(contactHeader);
		  

	}
    @Test
	public void sample()
	{
		System.out.println("demo");
	}
}
