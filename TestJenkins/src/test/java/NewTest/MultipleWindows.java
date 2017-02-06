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
		driver.findElement(By.linkText("privacy policy")).click(); // target="_blank" olmas�na dikkat et.
		Set<String> browsers = driver.getWindowHandles(); //a��k pencerelerin id'sini al�r ve array d�nd�r�r.
		System.out.println("Number of open tabs is: " + browsers.size()); // bu �rnek i�in 2 tane a��k tab var.
	//	System.out.println(driver.getCurrentUrl()); // get() methodu ile gitti�in ilk sayfaya tekab�l ediyor. Bu sayfa i�inde click() methodunu kulland���n sayfa de�il.
	//	driver.close(); currentURL'ini ald��� aktif tab� kapat�yor.
	//	Set<String> browser = driver.getWindowHandles();
	//	System.out.println("after closing home page:" + browser.size()); // bu �rnek i�in 1 kal�yor.
		for (String browser: browsers){
			System.out.println("Active tab id: " + browser); // a��lacak tablar�n id'lerini al�yor ve her birini bir String de�erine at�yor.
			driver.switchTo().window(browser); // a��lacak di�er taba ge�. Yani current URL'i de�i�tir.
	//		System.out.println(driver.getCurrentUrl()); // current URL'in switchTo().window(browser) ile de�i�tirdi�imin kan�t�.
			if (driver.getTitle().equals("Privacy Policy - Deal4loans.com's Services | Online Loan Application And Information")){
				WebElement example=driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[2]/p[1]/a"));
				example.click();
				driver.close(); // currentURL'i olan tab� kapat�r. Bu �rnekte "example" variable'n�n a��ld��� tab� kapat�r sadece.
				
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
				
				System.out.println("Biraz daha bak �yle gel hayat�m... ");
			}
				
			
		}
		
		
	}
}
