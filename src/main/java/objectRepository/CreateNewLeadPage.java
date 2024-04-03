package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage
{
	//Rule 2: identify the web elements using @FindBY and make them private
	 @FindBy(name="lastname")
	 private WebElement LastNameEdt;
	 
	 @FindBy(name="company")
	 private WebElement CompanyNameEdt;
	 
	 @FindBy(xpath="//input[@class=\"crmButton small save\"]")
	 private WebElement SaveBtn;
	 
	//Rule 3: Create a constructor for initialization
	 public CreateNewLeadPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	//Rule 4:Provide getters
	  public WebElement getLastNameEdt() {
		return LastNameEdt;
	  }

	 public WebElement getSaveBtn() {
		return SaveBtn;
	 }
	 
	 public WebElement getCompanyNameEdt() {
		return CompanyNameEdt;
	}
	/**
	  * This method will create new lead
	  * @param lastname
	  */
	 public void CreateNewLead(String lastname, String company)
	 {
		 LastNameEdt.sendKeys(lastname);
		 CompanyNameEdt.sendKeys(company);
		 SaveBtn.click();
	 } 
	
	 
}
