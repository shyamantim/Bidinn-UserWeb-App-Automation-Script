package bidInnWebApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import BidinnHotelierWebApp.HotelierLogin;

public class UserLogin
{
	Properties properties;
	public UserLogin() throws IOException
	{
	FileInputStream fis = new FileInputStream("C:\\Users\\chand\\eclipse-workspace\\Selenium\\src\\bidInnWebApp\\CredentialsUserMobiAndOTP.properties");
    properties = new Properties();
    properties.load(fis);
	}
	
    public String getUserMob() 
    {
        return properties.getProperty("userMob");
    }

   /* public String getOTP()
    {
        return properties.getProperty("OTP");
    }
    */
    WebDriver driver;
	public WebDriver getDriver()
	{
        return driver;
    }
	
	@Test
	public void userLogin() throws InterruptedException, IOException
	{
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.bidinn.in/");
		
		
		Thread.sleep(500);
		driver.findElement(By.linkText("Login / Signup")).click();
		
		
		WebElement userMob = driver.findElement(By.xpath("//input[@type='number']"));
		
		
		Thread.sleep(500);
		
		UserLogin ul1=new UserLogin();
		
		userMob.sendKeys(ul1.getUserMob());
		driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
		//password.sendKeys(ul1.getPassword());
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@type='number'][1]")).sendKeys("1");
		driver.findElement(By.xpath("//input[@type='number'][2]")).sendKeys("2");
		driver.findElement(By.xpath("//input[@type='number'][3]")).sendKeys("3");
		driver.findElement(By.xpath("//input[@type='number'][4]")).sendKeys("4");
		driver.findElement(By.xpath("//input[@type='number'][5]")).sendKeys("5");
		driver.findElement(By.xpath("//input[@type='number'][6]")).sendKeys("6");
		
		driver.findElement(By.xpath("//button[text()='Verify OTP']")).click();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
	}
}
