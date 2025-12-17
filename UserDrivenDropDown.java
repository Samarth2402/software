package seleniumtest;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDrivenDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "C:\\tools\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        Scanner scanner = new Scanner(System.in);

        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        driver.switchTo().frame("iframeResult");
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement dropdown= wait.until(ExpectedConditions.elementToBeClickable(By.id("cars")));
        Select select=new Select(dropdown);
       
        try {
        	String selection = "opel";
        	System.out.println("Please select any one from: volvo, saab, opel, audi ");
        	selection= scanner.nextLine().trim().toLowerCase();
        	if(!selection.equalsIgnoreCase("volvo") && !selection.equalsIgnoreCase("saab") && !selection.equalsIgnoreCase("opel")&& !selection.equalsIgnoreCase("audi")) {
        		System.out.println("Incorrect Choice");
        	}else {
        		select.selectByValue(selection);
        	}
        	
        	
        	
        }catch (Exception e) {
			// TODO: handle exception
        	
		}finally {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			scanner.close();
			driver.quit();
		}
	}

}
