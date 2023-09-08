package webdriverpackage;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import step_definitions.VerifyTimesheets;

public class WebDriverClass {
	private static final Logger Log = (Logger) LogManager.getLogger(WebDriverClass.class);
	
	private static WebDriver driver = null;
	
	public static void launchBrowser() {
		
		try {
		
			switch ("chrome") {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				Log.info("Chrome is Starting");
				break;

			default:
				break;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
			}
	
	
	


	public static WebDriver getDriver() {
		return driver;
	}

	
	
	

}
