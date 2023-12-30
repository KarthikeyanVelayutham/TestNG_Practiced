package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssert {
	public class HardAssertions {
		@Test
		public void softAssertion() {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.facebook.com");
			String title = driver.getTitle();
			Assert.assertEquals(title, "Facebook – log in or sign up");
			driver.quit();
		}
		}
}
