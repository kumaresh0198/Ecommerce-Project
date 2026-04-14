package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	//locators
	 By email = By.cssSelector("input[type=\"email\"]");
	 By password = By.cssSelector("input[type=\"password\"]");
	 By loginbtn = By.id("loginBtn");
	 String home_page = "https://shop.qaautomationlabs.com/shop.php";
	 
	 //actions 
	 
	 public void openloginpage() {
		 driver.get("https://shop.qaautomationlabs.com/index.php");
	 }
	 
	 public void enteremail(String username) {
		 driver.findElement(email).sendKeys(username);
	 }
	 
	 public void enterpassword(String pwd) {
		 driver.findElement(password).sendKeys(pwd);
	 }
	 
	 public void clicklogin() {
		 driver.findElement(loginbtn).click();
	 }
	 
	 public String get_current_url() {
		  return driver.getCurrentUrl();
	 }
	 
	 public void login(String username, String pwd) {
		 enteremail(username);
		 enterpassword(pwd);
		 clicklogin();
	 }

}
