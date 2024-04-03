package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login1Page 
{
	//Rule 1: Create a separate pom class for every web page
	
	//Rule 2: identify the web elements using @FindBY and make them private
     @FindBy(name="user-name")
     private WebElement userNameEdt;
     
     @FindBy(id="password")
     private WebElement passwordEdt;
     
     @FindBy(id="login-button")
     private WebElement loginBtn;
     
   //Rule 3: Create a constructor for initialization
 	public Login1Page(WebDriver driver)
 	{
 		PageFactory.initElements(driver, this);
 	}

 	
 	//Rule 4:Provide getters
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
 	
	//business library - generic method
	
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
 	
}
