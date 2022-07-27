package pomClassess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='txtUsername']") private WebElement UserID; 
	@FindBy(xpath="//input[@id='txtPassword']") private WebElement Pwd;
	@FindBy(xpath="//input[@id='btnLogin']") private WebElement Login;
	
	public void UserName()
	{
		UserID.sendKeys("Admin");
	}
	
	public void Password()
	{
		Pwd.sendKeys("admin123");
	}
	
	public void LoginButton()
	{
		Login.click();
	}
	
	public String verifylink()
	{
		String x= driver.getCurrentUrl();
		return x;
		
	}
	
}
