package LaunchingBrowser;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectModel.MyCartPage;
import PageObjectModel.ProductPage;
import PageObjectModel.ShippingPage;



public class TestMainTest extends LaunchBrowser{

	@Test(dataProvider = "get_inputs" ,groups = "MainTest")
	public void main(String str1, String str2) throws InterruptedException, IOException
	{
		/*String str1 = "abc123@hello.com";
		String str2 = "Abc@1234";*/
		String str3 = "ADIDAS ORIGINAL";
		String str4 = "Germany";
		ProductPage pp=lp.enter_credentials_loginpage(str1, str2);
		WebElement prod=pp.Addtocart(str3);
		pp.Click_addtocart(str3);
		Thread.sleep(5000);
		//WebDriverWait wb = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[4]/button[@class='btn btn-custom']")));
		MyCartPage mc= pp.CART();
		//mc.Screenshot();
		Boolean bol =mc.Check_product(str3);
		Assert.assertTrue(bol);
		ShippingPage sp =mc.Click_Buy_now();
		sp.Enter_Country(str4);
		//Thread.sleep(5000);
		sp.get_price();
				
		
		
	}
	
	@DataProvider
	public Object[][] get_inputs()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0]= "abc123@hello.com";
		obj[0][1]="Abc@1234";
		obj[1][0] = "abc123@hello.com";
		obj[1][1]=	"Abc@12345";
		obj[2][0]= "abc123@hello.com";
		obj[2][1]= "Abc@123456";
		
		return obj;
	}
}
