package seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
		driver.switchTo().frame("iframeResult");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.name("cars")));

		Select select = new Select(dropDown);

		select.selectByValue("opel");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		select.selectByValue("audi");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.quit();

	}

}
