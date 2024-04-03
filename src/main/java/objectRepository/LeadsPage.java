package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage
{
	//Rule 1: Create a separate pom class for every web page
	
			//Rule 2: identify the web elements using @FindBY and make them private
	          @FindBy(xpath="//img[@alt=\"Create Lead...\"]")
	          private WebElement CreateLeadLookUpImg;
	          
	          //Rule 3: Create a constructor for initialization
	          public LeadsPage(WebDriver driver)
	          {
	        	  PageFactory.initElements(driver, this);
	          }
	  
	          //Rule 4:Provide getters for utilization
	          public WebElement getCreateLeadBtn() 
	          {
	  			return CreateLeadLookUpImg;
	  	   	}
	        //business library - generic method
	          /**
	           * This method will click on create contact look up image
	           */
	          public void createLead()
	          {
	        	  CreateLeadLookUpImg.click();
	          }
	  		

}
