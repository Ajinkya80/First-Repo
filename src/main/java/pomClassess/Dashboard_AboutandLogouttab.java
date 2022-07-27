package pomClassess;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard_AboutandLogouttab {

		public Dashboard_AboutandLogouttab(WebDriver driver){
			
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//*[@id='welcome']") private WebElement welcometab;
		@FindBy(xpath="//a[@id='aboutDisplayLink']")private WebElement aboutinfo;
		@FindBy(xpath="//*[@class='close']") private WebElement aboutclose;
		@FindBy(xpath="//*[text()='Logout']") private WebElement logout;
		
		public void WelcomeNameTab()
		{
			welcometab.click();
		}
		public void Aboutinfotab()
		{
			aboutinfo.click();
		}
		public void AboutClose()
		{
			aboutclose.click();
		}
		public void logout()
		{
			logout.click();
		}
}
