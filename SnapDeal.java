package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//		1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(2000);
		
//		2. Search on  Training Shoes
		WebElement search = driver.findElement(By.id("inputValEnter"));
		search.sendKeys("Training shoes",Keys.ENTER);
		
//		3. Get the count of the Training Shoes \\\\ ref - //a[contains(@class,'sub-cat-node')]//div[text()='19']
		String count = driver.findElement(By.xpath("(//div[text()='936'])[2]")).getText();
		System.out.println("Total number of Training Shoes : "+count);
		
//		4. Click on Sort by  and select Low to High   
		//WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-selected']"));//sortby
		//sortBy.click();
		WebElement sortBy = driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"));//entire line
		sortBy.click();
		WebElement lowToHigh = driver.findElement(By.xpath("(//li[@class='search-li'])[2]"));
		lowToHigh.click();
		
//		5. Check if the items displayed are sorted correctly
		List<WebElement> sorted = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		Thread.sleep(7000);//StaleElementReferenceException
		for (WebElement webElement : sorted) {
			String sortedtext = webElement.getText();
			System.out.println("list of brand of the products displayed in the page "+sortedtext);
		}
		
//		6. Enter the price range (900-1500)
		WebElement minPrice = driver.findElement(By.name("fromVal"));
		minPrice.clear();
		minPrice.sendKeys("900");
		WebElement maxPrice = driver.findElement(By.name("toVal"));
		maxPrice.clear();
		maxPrice.sendKeys("1500");
	
//		7. Filter with color Blue \\\\\\\\ref - //a[text()=' Blue']
		WebElement blue = driver.findElement(By.xpath("//label[contains(@for,'Color_s-Blue')]"));
		blue.click();
//		
//		8.Verify the Blue check box is enabled
		//label[@for='Color_s-Blue']
		boolean enabled = driver.findElement(By.xpath("//label[@for='Color_s-Blue']")).isEnabled();
		System.out.println(enabled);
		
//		9.Click on first resulting Training shoes
		WebElement firstImage=driver.findElement(By.xpath("//picture[@class='picture-elem']/img[@class='product-image wooble']"));
		Actions builder1=new Actions(driver);
		builder1.moveToElement(firstImage).perform();
//additional	
//		WebElement quickView=driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]"));
//		quickView.click();
		
//		10. Print the cost and the discount percentage
		WebElement price = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		System.out.println(price.getText());
		WebElement discount = driver.findElement(By.xpath("//span[text()='Rs. 1,499']"));
		System.out.println(discount.getText());
		
//		11. Take the snapshot of the shoes
		WebElement shoeImage=driver.findElement(By.xpath("//img[@slidenum='0']"));
		File source=shoeImage.getScreenshotAs(OutputType.FILE);
		File destination=new File("./snaps/ShoeScreenShot.png");
		FileUtils.copyFile(source, destination);
		driver.quit();

	
	}

}
