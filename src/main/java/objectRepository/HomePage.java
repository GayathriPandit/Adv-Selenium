package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilites.SeleniumUtility;

public class HomePage extends SeleniumUtility
{
	//Rule 1: Create a separate pom class for every web page
	
		//Rule 2: identify the web elements using @FindBY and make them private
		//Declaration - webelements - dropdowns, windows, frames, mouse hovering
		@FindBy(linkText="Contacts")
		private WebElement contactsLnk;
		
		@FindBy(linkText="Products")
		private WebElement productsLnk;
		
		@FindBy(linkText="Leads")
		private WebElement leadsLnk;
		
		@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
		private WebElement administratorImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement signoutLnk;
		
		//Rule 3: Create a constructor for initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Rule 4:Provide getters//utilization
		public WebElement getContactsLink() {
			return contactsLnk;
		}

		public WebElement getProductsLink() {
			return productsLnk;
		}

		public WebElement getLeadsLink() {
			return leadsLnk;
		}

		public WebElement getAdministratorImg() {
			return administratorImg;
		}

		public WebElement getSignoutBtn() {
			return signoutLnk;
		}
		//business library - generic method
		/**
		 * This method will logout of the Application click on contacts link in home page
		 */
		public void clickOnContactsLink()
		{
			contactsLnk.click();
		}
		/**
		 * This method will click on products link in home page
		 */
		public void clickOnProductsLink() 
		{
			productsLnk.click();
		}
		/**
		 * This method will click on leads link in home page
		 */
		public void clickOnLeadsLink() 
		{
			leadsLnk.click();
		}
		public void logoutOfApp(WebDriver driver) throws Throwable 
		{
			mouseHoverAction(driver, administratorImg);
			Thread.sleep(1000);
			signoutLnk.click();
		}
		
}

