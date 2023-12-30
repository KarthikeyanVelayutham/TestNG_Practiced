package testAnnotation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAnnotation {
	@SuppressWarnings("deprecation")
	@Test
	public void actionClass() throws InterruptedException{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	driver.get("https://demowebshop.tricentis.com/computers");
	Actions action1 = new Actions(driver); //for mouse hover create a Action type object 
	action1.moveToElement(driver.findElement(By.partialLinkText("COMP"))).perform(); //to hover
	Thread.sleep(3000);
	action1.doubleClick().perform(); // for double click
	
	
	driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	Actions action2 = new Actions(driver);
	WebElement src = driver.findElement(By.id("box5"));
	WebElement dest = driver.findElement(By.id("box103"));
	action2.dragAndDrop(src, dest).perform();// to drag and drop
	
	
	driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
	Actions action3 = new Actions(driver);
	WebElement src1 = driver.findElement(By.id("box5"));
	WebElement dest1 = driver.findElement(By.id("box103"));
	action3.clickAndHold(src1).perform(); //to hold
	action3.release(dest1).perform(); //to release the holded
	
	
	
	driver.navigate().to("https://www.wikipedia.org/");
	Actions action4 = new Actions(driver);
	action4.sendKeys(Keys.PAGE_DOWN).perform(); //to perform scroll up
	WebElement ele = driver.findElement(By.id("www-wikipedia-org"));
	action4.contextClick(ele).perform(); // to perform right click
	driver.quit();
}
}