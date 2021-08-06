package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {
	@FindBy(css =".dropdown.dropdown-right.active") 
	private WebElement profileBtn;
	@FindBy(css =".dropdown.dropdown-right.active.open .dropdown-menu a")
	private  List<WebElement> profileDropdown ;

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserPageTitle() {
		return getTitle();	
	}
		
	public void chooseUserCategory(String text) {
		click(profileBtn);
		for (WebElement el : profileDropdown) {
			String option = el.getText();
			if (option.equalsIgnoreCase(text)) {
				click(el);
				break;
			}
		}
	}
		
	public void chooseProfileOpt(String text) {
		for (WebElement el : profileDropdown) {
			String option = el.getText();
			if (option.equalsIgnoreCase(text)) {
				sleep(1000);
				click(el);
				break;
			}
		}
	}

}
