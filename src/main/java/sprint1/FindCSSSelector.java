package sprint1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindCSSSelector {
	
	
		public static void main(String[] args) throws InterruptedException {
			ChromeOptions option =new ChromeOptions();
			option.addArguments("--disable-notifications");
			
			
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			
			//driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
			//input#user-name
			
			
			//driver.findElement(By.id("password")).sendKeys("secret_sauce");
			 driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
			//input#password
			 
			//driver.findElement(By.id("login-button")).click();
			 driver.findElement(By.cssSelector("input#login-button")).click();
			//input#login-button
			
			//String itemName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
			String itemName = driver.findElement(By.cssSelector("a#item_4_title_link>div")).getText();
			//a#item_4_title_link>div
			
			System.out.println(itemName);
			
			//driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
			driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
			//add-to-cart-sauce-labs-backpack
			
			 Thread.sleep(3000);
			//driver.findElement(By.className("shopping_cart_link")).click();
			driver.findElement(By.cssSelector("div#shopping_cart_container>a")).click();
			//div#shopping_cart_container>a
			
			System.out.println("Clicked on Cart_link");
			
			//String cartItem = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
			String cartItem = driver.findElement(By.cssSelector("a#item_4_title_link>div")).getText();
			//a#item_4_title_link>div
			System.out.println(cartItem);

			if (cartItem.equals(itemName)) {
				
				System.out.println("ordered the correct product");
			} else {

				
				System.out.println("ordered the wrong product");
			}
			
		
			
		}
	}


