package seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Snippet {

	public static void main(String Args[]) {

	System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver-win64\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();  // your WebDriver initialization
	driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio");
	driver.switchTo().frame("iframeResult");
	
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	
	WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("css")));
	radioButton.click();
	
	// Optionally, verify selection:
	boolean isSelected = radioButton.isSelected();
	System.out.println("Is CSS radio selected? " + isSelected);
	
	WebElement radioButtonAge = wait.until(ExpectedConditions.elementToBeClickable(By.id("age2")));
	radioButtonAge.click();
	
	// Optionally, verify selection:
	boolean isAgeSelected = radioButtonAge.isSelected();
	System.out.println("Is CSS radio selected? " + isAgeSelected);
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	driver.quit();
	
	}

}
