package week4.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
//				1. Launch URL "http://leaftaps.com/opentaps/control/login"
			  	driver.get("http://leaftaps.com/opentaps/control/login");
			  
//				2. Enter UserName and Password Using Id Locator
			  	WebElement usernameElement = driver.findElement(By.id("username"));
				usernameElement.sendKeys("Demosalesmanager");
				WebElement passwordElement = driver.findElement(By.id("password"));
				passwordElement.sendKeys("crmsfa");  
			  	
//				3. Click on Login Button using Class Locator
				WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
				loginbutton.click();
				
//				4. Click on CRM/SFA Link
				WebElement crmsfaElement = driver.findElement(By.linkText("CRM/SFA"));
				crmsfaElement.click(); 
				
//				5. Click on contacts Button
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			  	
//				6. Click on Merge Contacts using Xpath Locator
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				  
//				7. Click on Widget of From Contact
				driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
				  
//				8. Click on First Resulting Contact
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> list = new ArrayList<String>(windowHandles);
				
				driver.switchTo().window(list.get(1));
				driver.manage().window().maximize();
				
			    driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			    
			    driver.switchTo().window(list.get(0));
			    driver.manage().window().maximize();
			  
//  			9. Click on Widget of To Contact
			    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
			    
// 				10. Click on Second Resulting Contact
			    Set<String> windowHandles1 = driver.getWindowHandles();
				List<String> list1 = new ArrayList<String>(windowHandles1);
				
			    driver.switchTo().window(list1.get(1));
				driver.manage().window().maximize();
				Thread.sleep(3000);
				
				driver.findElement(By.className("linktext")).click();			    
			    Thread.sleep(5000);
			    driver.switchTo().window(list1.get(0));
			    driver.manage().window().maximize();
			    
			  //11. Click on Merge button using Xpath Locator
			    driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
			  
			  //12. Accept the Alert
			    Alert alert = driver.switchTo().alert();
			    alert.accept();
			    
			    
			  
			 // 13. Verify the title of the page
			    String title = driver.getTitle();
			    System.out.println("The title is => ------>"+ title);

	}
						
}
