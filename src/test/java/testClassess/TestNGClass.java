package testClassess;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browserSetup.POJO;
import pomClassess.Dashboard_AboutandLogouttab;
import pomClassess.Dashboard_Infotab;
import pomClassess.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGClass extends POJO {

	WebDriver driver;
	LoginPage obj1;
	String link;
	String ActualLink = "https://opensource-demo.orangehrive.com/index.php/dashboard";
	Dashboard_Infotab obj2;
	Dashboard_AboutandLogouttab obj3;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {
		driver = OpenChromeBrowser();
	}

	@BeforeClass
	public void beforeClass() {
		obj1 = new LoginPage(driver);
		obj2 = new Dashboard_Infotab(driver);
		obj3 = new Dashboard_AboutandLogouttab(driver);
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {

		System.out.println("Before Method");

	}

	@Test
	public void verification() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		obj1.UserName();
		obj1.Password();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnLogin']")));

		obj1.LoginButton();
		link = driver.getCurrentUrl();
		System.out.println(link);
		Assert.assertEquals(ActualLink, link);
		System.out.println("Test 1");

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(ActualLink, link);
		soft.assertAll();

	}

	@Test(priority = 1)

	public void myinfo() throws InterruptedException {
		obj2.My_info();
		Thread.sleep(2000);
		System.out.println("Test 2");

	}

	@Test(priority = 2)
	public void Dashboard_AboutandLogouttab() throws InterruptedException {

		Thread.sleep(3000);
		obj3.WelcomeNameTab();
		Thread.sleep(2000);
		obj3.Aboutinfotab();
		Thread.sleep(2000);
		obj3.AboutClose();
		Thread.sleep(2000);
		System.out.println("Test 3");
		obj3.logout();
	}

	@Test
	public void softAssert() {
		SoftAssert soft = new SoftAssert();

		String s1 = "pqr";
		String s2 = "pqr";
		soft.assertEquals(s1, s2, "Failed1 :Both Results are Different");

		String s3 = "Random string";
		String s4 = "Pune";
		soft.assertNotEquals(s3, s4, "Failed2 : Both Results are Same");

		boolean s5 = true;
		soft.assertTrue(s5);

		soft.assertAll();
	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("After Method");

	}

	@AfterClass
	public void afterClass() {
		obj1 = null;
		obj2 = null;
		obj3 = null;

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
		driver = null;
		System.gc();
	}
}
