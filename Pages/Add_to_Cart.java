package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Add_to_Cart {
	
	WebDriver driver;
	
	    public Add_to_Cart(WebDriver driver) {
	    	this.driver = driver;
	    }
	
	     By menswear = By.xpath("(//a[@class='btn btn-primary'])[1]");
	     By filter = By.cssSelector("label[for='price-2']");
	     By addToCart = By.cssSelector("button[data-id='21']");
	     By cartCount = By.id("cartCount");
	     By checkout = By.cssSelector("i.fa-shopping-cart");	     
	     public void selectmenswear() {
	    	 driver.findElement(menswear).click();
	     }
	     
	     public void applyfilter() {
	    	 driver.findElement(filter).click();
	     }
	     
	     public void addproducttocart() {
	    	 driver.findElement(addToCart).click();
	     }
	     
	     public String getcartcount() {
	    	return driver.findElement(cartCount).getText();
	     }
	     
	     public void clickcheckout() {
	    	 driver.findElement(checkout).click();
	     }

}
