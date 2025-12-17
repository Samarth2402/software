package seleniumtest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.util.Scanner;

public class FileUploadUserInput {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full file path to upload: ");
        String filePath = scanner.nextLine();
      
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File does not exist. Please check the path and try again.");
            scanner.close();
            return;
        }
      
        System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_input_file");    
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.id("myfile")).sendKeys(file.getAbsolutePath());
        System.out.println("File path sent to input element!");
        scanner.close();
        driver.quit();
    }
}
