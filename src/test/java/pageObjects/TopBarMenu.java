package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBarMenu extends BasePage {
	@FindBy(css = "#nav-login-btn")
	private WebElement loginTab;

	public TopBarMenu(WebDriver driver) {
		super(driver);
	}
	public void moveToLoginPage() {
		sleep(1500);
		click(loginTab);
	}
	
	public String getHomePageTitle() {
		return getTitle();	
	}
}



