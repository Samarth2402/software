package seleniumtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxSelection {

    public static void main(String[] args) {

        // Set path for GeckoDriver
        System.setProperty("webdriver.gecko.driver",
                "C:\\tools\\geckodriver-win64\\geckodriver.exe");

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open the URL
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox");

        // Switch to iframe
        driver.switchTo().frame("iframeResult");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on checkbox
        wait.until(ExpectedConditions.elementToBeClickable(By.name("vehicle1"))).click();

        // Just to see the action
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close browser
        driver.quit();
    }
}
