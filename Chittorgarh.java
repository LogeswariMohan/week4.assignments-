package week4.assignments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		1. Launch the URL
		driver.get("https://www.chittorgarh.com/");
//		2. Click on stock market
		WebElement stockMarket = driver.findElement(By.id("navbtn_stockmarket"));
		stockMarket.click();
//		3. Click on NSE bulk Deals
		WebElement bulkDeals = driver.findElement(By.linkText("NSE Bulk Deals"));
		bulkDeals.click();
//		4.Get all the Security names			
		WebElement table = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']"));

		List<WebElement> rows = table.findElements(By.xpath("//tbody/tr"));

		List<String> securityNames  = new ArrayList<String>();
		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			for(int j=0;j<columns.size();j++)
			{
				if(j==2)
				{
					securityNames.add(columns.get(j).getText());
				}
				}
		}
		System.out.print("Security names ---->");
		System.out.println(securityNames);
		Set<String> securityNamesWithoutDuplicates = new LinkedHashSet<String>();
		securityNamesWithoutDuplicates.addAll(securityNames);
		System.out.println("Security names without duplicates ----> ");
		System.out.println(securityNamesWithoutDuplicates);
		driver.close();
		}
	}

