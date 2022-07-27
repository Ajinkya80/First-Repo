package browserSetup;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POJO {
	
	public static WebDriver OpenChromeBrowser() 
	{
	
		System.setProperty("webdriver.chrome.driver","src"+File.separatorChar+"test"+File.separatorChar+"resources"+File.separatorChar+"Browser"+File.separatorChar+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		
		
		return driver;
	}

}
