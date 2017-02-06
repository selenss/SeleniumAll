package NewTest;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;


public class MultipleWindows {
	public WebDriver driver;
	
	public MultipleWindows(){		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/selens/Desktop/draft-things-selenium/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test(){
		
		driver.get("http://www.deal4loans.com/apply-education-loans.php");
		driver.findElement(By.linkText("privacy policy")).click(); // target="_blank" olmasýna dikkat et.
		Set<String> browsers = driver.getWindowHandles(); //açýk pencerelerin id'sini alýr ve array döndürür.
		System.out.println("Number of open tabs is: " + browsers.size()); // bu örnek için 2 tane açýk tab var.
	//	System.out.println(driver.getCurrentUrl()); // get() methodu ile gittiðin ilk sayfaya tekabül ediyor. Bu sayfa içinde click() methodunu kullandýðýn sayfa deðil.
	//	driver.close(); currentURL'ini aldýðý aktif tabý kapatýyor.
	//	Set<String> browser = driver.getWindowHandles();
	//	System.out.println("after closing home page:" + browser.size()); // bu örnek için 1 kalýyor.
		for (String browser: browsers){
			System.out.println("Active tab id: " + browser); // açýlacak tablarýn id'lerini alýyor ve her birini bir String deðerine atýyor.
			driver.switchTo().window(browser); // açýlacak diðer taba geç. Yani current URL'i deðiþtir.
	//		System.out.println(driver.getCurrentUrl()); // current URL'in switchTo().window(browser) ile deðiþtirdiðimin kanýtý.
			if (driver.getTitle().equals("Privacy Policy - Deal4loans.com's Services | Online Loan Application And Information")){
				WebElement example=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[2]/p[1]/a"));
				example.click();
				driver.close(); // currentURL'i olan tabý kapatýr. Bu örnekte "example" variable'nýn açýldýðý tabý kapatýr sadece.
				
			}			
			
						
			
		}
		Set<String> browsers1 = driver.getWindowHandles();
		
		
		for (String browser: browsers1){
			driver.switchTo().window(browser);
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.id("Email")).sendKeys("example@gmail.com");
			
			if(driver.getCurrentUrl().equals("http://www.deal4loans.com/apply-education-loans.php")){
				System.out.println("I am here: "+driver.getTitle());
				driver.quit();
				
			}
			else{
				
				System.out.println("Biraz daha bak öyle gel hayatým... ");
			}
				
			
		}
		
		
	}
}
