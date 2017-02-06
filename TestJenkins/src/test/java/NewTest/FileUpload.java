package NewTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
	
		public WebDriver driver;

			
			public FileUpload(){
				
				System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().window().maximize();
			
				
				
			
			}
			
			
			
			@BeforeMethod
			public void beforeAtions() throws InterruptedException{
				driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");	
				Thread.sleep(5000);
				
			}
			
			@AfterMethod
			public void afterActions() throws InterruptedException{
				Thread.sleep(2000);
				driver.quit();
				
			}
			
			@Test
			public void test(){
				driver.findElement(By.xpath("//div[@class='row']//input[@multiple='']")).sendKeys("C:/Users/selens/Desktop/test.png");
				String file_name=driver.findElement(By.xpath("//tr[@class='ng-scope']/td/strong[text()='test.png']")).getText();
				Assert.assertEquals("test.png",file_name);
				Reporter.log("test",true);
				
				
				
				}
			
			
			
			

}
