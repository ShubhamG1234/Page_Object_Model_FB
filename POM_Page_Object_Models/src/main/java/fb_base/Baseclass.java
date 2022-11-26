package fb_base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import fb_utility.TestUtil;

public class Baseclass {
	public static Properties prop;
	public static WebDriver driver;
	public static Logger log =Logger.getLogger(Baseclass.class) ;
	
	
	
	public Baseclass() 
	{
		//try {
		prop = new Properties();
		FileInputStream ip = null;
		 
			try {
				ip= new FileInputStream("C:\\Users\\SHUBHAM\\eclipse-workspace\\POM_Page_Object_Models\\src\\main\\java\\fb_config\\config.properties");
				try {
					prop.load(ip);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SHUBHAM\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
			 log.info("Lunching Chrome Browser....");
		}
		 else if (browserName.equals("firefox")) {
			 System.setProperty("webdriver.gecko.driver", "C:\\Users\\SHUBHAM\\Desktop\\TST\\geckodriver-v0.32.0-win-aarch64\\geckodriver.exe");
			
				driver = new FirefoxDriver();
				log.info("Lunching Firefox Browser....");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		log.info("Maximizing Browser....");
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TImeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT,TimeUnit.SECONDS);
		
		log.info("Opening Application URL....");
			
		
	}

}