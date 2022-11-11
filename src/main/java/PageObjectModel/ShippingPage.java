package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShippingPage {
	WebDriver driver;
	public ShippingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="input[placeholder='Select Country']")
	WebElement Select_Country;
	
	@FindBy(css="section[class='ta-results list-group ng-star-inserted']")
	WebElement Select_Country_Option;
	
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement Place_Order;
	
	@FindBy(xpath="//div[@class='item__price']")
	WebElement price;
	
	public void Enter_Country(String str4)
	{
		Select_Country.sendKeys(str4);
		Select_Country_Option.click();
	}
	
	/*public void click_place_order()
	{
		Place_Order.click();
		Place_Order.click();
		
	}*/
	public void get_price()
	{
		System.out.println("Total price of Product is :" + price.getText());
	}
	
}
