package seleniumtest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HerokuappDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");

		selection(driver);
	}

	private static void selection(WebDriver driver) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Select 1 or 2");
			int selection = scanner.nextInt();

			if (selection > 2) {
				System.out.println("You have made wrong choice");
				selection(driver);
			} else {
				new Select(driver.findElement(By.id("dropdown"))).selectByValue(selection + "");
			}
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			scanner.close();
			driver.quit();
		}
	}

}
