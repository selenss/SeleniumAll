package NewTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class KeyboardInteractions  extends PageFactoryProgram { // PageFactoryProgram classýndaki elementleri görmesini saðladýk.
		
		public WebDriver driver;
		public KeyboardInteractions(){
			System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
			driver=new ChromeDriver();
			PageFactory.initElements(driver, this); // Firefox driver'ýný kullanarak, listelenen elementleri initialize et
			
		}
		@Test (groups={"1"} )
		public void keyboardActs() throws InterruptedException{
			driver.get("https://www.deal4loans.com/apply-home-loans.php");
			full_name.sendKeys("abc");
			full_name.sendKeys(Keys.CONTROL + "a"); // Select all
			Thread.sleep(5000);
			full_name.sendKeys(Keys.CONTROL + "x"); // cut
			Thread.sleep(5000);
			full_name.sendKeys(Keys.CONTROL + "v"); // paste
			Thread.sleep(5000);
			full_name.sendKeys("xyz");
			Thread.sleep(5000);
			full_name.sendKeys(Keys.CONTROL + "z"); // redo
			Thread.sleep(5000);			
			full_name.sendKeys(Keys.CONTROL + "y"); // undo
			Thread.sleep(5000);
			
		}
		
		@Test (groups={"1"} )
		public void capitalLetters() throws InterruptedException{
			driver.get("https://www.deal4loans.com/apply-home-loans.php");
			email.sendKeys("ABC");
			Thread.sleep(5000);
			email.sendKeys(Keys.SHIFT+"abc"); // Büyük harfle yazar. Capslock açýk olsun ya da olmasýn.
			Thread.sleep(5000);
			
		}
		
		@AfterTest
		public void afterAction(){
			driver.quit();
			
		}
}
