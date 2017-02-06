package NewTest;

import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageFactoryTest extends PageFactoryProgram { // PageFactoryProgram classýndaki elementleri görmesini saðladýk.
	
	public WebDriver driver;
	public PageFactoryTest(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
		driver=new ChromeDriver();
		PageFactory.initElements(driver, this); // Firefox driver'ýný kullanarak, listelenen elementleri initialize et
		
	}

	@Test (groups={"1"} )
	public void exapmlePF() throws InterruptedException{
		driver.get("https://www.deal4loans.com/apply-home-loans.php");
		loan_amount.sendKeys("test");
		String test_string=loan_amount.getText();
		Thread.sleep(2000);
		Assert.assertEquals(false,test_string.isEmpty());
		Select a = new Select(employment_status);
		a.selectByIndex(1);
		Thread.sleep(10000);
		
	}
	
	@AfterTest
	public void afterAction(){
		driver.quit();
		
	}

}
