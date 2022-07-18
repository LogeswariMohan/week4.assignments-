package week4.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// 1. Launch the URL https://html.com/tags/table/
		driver.get("https://html.com/tags/table/");
		
		// 2. You have to print the respective values based on given Library
		  //This is for table one
		  List<WebElement> row = driver.findElements(By.xpath("(//table)[1]//tr"));
		  int rowsize = row.size();
		  System.out.println(rowsize);
		
		  System.out.println(row.get(0).getText());
		  System.out.println(row.get(1).getText());
		  System.out.println(row.get(2).getText());
		 
		  System.out.println("=================================================");
		 
		 //This is for table 2 
		  List<WebElement> row1 = driver.findElements(By.xpath("(//table)[2]//tr"));
		  int rowsize1 = row1.size();
		  System.out.println(rowsize1);
		  
		  for (int i = 0; i < row.size(); i++) {
			System.out.println(row1.get(i).getText());

	}

}
}
