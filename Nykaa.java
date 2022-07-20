package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//			1) Go to https://www.nykaa.com/
			driver.get("https://www.nykaa.com/");
		
//			2) Click Brands and Search L'Oreal Paris
//			3) Click L'Oreal Paris
			WebElement search = driver.findElement(By.name("search-suggestions-nykaa"));
			search.sendKeys("L'Oreal Paris",Keys.ENTER);
			
//			4) Check the title contains L'Oreal Paris
			Thread.sleep(2000);
			String title = driver.findElement(By.xpath("//h1[@class='page-title-search']")).getText();
			System.out.println("Title = " +title.contains("L'Oreal Paris"));
			
//			5) Click sort By and select customer top rated
			WebElement sortBy = driver.findElement(By.xpath("//span[text()='Sort By : relevance']"));
			sortBy.click();
			WebElement topRated = driver.findElement(By.xpath("//span[text()='customer top rated']"));
			topRated.click();
			
//			6) Click Category and click Hair->Click haircare->Shampoo
			WebElement category = driver.findElement(By.xpath("//span[text()='Category']"));
			category.click();
			WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
			hair.click();
			WebElement hairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
			hairCare.click();
			WebElement shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
			shampoo.click();
			
//			7) Click->Concern->Color Protection
			WebElement concern = driver.findElement(By.xpath("//span[text()='Concern']"));
			concern.click();
			WebElement colorProtection = driver.findElement(By.xpath("//span[text()='Color Protection']"));
			colorProtection.click();
		
//			8)check whether the Filter is applied with Shampoo
			String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
			System.out.println("the Filter is applied with Shampoo = "+filter.contains("Shampoo")); 
			
//			9) Click on L'Oreal Paris Colour Protect Shampoo
			WebElement lpcps = driver.findElement(By.xpath("//div[@class='css-xrzmfa']"));
			lpcps.click();
			
//			10) GO to the new window and select size as 175ml
			Set<String> winset = driver.getWindowHandles();
			List<String> list = new ArrayList<String>(winset);
			driver.switchTo().window(list.get(1));	
			
//			11) Print the MRP of the product
			Thread.sleep(3000);
			String mrp = driver.findElement(By.xpath("(//span[@class='css-1jczs19'])[1]")).getText();
			System.out.println("MRP "+mrp);
			
//			12) Click on ADD to BAG
			Thread.sleep(3000);
			WebElement addToBag = driver.findElement(By.className("btn-text"));
			addToBag.click();
			
//			13) Go to Shopping Bag
			Thread.sleep(3000);
			WebElement shoppingBag = driver.findElement(By.className("cart-count"));
			shoppingBag.click();
			
//			14) Print the Grand Total amount
			//Thread.sleep(3000);
			WebDriver frame = driver.switchTo().frame(0);
			String grandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
			System.out.println("Grand total = "+grandTotal);
			
//			15) Click Proceed
			Thread.sleep(3000);
			WebElement proceed = driver.findElement(By.xpath("//div[@class='second-col']/button"));
			proceed.click();
			
//			16) Click on Continue as Guest
			Set<String> winset1 = driver.getWindowHandles();
			List<String> list1 = new ArrayList<String>(winset1);
			driver.switchTo().window(list1.get(1));
			WebElement guest = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
			guest.click();
			
//			17) Check if this grand total is the same in step 14
			//span[text()='259']
			String checkGrandTotal = driver.findElement(By.className("value")).getText();
			if(grandTotal.contains(checkGrandTotal)) {
				System.out.println("Grand total is equal");
			}
			else {
				System.out.println("Grand total not equal");
			}
			
//			18) Close all windows
			driver.quit();

	}

}
