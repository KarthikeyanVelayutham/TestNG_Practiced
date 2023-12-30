package handleDependencies;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HandleDependencies {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void openFacebook() {
        WebElement clickCreateButton = driver.findElement(By.partialLinkText("Create new account"));
        clickCreateButton.click();
    }

    @Test(dependsOnMethods = "openFacebook")
    public void enterRegistrationDetails() {
    	WebElement clickCreateButton=driver.findElement(By.partialLinkText("Create new account"));
		clickCreateButton.click();
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
//		firstName.click();
		firstName.sendKeys("karthik");
		
		
		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
//		lastName.click();
		lastName.sendKeys("subramanian");
		
		
		WebElement enterMobileNumber = driver.findElement(By.xpath("//input[@name='reg_email__']"));
//		enterMobileNumber.click();
		enterMobileNumber.sendKeys("abcd@gmail.com");
		
		
		WebElement enterEmailAddress = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
//		enterEmailAddress.click();
		enterEmailAddress.sendKeys("abcd@gmail.com");
		
		
		WebElement newPassword = driver.findElement(By.xpath("//input[@id='password_step_input']"));
//		newPassword.click();
		newPassword.sendKeys("Aqpeuihighi");
		
		
		WebElement day = driver.findElement(By.id("day"));
		Select select = new Select(day);
		select.selectByValue("30");
		
		WebElement month = driver.findElement(By.id("month"));
		Select selects = new Select(month);
		selects.selectByVisibleText("Aug");
		
		WebElement year = driver.findElement(By.id("year"));
		Select selectss = new Select(year);
		selectss.selectByIndex(23);
			
		
		WebElement genderSelect = driver.findElement(By.xpath("//input[@value='2']"));
		genderSelect.click();
		
		
		WebElement signUp = driver.findElement(By.name("websubmit"));
		signUp.click();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after all tests are completed
        driver.quit();
    }
}
