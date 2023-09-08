package common;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.Scenario;

import POM.LoginPageObjs;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import webdriverpackage.WebDriverClass;

public class CommonFunctions {

	private static final Logger Log = (Logger) LogManager.getLogger(CommonFunctions.class);
	public static String Scene=null;

	@Before
	public static void Scenario(Scenario scenario) {
	
		Scene = scenario.getName();
		try {
			SomeUtils.loadproperties();
			if(WebDriverClass.getDriver()==null) {
			WebDriverClass.launchBrowser();
			initElements();
			LogintoOrange();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	private static void LogintoOrange() {
		
		try {
		
			WebDriverClass.getDriver().get(Constants.URL);
			Log.info("URL Launched");
			WebDriverClass.getDriver().manage().window().maximize();
			Log.info("Window Maximized");
			WebDriverClass.getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
			
			LoginPageObjs.getLoginInstance().getUSERNAME().sendKeys("Admin");
			LoginPageObjs.getLoginInstance().getPASSWORD().sendKeys(Constants.PASSWORD);
			LoginPageObjs.getLoginInstance().getLoginBtn().click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	private static void initElements() {
		
		PageFactory.initElements(WebDriverClass.getDriver(), LoginPageObjs.getLoginInstance());
	}
	

	@AfterStep
	public void TakeScreenCapture(Scenario scenario) {
		
		if(scenario.isFailed()) {
		System.out.println("Hi Im Screenshot");
		
		byte[] screenshot = ((TakesScreenshot)WebDriverClass.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "ErrorScreen");
		}
		
	}
	
}
