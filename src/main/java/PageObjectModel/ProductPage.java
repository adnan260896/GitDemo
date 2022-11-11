package PageObjectModel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.auto.common.Visibility;

public class ProductPage {

	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div[class*='col-lg-4 col-md-6 col']")
	List<WebElement> productlist;
	
	@FindBy(xpath="//ul/li[4]/button[@class='btn btn-custom']")
	WebElement cart1;
	
	By cart = By.cssSelector("button[class='btn w-10 rounded']");
	
	public WebElement Addtocart(String str3)
	{
		WebElement prod =productlist.stream().filter(s->s.findElement(By.cssSelector("h5[style='text-transform: uppercase;']")).getText().equals(str3)).findFirst().orElse(null);
	    return prod;
	}
	
	public void Click_addtocart(String str3)
	{
		Addtocart(str3).findElement(cart).click();
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(5));
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[4]/button[@class='btn btn-custom']")));
	}
	
	public MyCartPage CART()
	{
		WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(5));
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[4]/button[@class='btn btn-custom']")));
		cart1.click();
		MyCartPage mc = new MyCartPage(driver);
		return mc;
	}
}
