package NewTest;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleFrameAlerts {
	
	public WebDriver driver;
	
	public HandleFrameAlerts(){
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	
		
		
	
	}
	
	@BeforeTest
	public void beforeAtions() throws InterruptedException{
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");	
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void afterActions() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	
	@Test (groups={"1"} )
	public void handleFrames() throws InterruptedException{
		
		WebElement frame= driver.findElement(By.id("iframeResult")); // Selenium <iframe></iframe> taglarýnýn içindeki elementleri görmez. O yüzden önce iframe'i tanýtmak lazým.
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/button")).click();
	}
	
	@Test  (groups={"1"} )
	public void handleAlerts() throws InterruptedException{
		WebElement frame= driver.findElement(By.id("iframeResult")); // Selenium <iframe></iframe> taglarýnýn içindeki elementleri görmez. O yüzden önce iframe'i tanýtmak lazým.
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/button")).click();
		Alert alert= driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept(); // OK confirmation button
		// alert.dismiss(); // Cancel button
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("/html/body/div[4]/ul/li[6]/button")).click();
		Thread.sleep(2000);
		
        WebElement frame2= driver.findElement(By.id("google_ads_iframe_/16833175/TryitLeaderboard_0"));
        driver.switchTo().frame(frame2);
        Thread.sleep(6000);
		driver.findElement(By.id("google_image_div")).click();
	
		Thread.sleep(2000);
		
	}
}
