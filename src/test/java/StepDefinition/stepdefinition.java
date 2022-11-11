package StepDefinition;

import java.io.IOException;

import org.junit.Assert;

//import java.io.IOException;

import LaunchingBrowser.LaunchBrowser;
import PageObjectModel.LoginPage;
import PageObjectModel.MyCartPage;
import PageObjectModel.ProductPage;
import PageObjectModel.ShippingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition extends LaunchBrowser {
	public LoginPage lp;
	public ProductPage pp;
	public MyCartPage mc;
	public ShippingPage sp;
	@Given("Landing on Home Page")
	public  void Landing_on_Home_Page() throws IOException
	{
		lp =Start_browser();
		
	}
	
	@Given("^Enter username (.+) and pwd (.+)$")
	public void Enter_username_and_pwd(String UserName , String PassWord)
	{
		pp=lp.enter_credentials_loginpage(UserName ,PassWord);
	}
	
	@When("^Add product (.+) to cart$")
	public void Add_product_to_cart(String Product ) throws InterruptedException
	{
		pp.Click_addtocart(Product);
		Thread.sleep(5000);
		mc =pp.CART();
	}
	@And("^Confirming the added product (.+) and clicking buy now.$")
	public void Confirming_the_added_product_and_clicking_buynow(String Product)
	{
		Boolean bol =mc.Check_product(Product);
		Assert.assertTrue(bol);
		sp= mc.Click_Buy_now();
	}
	@Then("^Selecting the country (.+) and printing total price in Checkout page$")
	public void Selecting_the_country_and_printing_total_price_in_Checkout_page(String Country)
	{
		 sp.Enter_Country(Country);
		 sp.get_price();
}
}
