package POM;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjs {
	
	
	private static LoginPageObjs getinstance=null;
	
	private LoginPageObjs() {
	}
	
	public static LoginPageObjs getLoginInstance() {
	
		if(getinstance==null) {
			
			getinstance = new LoginPageObjs();
			
		}
		return getinstance;
	}
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement USERNAME;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement PASSWORD;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement LoginBtn;
	
	@FindBy(xpath="(//li[@class='oxd-main-menu-item-wrapper'])[9]")
	private WebElement directory;

	@FindBy(xpath = "(//div[@class='oxd-select-wrapper'])[1]//div[@class='oxd-select-text-input']")
	private WebElement JobTitle;
	
	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> JobOptions;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search;
	
	@FindBy(xpath = "//div[@class='orangehrm-profile-picture']/preceding::p[1]")
	private WebElement Name;
	
	@FindBy(xpath = "(//li[@class='oxd-main-menu-item-wrapper'])[4]")
	private WebElement Time;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--before']/following-sibling::input")
	private WebElement EmpName;
	
	@FindBy(xpath = "//div[@role='option']")
	private List<WebElement> empoptions;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement empview;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement alert;
	
	public WebElement getUSERNAME() {
		return USERNAME;
	}

	public WebElement getPASSWORD() {
		return PASSWORD;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public WebElement getDirectory() {
		return directory;
	}

	public WebElement getJobTitle() {
		return JobTitle;
	}

	public List<WebElement> getJobOptions() {
		return JobOptions;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getTime() {
		return Time;
	}

	public WebElement getEmpName() {
		return EmpName;
	}

	public List<WebElement> getEmpoptions() {
		return empoptions;
	}

	public WebElement getEmpview() {
		return empview;
	}

	public WebElement getAlert() {
		return alert;
	}

	
	
	
	
	
	

	
	
	
	
	
}
