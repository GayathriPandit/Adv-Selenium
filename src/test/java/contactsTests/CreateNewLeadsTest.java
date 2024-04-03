package contactsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilites.BaseClass;
import genericUtilites.ExcelFileUtility;
import genericUtilites.ProprtyFileUtility;
import genericUtilites.SeleniumUtility;
import objectRepository.CreateNewLeadPage;
import objectRepository.HomePage;
import objectRepository.LeadsPage;

public class CreateNewLeadsTest extends BaseClass
{
	@Test(groups = "RegressionSuite")
	public void createLeadsWithMandatoryfeilds() throws Throwable
	{
	               	/*read data from excel file*/
					String LASTNAME = eUtil.readDataFromExcel("LEADS", 1, 2);
					String COMPANYNAME = eUtil.readDataFromExcel("LEADS", 1, 3);
					
					//Step 3: Navigate to Lead link
					HomePage hp = new HomePage(driver);
					hp.clickOnLeadsLink();
					
					//Step 4: Click on Create Lead Look up image
					LeadsPage lp = new LeadsPage(driver);
					lp.createLead();
					
					//Step 5: Create Lead with mandatory fields and save
					CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
					cnlp.CreateNewLead(LASTNAME, COMPANYNAME);
					
				    //Step 6: Validate for Lead
					LeadInfoPage lip = new LeadInfoPage(driver);
					String leadHeader = lip.captureHeaderText();
					Assert.assertTrue(leadHeader.contains(LASTNAME));
					System.out.println(leadHeader);
					 
		}


}
