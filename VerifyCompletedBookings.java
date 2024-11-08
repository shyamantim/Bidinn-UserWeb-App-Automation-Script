package bidInnWebApp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCompletedBookings 
{
	@Test(priority=1)
	public void verifyRateHotelLink() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//span[@class=\"MuiButton-icon MuiButton-endIcon MuiButton-iconSizeMedium mui-pt151d\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.linkText("Booking")).click();
		driver.findElement(By.xpath("//button[text()='Completed']")).click();
		driver.findElement(By.xpath("(//button[text()='Rate Hotel'])[1]")).click();
		WebElement element = driver.findElement(By.xpath("(//button[text()='Rate Hotel'])[1]"));
		
		Assert.assertTrue(!element.isDisplayed());
		System.out.println("Rate Hotel Link is verified. ");
		driver.quit();
	}
	@Test(priority=2)
	public void verifyCheckWhetherCheckIndateIsVisiblew() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//span[@class=\"MuiButton-icon MuiButton-endIcon MuiButton-iconSizeMedium mui-pt151d\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.linkText("Booking")).click();
		driver.findElement(By.xpath("//button[text()='Completed']")).click();
		
		 WebElement checkinDate = driver.findElement(By.xpath("(//span[@class=\"MuiTypography-root MuiTypography-caption mui-1v2gfp5\"])[2]"));
		 Assert.assertTrue(checkinDate.isDisplayed());
		 System.out.println("Check in Date is verified. ");
		 driver.quit();
	}
	@Test
	public void verifyRoom() throws InterruptedException, IOException
	{
		
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//span[@class=\"MuiButton-icon MuiButton-endIcon MuiButton-iconSizeMedium mui-pt151d\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.linkText("Booking")).click();
		driver.findElement(By.xpath("//button[text()='Completed']")).click();
		
		WebElement noOfRooms = driver.findElement(By.xpath("(//span[contains(text(),' room(s)')])[1]"));
		Assert.assertTrue(noOfRooms.isDisplayed());
		System.out.println("Number of Rooms Are Verified.");
		driver.quit();
	}
}
