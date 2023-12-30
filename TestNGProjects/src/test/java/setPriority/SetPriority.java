package setPriority;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetPriority {

    @Test(priority = 2 , groups = "test it")
    public void actionClassToHover() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demowebshop.tricentis.com/computers");
        Actions action1 = new Actions(driver);
        action1.moveToElement(driver.findElement(By.partialLinkText("COMP"))).perform();
        Thread.sleep(3000);
        action1.doubleClick().perform();
        driver.quit();
    }

    @Test(priority = 4, groups = "test it")
    public void actionClassDragAndDrop() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions action2 = new Actions(driver);
        WebElement src = driver.findElement(By.id("box5"));
        WebElement dest = driver.findElement(By.id("box103"));
        action2.dragAndDrop(src, dest).perform();
        driver.quit();
    }

    @Test(priority = 1 , groups = "dont test it")
    public void actionClassDragAndDrop2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        Actions action3 = new Actions(driver);
        WebElement src1 = driver.findElement(By.id("box5"));
        WebElement dest1 = driver.findElement(By.id("box103"));
        action3.clickAndHold(src1).perform();
        action3.release(dest1).perform();
        driver.quit();
    }

    @Test(priority = 3 , groups = "dont test it")
    public void actionClassForRightClick() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://www.wikipedia.org/");
        Actions action4 = new Actions(driver);
        action4.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement ele = driver.findElement(By.id("www-wikipedia-org"));
        action4.contextClick(ele).perform();
        driver.quit();
    }
}
