package suiteExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuiteExecution {
	WebDriver driver;
	long startTime;
	long endTime;
	long totalTime;
	@BeforeSuite
	public void launchBrowser() {
		startTime = System.currentTimeMillis();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void OpenGoogle() {
		driver.get("http://www.google.com");
	}
	
	
	@Test
	public void Openyahoo() {
		driver.get("http://www.yahoo.com");
	}

	
	
	@Test
	public void OpenBing() {
		driver.get("http://www.bing.com");
	}

	@AfterSuite
    public void closeBrowser() {
		driver.quit();
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
}
