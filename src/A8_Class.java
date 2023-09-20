import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class A8_Class {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "C:\driver\firefoxdriver\geckodriver.exe");
//		System.setProperty("webdriver.edge.driver", "C:\\driver\\edgedriver\\msedgedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
		
		Date currentDate = new Date();
		String newDate= currentDate.toString().replace(":", "-");
		
		TakesScreenshot src= ((TakesScreenshot)driver);
		File srcFile = src.getScreenshotAs((OutputType.FILE));
		File Dest = new File(".//mypictures/"+newDate+".png");
		FileUtils.copyFile(srcFile,Dest);
				
		
		List <WebElement> students = driver.findElements(By.tagName("option"));
		
		int numOfstudents= students.size();
		
		int removItem= 1;
		
		for(int i=0; i<removItem; i++) {
			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
		}
		
		List <WebElement> stuAfterremove = driver.findElements(By.tagName("option"));
		int actualNumber= stuAfterremove.size();
		int expectNumber= numOfstudents - removItem;
		
		Assert.assertEquals(actualNumber, expectNumber);
		

		
		
		
		
	
	}

}
