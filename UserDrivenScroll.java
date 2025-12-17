package seleniumtest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Scanner;

public class UserDrivenScroll {
    public static void main(String[] args) {
        // Set path to geckodriver if it's not in system PATH
        System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        Scanner scanner = new Scanner(System.in);

        try {
            driver.manage().window().maximize();
            driver.get("https://en.wikipedia.org/wiki/Selenium_(software)");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String command;

            System.out.println("Scroll Demo Started. Type commands to scroll the page.");
            System.out.println("Available commands: down, up, bottom, top, exit");

            while (true) {
                System.out.print("Enter command: ");
                command = scanner.nextLine().trim().toLowerCase();

                switch (command) {
                    case "down":
                        js.executeScript("window.scrollBy(0, 500)");
                        System.out.println("Scrolled down 500px");
                        break;
                    case "up":
                        js.executeScript("window.scrollBy(0, -500)");
                        System.out.println("Scrolled up 500px");
                        break;
                    case "bottom":
                        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                        System.out.println("Scrolled to bottom");
                        break;
                    case "top":
                        js.executeScript("window.scrollTo(0, 0)");
                        System.out.println("Scrolled to top");
                        break;
                    case "exit":
                  
                       	System.out.println("Exiting scroll demo...");
                        return;
                    default:
                        System.out.println("Invalid command. Try: down, up, bottom, top, exit");
                }
            }

        } finally {
            scanner.close();
            driver.quit();
        }
    }
}
