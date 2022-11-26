package fb_testcases;

	import java.io.IOException;

import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import fb_base.Baseclass;
	import fb_pages.LoginPage;
	import fb_pages.HomePage;
	

public class HomePageTest extends Baseclass {
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp()throws NullPointerException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("------------- Login the Application ---------------");
		log.info("Open Home Page");
	}

	@Test(priority = 1)
	public void HomePageTitleTest() throws InterruptedException {
		log.info("Opening Home Page");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Facebook");
		Thread.sleep(2000);
		log.info("Title Verified Successfully");
	}

	@Test(priority = 2)
	public void verifyHomePage() throws InterruptedException {

		homePage = homePage.click_home();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void verifyClickOnLogout() throws InterruptedException {
		loginPage = homePage.checkOnLogout();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
