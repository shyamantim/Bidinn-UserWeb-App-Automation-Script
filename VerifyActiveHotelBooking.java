package bidInnWebApp;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class VerifyActiveHotelBooking 
{
	
	@Test
	public void verifyPayNowButton() throws InterruptedException, IOException
	{
		/*
		 * WebDriver driver=new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 * driver.get("https://www.bidinn.in/");
		 * 
		 * driver.findElement(By.linkText("Login / Signup")).click();
		 * driver.findElement(By.xpath("//input[@type='number']")).sendKeys("9988776655"
		 * ); driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
		 * 
		 * Thread.sleep(500);
		 * driver.findElement(By.xpath("//input[@type='number'][1]")).sendKeys("1");
		 * driver.findElement(By.xpath("//input[@type='number'][2]")).sendKeys("2");
		 * driver.findElement(By.xpath("//input[@type='number'][3]")).sendKeys("3");
		 * driver.findElement(By.xpath("//input[@type='number'][4]")).sendKeys("4");
		 * driver.findElement(By.xpath("//input[@type='number'][5]")).sendKeys("5");
		 * driver.findElement(By.xpath("//input[@type='number'][6]")).sendKeys("6");
		 * driver.findElement(By.xpath("//button[text()='Verify OTP']")).click();
		 * driver.findElement(By.xpath("//button[text()='OK']")).click();
		 */
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//INPUT[@role='combobox']")).sendKeys("Hotel Shyam");
		driver.findElement(By.xpath("//*[@role='option']")).click();
		
		driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[1]")).click();
		//driver.findElement(By.xpath("(//button[@class=\"rdrNextPrevButton rdrNextButton\"])[1]")).click();
		driver.findElement(By.xpath("//span[text()='27']")).click();
		driver.findElement(By.xpath("//span[text()='28']")).click();
		
		driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[3]")).click();
		driver.findElement(By.xpath("(//button[text()='+'])[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Done'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		driver.findElement(By.xpath("//h5[contains(text(),'Hotel Shyam')]")).click();
		
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
			
		for(String ids:allIds)
		{
			if(!ids.equals(parentId))
			{
				driver.switchTo().window(ids);
				driver.findElement(By.xpath("(//button[@class=\"flex-grow\"])[1]")).click();
				driver.findElement(By.xpath("(//button[@class=\"rdrNextPrevButton rdrNextButton\"])[1]")).click();
				System.out.println(driver.getTitle());
				
				driver.findElement(By.xpath("//button[text()='Facility']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class=\"bg-white w-full rounded-md outline-none flex flex-row\"])[2]")).click();
				WebElement checkIn = driver.findElement(By.xpath("//span[text()='20']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",checkIn);
				checkIn.click();
				
				
				WebElement checkOut = driver.findElement(By.xpath("//span[text()='22']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",checkOut);
				checkOut.click();
				
				driver.findElement(By.xpath("(//div[@id=\"status\"])[3]")).click();
				driver.findElement(By.xpath("(//button[text()='+'])[1]")).click();
				driver.findElement(By.xpath("(//button[text()='Done'])[1]")).click();
				
				driver.findElement(By.xpath("//button[text()='Bid Now']")).click();
				driver.findElement(By.xpath("//button[@class=\"MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedSuccess MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-colorSuccess MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedSuccess MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-colorSuccess MuiButton-disableElevation animate-bounce mui-1m8qqgs\"]")).click();
				
				WebElement proceedToPay = driver.findElement(By.xpath("//button[text()='Proceed to Pay']"));
				WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
				wait.until(ExpectedConditions.elementToBeClickable(proceedToPay));
				proceedToPay.click();
				
				driver.findElement(By.xpath("//input[@type='name']")).clear();
				driver.findElement(By.xpath("//input[@type='name']")).sendKeys(" Krishna");
				
				driver.findElement(By.xpath("//button[text()='Update']")).click();
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,5000)");
				
				Thread.sleep(500);
				
				WebElement payNow = driver.findElement(By.xpath("//button[text()='Pay Now']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);",payNow);
				payNow.click();
				
				Assert.assertTrue(!payNow.isDisplayed());
				System.out.println("Pay Now button is verified. ");
			}
		}
		
	}
	@Test
	public void verifyPayAtHotelButton() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//INPUT[@role='combobox']")).sendKeys("Hotel Shyam");
		driver.findElement(By.xpath("//*[@role='option']")).click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		driver.findElement(By.xpath("//h5[contains(text(),'Hotel Shyam')]")).click();
		
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();
		
		for(String ids:allIds)
		{
			if(!ids.contains(parentId))
			{
				driver.switchTo().window(ids);
				driver.findElement(By.xpath("//button[text()='Facility']")).click();
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//div[@class=\"bg-white w-full rounded-md outline-none flex flex-row\"])[2]")).click();
				WebElement checkIn = driver.findElement(By.xpath("//span[text()='20']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",checkIn);
				checkIn.click();
				
				
				WebElement checkOut = driver.findElement(By.xpath("//span[text()='22']"));
				((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",checkOut);
				checkOut.click();
				
				driver.findElement(By.xpath("(//div[@id=\"status\"])[3]")).click();
				driver.findElement(By.xpath("(//button[text()='+'])[1]")).click();
				driver.findElement(By.xpath("//button[text()='Done']")).click();
				
				driver.findElement(By.xpath("//button[text()='Bid Now']")).click();
			}
		}
	}
}
