package NewTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTest {
	
public WebDriver driver;
	
	public JunitTest(){
		
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


	
}
