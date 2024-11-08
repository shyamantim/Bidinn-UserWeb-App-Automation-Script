package bidInnWebApp;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProfilePage 
{
	@Test(priority=1)
	public void exploreNowTextLink() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		driver.findElement(By.linkText("Explore now")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("All Hotels, resorts"));
		System.out.println("Explore Now Text Link is Verified. ");
		driver.quit();
	}
	@Test(priority=2)
	public void verifyBidNowImageLink() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.xpath("//img[@src=\"/images/home/deal2.png\"]")).click();
		String title1 = driver.getTitle();
		Assert.assertTrue(title1.contains("All Hotels, resorts"));
		System.out.println("Bid Now Image Link is verified. ");
		driver.quit();
	}
	@Test(priority=3)
	public void verifyBookingTextLinkFromMainMenu() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		driver.findElement(By.linkText("Booking")).click();
		WebElement webElement = driver.findElement(By.xpath("//button[text()='Upcoming']"));
		Assert.assertTrue(webElement.isDisplayed());
		System.out.println("Booking Link is Verified. ");
		driver.quit();
	}
	
	@Test(priority=4)
	public void verifyPrifileLinkFromMainMenu() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		WebElement element = driver.findElement(By.xpath("//p[text()='customer']"));
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Profile Link Of Main Menu Is Verified.");
		driver.quit();
	}
	@Test(priority=5)
	public void verifyViewProfileTextLinkOfProfileDropDown() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		driver.findElement(By.linkText("View profile")).click();
		
		WebElement element = driver.findElement(By.xpath("//p[text()='customer']"));
		Assert.assertTrue(element.isDisplayed());
		System.out.println("View Profile Text link is Verified. ");
		driver.quit();
	
	}
	@Test(priority=6)
	public void verifyAccountSeetingTextLink() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		driver.findElement(By.linkText("Account Settings")).click();
		WebElement element = driver.findElement(By.xpath("//h3[text()='Personal Information']"));
		Assert.assertTrue(element.isDisplayed());
		System.out.println("Account Settings Text Link is Verified. ");
		driver.quit();
	}
	@Test(priority=7)
	public void verifyLogoutButton() throws InterruptedException, IOException
	{
		UserLogin ul=new UserLogin();
		ul.userLogin();
		
		WebDriver driver=ul.getDriver();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault mui-5tp8uj\"]")).click();
		driver.findElement(By.linkText("Profile")).click();
		
		driver.findElement(By.xpath("//span[@class=\"flex items-center gap-2 font-medium text-dark \"]")).click();
		driver.findElement(By.xpath("//button[text()='Logout']")).click();
		driver.quit();
	}
}
