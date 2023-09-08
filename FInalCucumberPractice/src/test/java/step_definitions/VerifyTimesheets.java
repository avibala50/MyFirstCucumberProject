package step_definitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import POM.LoginPageObjs;
import common.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyTimesheets {
	
	private static final Logger Log = (Logger) LogManager.getLogger(VerifyTimesheets.class);
	
	@Given("User is on the TImesheet page")
	public void user_is_on_the_t_imesheet_page() {
		
		try {
			Log.info("User is on the TImesheet page");
			LoginPageObjs.getLoginInstance().getTime().click();;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	@When("User selects the Employee {string} and Click on View button")
	public void user_selects_the_employee_and_click_on_view_button(String Name) {
		
		try {
			Log.info("User selects the Employee {string} and Click on View button");
			LoginPageObjs.getLoginInstance().getEmpName().sendKeys(Name);
			//Thread.sleep(4000);
			for (WebElement element : LoginPageObjs.getLoginInstance().getEmpoptions()) {
				
				if(element.getText().equalsIgnoreCase(Name)) {
					
					element.click();
					break;
				}	
			}
			LoginPageObjs.getLoginInstance().getEmpview().click();
			//Thread.sleep(3000);
			
		} catch (Exception e) {
			Log.error("Errorrrrrrrrrr");
			//CommonFunctions.TakeScreenCapture();
			System.out.println("Errorrrrrrr");
		}
		
	}

	@Then("The User should see the Message")
	public void the_user_should_see_the_message() {
		try {
		
			Log.info("The User should see the Message");
			
			String Expected = "No Timesheets Found";
			String Actual = LoginPageObjs.getLoginInstance().getAlert().getText();
			
			System.out.println(Actual);
			if(Expected.equalsIgnoreCase(Actual)) {
				
				Log.info("User seen the message");
				System.out.println("No Time Sheets");
			}

			
		} catch (Exception e) {
			//e.printStackTrace();
			//CommonFunctions.TakeScreenCapture();
			System.out.println("deeeeiiii");
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
			
		}
		
			}


}
