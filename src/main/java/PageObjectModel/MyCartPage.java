package PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {

	WebDriver driver;
	public ShippingPage sp;
	public MyCartPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@class='cart']/ul/li/div/div/h3")
	List<WebElement> product_names;
	
	@FindBy(xpath="//div[@class='cartSection removeWrap']/button[text()='Buy Now']")
	WebElement buy_now;
	
	public Boolean Check_product(String str3)
	{
		Boolean bol =product_names.stream().anyMatch(s->s.findElement(By.xpath("//div[@class='cart']/ul/li/div/div/h3")).getText().equalsIgnoreCase(str3));
	    return bol;
	 }
	
	public ShippingPage Click_Buy_now()
	{
		buy_now.click();
		 sp = new ShippingPage(driver);
		 return sp;
	}
	
	/*public void Screenshot() throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\ScreenShot\\MyCart.png"));
		//return (System.getProperty("user.dir") + "//folder//" + testcasename + ".png");
	}*/
	
	
}
