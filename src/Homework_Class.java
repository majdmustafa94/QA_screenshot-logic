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

public class Homework_Class {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:5500/index.html");
				
//		Remove number of students from the list:
		List <WebElement> students = driver.findElements(By.tagName("option"));
				
		for(int i=0; i<students.size(); i++) {
			if (i % 2 == 0) {
				students.get(i).click();
				System.err.println("i will remove "+students.get(i).getText());
				driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();
				}
			else {
				System.out.println("i will keep "+students.get(i).getText());
			}
		}
		
		driver.findElement(By.id("selectNow")).click();
//		TakesScreenshot:
		Date currentDate = new Date();
		String newDate= currentDate.toString().replace(":", "-");
		
		TakesScreenshot src= ((TakesScreenshot)driver);
		File srcFile = src.getScreenshotAs((OutputType.FILE));
		File Dest = new File(".//mypictures/"+newDate+".png");
		FileUtils.copyFile(srcFile,Dest);
			
	}
}
