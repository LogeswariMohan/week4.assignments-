package week4.assignments;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html ");
		
		 List<WebElement> elementColumn = driver.findElements(By.xpath("((//section)[3]//tr)[2]//td"));
		 // System.out.println(findElements.size());------> getting no.of cols using obj.size();
		    List<WebElement> list = new ArrayList<WebElement>(elementColumn);
		    System.out.println("Number of coloumns = "+list.size());
		    List<WebElement> elementRow = driver.findElements(By.xpath("(//section)[3]//tr"));
		    System.out.println("Number of rows = "+ elementRow.size());
		    
		    for (int i = 2; i <=elementRow.size(); i++) 
		    {
		 List<WebElement> progressValueList = driver.findElements(By.xpath("//section[@class='innerblock']//div//table//tbody//tr["+i+"]//td[1]"));
		 List<String> textList = new ArrayList<String>();
		 String find="Learn to interact with Elements";
		//if(textList.)
		
			}

	}

}
