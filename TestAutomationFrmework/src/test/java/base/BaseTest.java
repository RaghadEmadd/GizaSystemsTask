package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	// this file includes all the common methods to be used by all tests

	// driver reference
	public static WebDriver driver;
	// reading from property files to use it within the test cases
	//read browser details from properties file
	public static Properties prop = new Properties();
	//read locator details from locator properties file
	public static Properties Loc= new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	
	@BeforeMethod
	public void setUp() throws IOException {
		if (driver == null) {
			//to get the whole path of the current user directory, will be dynamic if framework is used by multiple users
			 fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			 fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");

			prop.load(fr);
			Loc.load(fr1);

		}
		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));

		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

	}
	
	@AfterMethod
	public void TearDown() {
		//close browser
		driver.close();
		System.out.println("closed");

	}
}
