package pomClassess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_Infotab {
WebDriver driver;
	public Dashboard_Infotab(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//*[text()='My Info']")) private WebElement myinfo;
	
	public void My_info()
	{
		myinfo.click();
	}
	
	
	
}
