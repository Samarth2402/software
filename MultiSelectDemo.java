package seleniumtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Scanner;

public class MultiSelectDemo {
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

	private static void selection(WebDriver driver, Select multiSelect) {
		System.out.println("Available options:");
        multiSelect.getOptions().forEach(option -> System.out.println("- " + option.getText()));
        System.out.println("Enter the options to select (comma separated):");
        try (Scanner scanner = new Scanner(System.in)) {
                             
            String input = scanner.nextLine();
            String[] selections = input.split(",");

            multiSelect.deselectAll();

            for (String selection : selections) {
                String valueToSelect = selection.trim();
                try {
                    multiSelect.selectByVisibleText(valueToSelect);
                    System.out.println("Selected: " + valueToSelect);
                } catch (Exception e) {
                    System.out.println("Option not found: " + valueToSelect);
                    selection(driver, multiSelect);
                }
            }
         
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           
            driver.quit();
        }
	}
}
