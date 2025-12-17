package seleniumtest;

import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWikipedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", 
				"C:\\tools\\chromedriver-win64\\chromedriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		System.out.println("Page Title "+driver.getTitle());
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();

	}

}
