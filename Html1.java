package week4.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Html1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// 1. Launch the URL https://html.com/tags/table/
			driver.get("https://html.com/tags/table/");
	
		//2. Get the count of number of rows
			 int numOfTables = driver.findElements(By.xpath("//table")).size();
			 System.out.println("The number of Tables : " +numOfTables);
			
			 for (int i = 1; i <= numOfTables; i++) {
				
			int numOfRows = driver.findElements(By.xpath("(//table)["+i+"]//tr")).size();
				System.out.println("The number of rows in table " +i+ "---> " +numOfRows);
				
				//3. Get the count of number of columns
				
			int numOfcolumns = driver.findElements(By.xpath("(//table)["+i+"]//th")).size();
				System.out.println("The number of coloums in table " +i+ "---> "  +numOfcolumns);			 }
		driver.quit();
	}

}
