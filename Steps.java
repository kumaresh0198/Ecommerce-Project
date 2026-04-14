package steps;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Add_to_Cart;
import pages.Checkout;
import pages.Login;
public class Steps {
	
	WebDriver driver;
	// creating a reference variable for class
	Login login;
	Add_to_Cart product;
	Checkout checkout;
	
	
	@Before
	public void startup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// adding implicitly wait globally to all elements
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		login = new Login(driver); // creating object for the class
		product = new Add_to_Cart(driver);
		checkout = new Checkout(driver);
		
	}
	@Given("the user is on the login page")
	public void login_page() {
		login.openloginpage();
	}
	@When("the user enters {string} and {string}")
	public void usre_credentials(String username, String password) {
		login.enteremail(username);
		login.enterpassword(password);
	}
	
	@And("clicks the login button")
	public void clicks_login_button() {
		login.clicklogin();
	}
	
	@Then("the user should be navigated to the home page")
	public void home_page() {
		String actual =login.get_current_url();
		String expected = "https://shop.qaautomationlabs.com/shop.php";
		Assert.assertEquals(actual,expected);
	}
	
	@Given("the user is logged in")
	public void home_pages(){
		login.openloginpage();
		login.login("demo@demo.com", "demo");
	}
	
	@When("the user selects menswear category")
	public void select_product() {
		product.selectmenswear();
	}
	
	@And("the user applies filter option")
	public void filter_product() {
		product.applyfilter();
	}
	
	@And("the user adds product to cart")
	public void add_to_cart() {
		product.addproducttocart();
	}
	
	@Then("the product should be added to cart")
	public void added_to_cart() {
		String value = product.getcartcount();
		System.out.println("item count added: "+value);
	}
	
	@Given("the user has product in cart")
	public void cart() {
		login.openloginpage();
		login.login("demo@demo.com", "demo");
		product.selectmenswear();
		product.applyfilter();
		product.addproducttocart();
		product.clickcheckout();
	}
	
	@When("the user proceeds to checkout")
	public void proceed_checkout() {
		checkout.clickCheckout();
	}
	
	@And("the user enters billing address")
	public void billing_address() {
		checkout.enterBillingDetails();
	}
	
	@And("clicks continue button")
	public void click_continue() {
		checkout.placeOrder();
	}
	
	@Then("the order should be placed successfully")
	public void order_placed() throws IOException {
		System.out.println("order placed successfully");
		checkout.takescreenshot();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
