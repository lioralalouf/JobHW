package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css = ".dropdown.dropdown-right")
	private WebElement loginPageTitle;
	@FindBy(css = ".form-control.email-title")
	private WebElement userName;
	@FindBy(css = "[name='password']")
	private WebElement userPassword;
	@FindBy(css = ".checkbox")
	private WebElement checkbox;
	@FindBy(css = ".btn.btn-lg")
	private WebElement loginBtn;
	@FindBy(css = ".alert.bs-callout h5")
	private WebElement errorMsg;
	@FindBy(css = ".alert.bs-callout button")
	private WebElement errorCloseBtn;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public String getLoginPageTitle() {
		return getTitle();	
	}
	//full process for fill in login form and login
	public void Login(String email, String password) {
		fillText(userName, email);
		fillText(userPassword, password);
		click(checkbox);
		click(loginBtn);
	}
	
	public String getErrorMsg() {
		sleep(1000);
		return getText(errorMsg);	
	}
	
	public void closeErrorMsg() {
		click(errorCloseBtn);
	}
	
}
