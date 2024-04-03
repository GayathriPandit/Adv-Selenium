package contactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage
{
    //Rule 1: Create a separate pom class for every web page
	
	//Rule 2: identify the web elements using @FindBY and make them private
	 @FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	 private WebElement LeadHeaderText;
	 
	//Rule 3: Create a constructor for initialization
	public LeadInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4:Provide getters

	public WebElement getLeadHeaderText() {
		return LeadHeaderText;
	}
	//business library - generic method
	/**
	 * This method will capture the header text and return it to caller
	 * @return
	 */
	public String captureHeaderText()
	{
		return LeadHeaderText.getText();
	}

}
