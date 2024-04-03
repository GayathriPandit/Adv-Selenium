package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilites.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility
{
	//Rule 1: Create a separate pom class for every web page
	
			//Rule 2: identify the web elements using @FindBY and make them private
		@FindBy(name="lastname")
		private WebElement LastNameEdt;
		
		@FindBy(xpath="//input[@class=\"crmButton small save\"]")
		private WebElement SaveBtn;
		
		@FindBy(name = "leadsource")
		private WebElement leadSourceDropDown;
		
		//Rule 3: Create a constructor for initialization
			public CreateNewContactPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
			//Rule 4:Provide getters
			public WebElement getLastnameEdt() {
				return LastNameEdt;
			}

			public WebElement getSaveBtn() {
				return SaveBtn;
			}
			
			public WebElement getLeadSourceDropDown(){
				 return leadSourceDropDown;
			}
			//business library - generic method
			/**
			 * This method will create new contact 
			 * @param lastname
			 */
			public void createNewContact(String lastname)
			{
				LastNameEdt.sendKeys(lastname);
				SaveBtn.click();
			}
			
			public void createNewContact(String lastname, String leadSourceValue)
			{
				LastNameEdt.sendKeys(lastname);
				handleDropDown(leadSourceDropDown, leadSourceValue);
				SaveBtn.click();
			}
}
