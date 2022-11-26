package fb_pages;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import fb_base.Baseclass;

public class HomePage extends Baseclass {
	
	@FindBy(xpath = "//span[contains(text(), 'Shubham Gole')]")
    WebElement userNameLabel;
	
	@FindBy(xpath="//div[@class='x78zum5 x1n2onr6']")
	WebElement dropDownLink;
	
	@FindBy(xpath="//span[contains(text(),'Log Out')]")
	WebElement logout;

	@FindBy(xpath="//a[@aria-label='Home']")
	WebElement home;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	public boolean verifyCorrectUserName() {
        return userNameLabel.isDisplayed();
    }

	
	public HomePage click_home() {
		home.click();
		return new HomePage();
	}
	
	public LoginPage  checkOnLogout() {
		logout.click();
		return new LoginPage();
	}
	
	
}