package seleniumtest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");

		WebElement multiSelectElement = driver.findElement(By.name("cars"));
		Select multiSelect = new Select(multiSelectElement);

		if (!multiSelect.isMultiple()) {
			System.out.println("The select element does not support multiple selections.");
			return;
		}

		Selection(driver, multiSelect);
	}

	private static void Selection(WebDriver driver, Select multiSelect) {
		System.out.println("Please enter any one from given Options");
		multiSelect.getOptions().forEach(option -> System.out.println("->" + option.getText()));
		System.out.println("Provide Your Selected Values Comma Seperated");
		Scanner scanner = new Scanner(System.in);
		int count = 0;
		try {
			String selectedValue = scanner.next();
			String[] selectedValues = selectedValue.split(",");
			for (String selected : selectedValues) {
				if (selected.equals("Volvo") || selected.equals("Saab") || 
						selected.equals("Audi")
						|| selected.equals("Opel")) {
					multiSelect.selectByVisibleText(selected.trim());
					count++;
				} else {
					System.out.println(selected + " is not available in options");
				}
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (count > 0) {
				scanner.close();
				driver.quit();
			} else {
				System.out.println("You have not selected any correct Option. Please Try Again....");
				Selection(driver, multiSelect);
			}
		}

	}

}





