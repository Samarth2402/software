package seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TypeTextBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		driver.switchTo().frame("iframeResult");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname")));
		WebElement lname = wait.until(ExpectedConditions.elementToBeClickable(By.name("lname")));
		
		fname.clear();
		lname.clear();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fname.sendKeys("Vishwa");
		lname.sendKeys("Desai");
		

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
         // Click the submit button
         submitButton.click();
         
         try {
 			Thread.sleep(5000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}

		driver.quit();

	}

}
