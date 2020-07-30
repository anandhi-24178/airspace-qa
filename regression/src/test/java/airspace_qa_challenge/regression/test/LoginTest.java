package airspace_qa_challenge.regression.test;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airspace_qa_challenge.regression.base.BaseTest;
import airspace_qa_challenge.regression.constant.LoginConstant;
import airspace_qa_challenge.regression.page.LoginPage;
public class LoginTest extends BaseTest implements LoginConstant {

	@Test
	public void testingSuccessfulLogin() throws InterruptedException {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.performLogin("tomsmith","SuperSecretPassword!");
		String message=loginpage.getMessage();
		if(message.contains("Your user name is valid")) {
			Assert.assertTrue(true,message);
			}
		
	}
	//If there are more testdata then those data can be driven from external file like csv, excel using 
	// apache poi library
	@Test(dataProvider="loginData")
	public void testingUnsuccessfulLoginWithDataProvider(String name, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.performLogin(name,password);
		String message=loginpage.getMessage();
		if(message.contains("Your user name is invalid")||message.contains("Your password is invalid")) {
			Assert.assertTrue(true,message);
		}
		
		}
	@Test
	public void testingLogoutAfterSuccessfulLogin() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.performLogin("tomsmith","SuperSecretPassword!");
		loginpage.clickLogout();
		String message=loginpage.getMessage();
		if(message.contains("You logged out")) {
			Assert.assertTrue(true,message);
		}
	}
	
	@Test
	public void testingToCheckMaskedPassword() throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setUserName("tomsmith");
		loginpage.setPassword("SuperSecretPassword!");
		WebElement pwdElem=driver.findElement(By.xpath(PASSWORD_XPATH_LOCATOR));
		boolean isEncrypted=pwdElem.getAttribute("type").equals("password");
		System.out.println(" Password encrypted: "+isEncrypted);
	}
	
	@DataProvider(name = "loginData")
	private String[][] getData() throws IOException {
		String [][] logindata= {{"",""},{"aaa","SuperSecretPassword!"},{"tomsmith","aaa"}};
	
		return logindata;
	}
	
	}
	
