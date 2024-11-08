package bidInnWebApp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyUpcomingBookingPage
{
	@Test
	public void verifyCancelButton() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		driver.findElement(By.xpath("//span[@class=\"MuiButton-icon MuiButton-endIcon MuiButton-iconSizeMedium mui-pt151d\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.linkText("Booking")).click();
		driver.findElement(By.xpath("//button[text()='Cancel Booking']")).click();
		
		WebElement reason = driver.findElement(By.id("reason"));
		Select select=new Select(reason);
		select.selectByVisibleText("Family emergency");
		
		driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here...\"]")).sendKeys("Travel Plan Change. ");
		driver.findElement(By.xpath("//button[text()=' Cancel Booking']")).click();
		
		driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		
		driver.findElement(By.xpath("//button[text()='Cancel Booking']")).click();
		WebElement reason1 = driver.findElement(By.xpath("//select[@id=\"reason\"]"));
		Select select1=new Select(reason1);
		select1.selectByVisibleText("Medical reason");
		
		driver.findElement(By.xpath("//textarea[@placeholder=\"Type your message here...\"]")).sendKeys("Medical Reason. ");
		driver.findElement(By.xpath("//button[text()=' Cancel Booking']")).click();
		driver.findElement(By.xpath("//button[text()='Yes, cancel it!']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='Cancelled']")).click();
		WebElement element = driver.findElement(By.xpath("//h5[text()='368160']"));
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Cancel Booking is verified.");
		
		driver.quit();
		
	}
}
