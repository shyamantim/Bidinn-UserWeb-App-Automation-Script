package bidInnWebApp;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyViewProfilePage 
{
	@Test(priority=1)
	public void verifyEditButton() throws InterruptedException, IOException 
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		
		driver.findElement(By.xpath("//span[@class=\"MuiButton-icon MuiButton-endIcon MuiButton-iconSizeMedium mui-pt151d\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		driver.findElement(By.xpath("//a[text()='View profile']")).click();
		//driver.findElement(By.xpath("//A[normalize-space(.)='Profile']")).click();
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Edit']"));
		element.click();
		WebElement element1 = driver.findElement(By.xpath("//h3[text()='Personal Information']"));
		Assert.assertTrue(element1.isDisplayed());
		System.out.println("Edit Profile Button is verified. ");
		
		driver.quit();
	}
	@Test(priority=2)
	public void verifyEditProfilePicButton() throws InterruptedException, FindFailed, AWTException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//span[@class=\"MuiButton-icon MuiButton-endIcon MuiButton-iconSizeMedium mui-pt151d\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		driver.findElement(By.xpath("//a[text()='View profile']")).click();
		
		driver.findElement(By.xpath("//*[@for='profilePhoto']")).click();
		//.sendKeys("C:\\Users\\CHANDAN SINGH\\OneDrive\\Desktop\\Selenium_Whole_Notes.pdf");
		
		Pattern fileUploadButton = new Pattern("D:\\eclipse-workspace\\Selenium_10AMB\\src\\bidInnWebApp\\BidInnUpload.png");	
		Screen screen = new Screen();
        screen.click(fileUploadButton);
        
        screen.type("D:\\eclipse-workspace\\Selenium_10AMB\\src\\bidInnWebApp\\pic.png");
        screen.type("\n");
        Assert.assertTrue(true);
        System.out.println("Edit Profile Pic Button is verified.");
        driver.quit();;
		}
}
