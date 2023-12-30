package assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class SoftAssertions {
@Test
public void softAssertion() {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
	String title = driver.getTitle();
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(title, "Facebook – log in or sign up");
	sa.assertAll();
	driver.quit();
}
}
