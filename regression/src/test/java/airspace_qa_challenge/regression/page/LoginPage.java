package airspace_qa_challenge.regression.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import airspace_qa_challenge.regression.constant.LoginConstant;



public class LoginPage implements LoginConstant {

	@FindBy(xpath = LoginConstant.USERNAME_XPATH_LOCATOR)
	 private WebElement usernameElem;
	@FindBy(xpath = LoginConstant.PASSWORD_XPATH_LOCATOR)
	 private WebElement pwdElem;
	@FindBy(css = LoginConstant.LOGIN_BTN_LOCATOR)
	 private WebElement loginBtnElem;
	@FindBy(xpath = LoginConstant.MESSAGE_XPATH_LOCATOR)
	 private WebElement messageElem;
	@FindBy(xpath = LoginConstant.LOGOUT_BTN_LOCATOR)
	 private WebElement logoutBtnElem;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    public void performLogin(String username, String password) {
    	setUserName(username);
    	setPassword(password);
    	clickLogin();
    }
	public void setUserName(String username) {
		usernameElem.sendKeys(username);
	}
	public void setPassword(String password) {
		pwdElem.sendKeys(password);
	}

	public void clickLogin() {
		loginBtnElem.click();
	}
	public String getMessage() {
		return messageElem.getText();
	}
	public void clickLogout() {
		logoutBtnElem.click();
	}

	

}
