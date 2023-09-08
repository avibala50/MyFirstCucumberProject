package step_definitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebElement;

import POM.LoginPageObjs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyCEO {
	
	private static final Logger Log = (Logger) LogManager.getLogger(VerifyCEO.class);
	
	@Given("User in the Dashboard Page")
	public void user_in_the_dashboard_page() {
	  Log.info("User in the Dashboard page");
	  
	}

	@When("User navigates to Directory Page")
	public void user_navigates_to_directory_page() {
		Log.info("User navigates to Directory Page");
		try {
			LoginPageObjs.getLoginInstance().getDirectory().click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	@When("user search as {string} as Job_Title")
	public void user_search_as_as_job_title(String job) throws InterruptedException {
		Log.info("user search as {string} as Job_Title");
		try {
			LoginPageObjs.getLoginInstance().getJobTitle().click();
			
			for (WebElement element: LoginPageObjs.getLoginInstance().getJobOptions()) {
				if(element.getText().equalsIgnoreCase(job)) {
					element.click();
					break;
				}
			}
			Thread.sleep(3000);
			LoginPageObjs.getLoginInstance().getSearch().click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Then("the user should see the {string} as below")
	public void the_user_should_see_the_as_below(String Expected) {
	
		Log.info("the user should see the {string} as below");
		try {
		
			String actual = LoginPageObjs.getLoginInstance().getName().getText();
			
			if(actual.equalsIgnoreCase(Expected))
			{
				Log.info("CEO verified");
				System.out.println("Matched");
				
			}
			
			else {
				
			 Log.error("CEO name mismatch");
			}

			
		} catch (Exception e) {
		   e.printStackTrace();
		}

		
}
}