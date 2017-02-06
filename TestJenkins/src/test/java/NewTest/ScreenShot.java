package NewTest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ScreenShot {
public WebDriver driver;

	
	public ScreenShot(){
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	
		
		
	
	}
	
	
	
	@BeforeTest
	public void beforeAtions() throws InterruptedException{
		driver.get("http://www.espnciricinfo.com/");	
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void afterActions() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
		
	}
	
	@Test (groups={"1"} )
	public void test(){
		String screenshot_name = UUID.randomUUID().toString(); // generates alpha-numeric text
		
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
	
		// now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("C:/Users/selens/Desktop/"+screenshot_name+".png")); // saklanan imajlarýn override etmesini engelliyor. Override'da sýkýntý yoksa screenshot.png yapabilirsin her þeyi
		}
		 
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
	}

}
