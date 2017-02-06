package NewTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PageFactoryProgram {
	
	@FindBy (id="Loan_Amount")
	public WebElement loan_amount;
	
	@FindBy (id="Employment_Status")
	public WebElement employment_status;
	
	@FindBy (id="Name")
	public WebElement full_name;
	
	@FindBy (id="Email")
	public WebElement email;
	
	@FindBy (xpath="//li//a[text()='Personal Loan']")
	public WebElement personal_loan_menu;
	
	@FindBy (xpath="//a[text()='Personal Loan Bangalore']")
	public WebElement first_click;
	
	@FindBy (id="five")
	public WebElement drag_image;
	
	@FindBy (id="bin")
	public WebElement drop_box;
	
	@FindBy (id="iframeResult")
	public WebElement drag_drop_frame;
	
}
