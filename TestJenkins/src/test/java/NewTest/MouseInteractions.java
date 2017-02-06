package NewTest;



import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;



public class MouseInteractions extends PageFactoryProgram {
	
	public WebDriver driver;
	public MouseInteractions(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
		driver=new ChromeDriver();
		PageFactory.initElements(driver, this); // Firefox driver'ýný kullanarak, listelenen elementleri initialize et
		
	}
	@Test (groups={"1"} )
	public void mouseOverMoveAct() throws InterruptedException{
		driver.get("http://www.deal4loans.com/personal-loan.php");
		Actions builder = new Actions(driver); // standard for building actions
		builder.moveToElement(personal_loan_menu).perform();
		Thread.sleep(2000);
		first_click.click();
		Thread.sleep(2000);
		Reporter.log("mouseOverMoveAct",true);
		
	}
	@Test (groups={"1"} )
	public void dragDrop() throws InterruptedException{
		driver.get("http://html5demos.com/drag");
		Thread.sleep(5000);
	//	WebElement frame= drag_drop_frame; // Selenium <iframe></iframe> taglarýnýn içindeki elementleri görmez. O yüzden önce iframe'i tanýtmak lazým.
	//	driver.switchTo().frame(frame);
		
		Point point = drag_image.getLocation();
		int xcord=point.getX();
		int ycord=point.getY();
		System.out.println(xcord +"  " + ycord);
		Actions builder = new Actions(driver);

		builder.dragAndDrop(drag_image, drop_box).perform();
		Thread.sleep(5000);
		xcord=point.getX();
		ycord=point.getY();
		System.out.println(xcord +"  " + ycord);
		Assert.assertFalse(drag_image.isDisplayed());
		Reporter.log("dragDrop",true);
	}
	
	@AfterTest
	public void afterAction(){
		driver.quit();
		
	}

}
