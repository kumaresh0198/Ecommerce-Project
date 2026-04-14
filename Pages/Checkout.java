package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Checkout {
	
	
	WebDriver driver;
	
	    public Checkout(WebDriver driver) {
	    	this.driver = driver;
	    }
	
	     By checkoutBtn = By.id("checkoutBtn");
	     By firstname = By.id("firstname");
	     By lastname = By.id("lastname");
	     By email = By.id("email");
	     By phone = By.id("phone");
	     By address = By.id("address");
	     By state = By.id("states");
	     By city = By.id("city");
	     By pincode = By.id("pincode");
	     By continueBtn = By.id("continue");
	     By placeOrder = By.cssSelector("a.btn.btn-block.btn-primary");
	     
	     public void clickCheckout() {
	    	 driver.findElement(checkoutBtn).click();
	     }
	     
	     public void enterBillingDetails() {
	    	 driver.findElement(firstname).sendKeys("kumaresh");
	         driver.findElement(lastname).sendKeys("kumar");
	         driver.findElement(email).sendKeys("abc@gmail.com");
	         driver.findElement(phone).sendKeys("9876543210");
	         driver.findElement(address).sendKeys("chennai");
	         driver.findElement(state).sendKeys("tn");
	         driver.findElement(city).sendKeys("abc");
	         driver.findElement(pincode).sendKeys("123456");
	     }
	     
	     public void placeOrder() {
	    	 driver.findElement(continueBtn).click();
	    	 driver.findElement(placeOrder).click();
	     }
	     
	     public void takescreenshot() throws IOException {
	    	 String path = "C:\\Users\\kumut\\eclipse-workspace\\cucumber\\screenshot\\img.png";
	    	 TakesScreenshot srcshot = (TakesScreenshot) driver;
	    	 File src = srcshot.getScreenshotAs(OutputType.FILE);
	    	 File dst = new File(path);
	    	 FileUtils.copyFile(src, dst);
	    	 
	     }


}
