package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public ProductPage pp;
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement email_id;
	
	@FindBy(id="userPassword")
	WebElement pwd;
	
	@FindBy(id="login")
	WebElement login_button;
	
	public ProductPage enter_credentials_loginpage(String str1,String str2)
	{
		email_id.sendKeys(str1);
		pwd.sendKeys(str2);
		login_button.click();
		 pp = new ProductPage(driver);
		return pp;
	}
	
	public void  url()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
}
