package contactsTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilites.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

public class CreateContactWithLeadSourceTest extends BaseClass
{
	@Test
	public void createContactWithLead() throws Throwable 
	{
		/*Read data from excel file*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);
		
		//Step 3: Navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Step 4: Click on Create Contact Look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.createContact();
		
		 //Step 5; Create Contact with mandatory fields and save
		 CreateNewContactPage cncp = new CreateNewContactPage(driver);
		 cncp.createNewContact(LASTNAME, LEADSOURCE);;
		 
		   //Step 6: Validate for Contact
		  ContactInfoPage cip = new ContactInfoPage(driver);
		  String contactHeader = cip.captureHeaderText();
		  Assert.assertTrue(contactHeader.contains(LASTNAME));
		  System.out.println(contactHeader);
	}

}
