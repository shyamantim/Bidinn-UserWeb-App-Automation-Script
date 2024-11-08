package bidInnWebApp;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyHotelBooking
{
	@Test
	public void verifyHotelBookingByUser() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		driver.findElement(By.xpath("//INPUT[@autocapitalize='none']")).sendKeys("Hotel Shyam");
		
		driver.findElement(By.xpath("//LI[normalize-space(.)='Hotel Shyam Krishna']")).click();
		
		driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[1]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rdrNextPrevButton rdrNextButton\"])[1]")).click();
		driver.findElement(By.xpath("(//button[@class=\"rdrNextPrevButton rdrNextButton\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='25']")).click();
		driver.findElement(By.xpath("//span[text()='27']")).click();
		driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[3]")).click();
	
		driver.findElement(By.xpath("(//button[text()='+'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Done'])[1]")).click();
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		driver.findElement(By.xpath("//div[@class=\"MuiStack-root mui-uq7dtg\"]")).click();
		
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		for(String ids:allIds)
		{
			if(!ids.equals(parentId))
			{
				driver.switchTo().window(ids);
				driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[1]")).click();
				driver.findElement(By.xpath("(//button[@class=\"rdrNextPrevButton rdrNextButton\"])[1]")).click();
				driver.findElement(By.xpath("(//button[@class=\"rdrNextPrevButton rdrNextButton\"])[1]")).click();
				driver.findElement(By.xpath("//span[text()='18']")).click();
				driver.findElement(By.xpath("//span[text()='22']")).click();
				driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[3]")).click();
				driver.findElement(By.xpath("(//div[@class=\"relative w-full\"])[3]")).click();
				driver.findElement(By.xpath("//button[text()='+'][1]")).click();
				WebElement doneButton = driver.findElement(By.xpath("(//button[text()='Done'])[1]"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", doneButton);
				
				
				Object bidNow = driver.findElement(By.xpath("//button[text()='Bid Now']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", bidNow);
				WebElement bidIncrement = driver.findElement(By.xpath("//span[text()='+']"));
				//Thread.sleep(1000);
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", bidIncrement);
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", bidIncrement);
				
				//Thread.sleep(1000);
				WebElement bidDecrement = driver.findElement(By.xpath("//span[text()='-']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", bidDecrement);
				//Thread.sleep(1000);
				WebElement placeBid = driver.findElement(By.xpath("//button[text()='Place Bid']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", placeBid);
				//Thread.sleep(1000);
				WebElement proceedToPayButton = driver.findElement(By.xpath("//button[text()='Proceed to Pay']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", proceedToPayButton);
				//Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@type='name']")).clear();
				//driver.findElement(By.xpath("//input[@type='name']")).sendKeys("Shyam Sundar");
				
				driver.findElement(By.xpath("//input[@type=\"email\"]")).clear();
				//driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("shyamsundar567@gmail.com");
				//Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='Update']")).click();
				//Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Thread.sleep(1000);
				WebElement payNow = driver.findElement(By.xpath("//button[text()='Pay Now']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].click();", payNow);
				Thread.sleep(1000);
				
				WebElement paymentOption = driver.findElement(By.xpath("//div[@class=\"relative flex h-full flex-col overflow-auto bg-primary text-base font-normal quick-buy:bg-transparent d:flex-row d:overflow-hidden d:p-2\"]"));
				Assert.assertTrue(paymentOption.isDisplayed());
				System.out.println("Hotel Booking is verified. ");
				break;
				
			}
			
		}
		
	}
}
