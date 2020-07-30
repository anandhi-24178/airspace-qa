package airspace_qa_challenge.regression.base;

import java.util.concurrent.TimeUnit;
 

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
	System.setProperty("webdriver.chrome.driver","E:\\anandhi\\chromedriver_win\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/login");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
}
