package NewTest;

//import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
//import static org.junit.Assert.assertEquals;

public class TestNGPrg extends PageFactoryProgram {
	
	public WebDriver driver;
	public TestNGPrg(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
		driver=new ChromeDriver();
		PageFactory.initElements(driver, this); // Firefox driver'ýný kullanarak, listelenen elementleri initialize et
		
	}
	
	
	
	@BeforeSuite(alwaysRun=true) //Tüm test caselerin öncesinde (alwaysRun=true) eðer bir classtan inherit ediyorsa ve o classlarda beforesuit yoksa her bir test case executionýndan önce bunu yap demek 
	
	public void beforeAllTestCases(){
		driver.manage().window().maximize();
	}
	
	@AfterSuite(alwaysRun=true) //Tüm test caselerin sonrasýnda
	
	public void afterAllTestCases(){
		driver.quit();
	}
	
/*	@BeforeMethod(alwaysRun=true) // her case öncesinde 
	public void beforeMethodAllTestCases() throws InterruptedException{
		driver.get("http://www.twitter.com");
		Thread.sleep(2000);
		
	}
	
	@AfterMethod(alwaysRun=true) // her case sonrasýnda
	public void afterMethodAllTestCases() throws InterruptedException{
		driver.get("http://www.gmail.com");
		Thread.sleep(2000);
		
		
	}*/
	
	
	@Test (priority=3, testName="Move the mouse", description="Open submenu", timeOut=30000,enabled=true,groups={"1"} )
	public void mouseOverMoveAct() throws InterruptedException{
		driver.get("http://www.deal4loans.com/personal-loan.php");
		Actions builder = new Actions(driver); // standard for building actions
		builder.moveToElement(personal_loan_menu).perform();
		Thread.sleep(2000);
		first_click.click();
		Thread.sleep(2000);
		Reporter.log("mouseOverMoveAct",true);
		
	}
	
	@Test (priority=2, testName="Keyboard", description="select, cut, paste,redo,undo", enabled=true,groups={"1"})
	public void keyboardActs() throws InterruptedException{
		driver.get("https://www.deal4loans.com/apply-home-loans.php");
		full_name.sendKeys("abc");
		full_name.sendKeys(Keys.CONTROL + "a"); // Select all
		Thread.sleep(2000);
		full_name.sendKeys(Keys.CONTROL + "x"); // cut
		Thread.sleep(2000);
		full_name.sendKeys(Keys.CONTROL + "v"); // paste
		Thread.sleep(2000);
		full_name.sendKeys("xyz");
		Thread.sleep(2000);
		full_name.sendKeys(Keys.CONTROL + "z"); // redo
		Thread.sleep(2000);			
		full_name.sendKeys(Keys.CONTROL + "y"); // undo
		Thread.sleep(2000);
		Reporter.log("keyboardActs",false);

	}
	
	@Test (priority=1, testName="Capital Letters", description="Enter capital letters", timeOut=60000,enabled=true,groups={"1"})
	public void capitalLetters() {
		driver.get("https://www.deal4loans.com/apply-home-loans.php");
		email.sendKeys("ABC");
		//Thread.sleep(2000);
		email.sendKeys(Keys.SHIFT+"abc"); // Büyük harfle yazar. Capslock açýk olsun ya da olmasýn.
		loan_amount.sendKeys("test");
		String test_string=loan_amount.getText();
		Assert.assertFalse(test_string.isEmpty(), "Loan Amount field does not contain string entry.'Enter only integer value' message can be added");
		//Thread.sleep(2000);
		Reporter.log("capitalLetters",false);
		
	}
	
	
	
	

}
