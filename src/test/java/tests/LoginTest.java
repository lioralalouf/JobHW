package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.TopBarMenu;
import pageObjects.LoginPage;
import pageObjects.UserPage;
import utils.Utils;
@Epic("Login")
@Feature("Log in with different credantiald valid and not valid.")
public class LoginTest extends BaseTest{
	
	@Test(description = "Check user is getting error message with invalid values", dataProvider = "getDataInvalid")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As A user, I supposed to get an error message when inseret Invalid credantials .")
	public void tc01_loginFailed(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.Login(email, password);
		String expected = "E-mail or password was incorrect, please try again";
		Assert.assertEquals(lp.getErrorMsg(), expected);
		lp.closeErrorMsg();
	}
	
	@Test(description = "Check user succeed to login with valid values")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As A user, I supposed to be able login with valid credantials and redirected to website user home page.")
	public void tc02_loginSuccess() {
		LoginPage lp = new LoginPage(driver);
    	lp.Login(Utils.readProperty("user"), Utils.readProperty("password"));
    	UserPage up = new UserPage(driver);
    	String expected = "Profile";
    	Assert.assertEquals(up.getUserPageTitle(), expected);	
	}
	
	@Test(description = "Check user succeed to logout and redirected to homepage")
	@Severity(SeverityLevel.BLOCKER)
	public void tc03_logOut() {
		UserPage up = new UserPage(driver);
		up.chooseUserCategory("Profile");
    	up.chooseProfileOpt("Logout");
    	TopBarMenu tp = new TopBarMenu(driver);
    	tp.getHomePageTitle();
    	String expected ="Home of free code snippets for Bootstrap";
    	Assert.assertEquals(tp.getHomePageTitle(), expected);
    	tp.moveToLoginPage();	
	}
	
	@Test(description = "Check multiple users succeed to login with valid values", dataProvider = "getDataValid")
	@Severity(SeverityLevel.BLOCKER)
	@Story("As A user, I supposed to be able login with valid credantials and redirected to website user home page.")
	public void tc04_loginDifferentUsers(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.Login(email, password);
    	UserPage up = new UserPage(driver);
    	String expected = "Profile";
    	Assert.assertEquals(up.getUserPageTitle(), expected);
		up.chooseUserCategory("Profile");
    	up.chooseProfileOpt("Logout");
    	TopBarMenu tp = new TopBarMenu(driver);
    	tp.moveToLoginPage();
	}
	
	@DataProvider
	public Object[][] getDataInvalid() {
		Object[][] myData = { { "", "151413" }, { "lior151413", "" }, { "liora@odoro.co.ill", "12345678" }, { "", "" }, };
		return myData;
	}
	
	@DataProvider
	public Object[][] getDataValid() {
		Object[][] myData = { { "alalouflior@gmail.com", "151413" }, { "alalouflior@gmail.com", "151413" }, { "alalouflior@gmail.com", "151413" }, };
		return myData;
	}
}
