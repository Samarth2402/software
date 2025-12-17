package seleniumtest;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserDrivenMultiSelect {

	public static void main(String[] args) {
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
		selection(driver, multiSelect);

	}

	private static void selection(WebDriver driver, Select select) {
		System.out.println("Available options:");
		select.getOptions().forEach(option -> System.out.println("- " + option.getText()));
		System.out.println("Enter the options to select (comma separated):");
		Scanner scanner = new Scanner(System.in);
		try {			
			String selectedCar = scanner.nextLine();
			System.out.println(selectedCar);
			String[] selectedCars = selectedCar.split(",");
			int count=0;
			for (String car : selectedCars) {
				if (car.trim().equals("Opel") || car.trim().equals("Audi") || 
						car.trim().equals("Saab") || car.trim().equals("Volvo")) {
					select.selectByVisibleText(car.trim());
					count++;
				}else {
					System.out.println(car+" does not exist in option");
					}
			}
			if(count==0) {
				System.out.println("No correct Option Selected. Please Try Again...");
				selection(driver, select);
			}
			
			Thread.sleep(5000);
		} catch (Exception exception) {

		}finally {
			scanner.close();
			driver.quit();
		}

	}

}
