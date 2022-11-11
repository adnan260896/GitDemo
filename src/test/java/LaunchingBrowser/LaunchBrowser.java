package LaunchingBrowser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectModel.LoginPage;

public class LaunchBrowser {

	public WebDriver driver;
	public LoginPage lp;
	
	
	public WebDriver Basic_Credentials() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis  = new FileInputStream("C:\\Users\\Asus\\eclipse-workspace\\LetsShopWebsite\\Property\\browser.Properties");
	    prop.load(fis);
	   // ChromeOptions options  = new ChromeOptions();
	    //options.addArguments("headless");
	    
	    String brw = System.getProperty("browser")!= null ? System.getProperty("browser"): prop.getProperty("chrome");
		//String brw =prop.getProperty("browser");
		
		if(brw.contains("chrome"))
		{
			ChromeOptions options  = new ChromeOptions();
			if (brw.contains("headless"))
			{
		    options.addArguments("headless");
			}
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			 driver = new ChromeDriver(options);
			 driver.manage().window().setSize(new Dimension(1440,900));
	       }
		   driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	       return driver;
	}
	@BeforeMethod(alwaysRun = true)
	public LoginPage Start_browser() throws IOException
	{
		driver =Basic_Credentials();
		 lp = new LoginPage(driver);
		lp.url();
		return lp;
		
	}
	
	/*@AfterTest
	public void close_Browser()
	{
		driver.close();
	}*/
	
	public String Screenshot(String testcasename ,WebDriver driver) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+ "//folder//"+ testcasename+".png"));
		return (System.getProperty("user.dir") + "//folder//" + testcasename + ".png");
	}
}
