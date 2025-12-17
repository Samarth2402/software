package seleniumtest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HerokuappLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");

		login(driver);
	}

	private static void login(WebDriver driver) {
		Scanner scanner = new Scanner(System.in);
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password= driver.findElement(By.id("password"));
		
		System.out.print("Username:->");
		username.sendKeys(scanner.next().trim());
		
		System.out.print("password:->");
		password.sendKeys(scanner.next().trim());
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
		driver.quit();
	}

}
