package fb_testcases;

	import java.io.IOException;

import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import fb_base.Baseclass;
	import fb_pages.HomePage;
	import fb_pages.LoginPage;

public class LoginPageTest extends Baseclass {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException 
	{
		// This super() keyword will call the constructor of the base class
		super();
	}

	@BeforeMethod
	public void setUp() 
	{
		initialization();
		loginPage = new LoginPage();
		homePage= new HomePage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() 
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}

	@Test(priority = 2)
	public void faceBookLogoImageTest() 
	{
		boolean flag = loginPage.validateFaceBookImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() 
	{
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}