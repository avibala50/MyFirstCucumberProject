package common;

import java.io.FileReader;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import step_definitions.VerifyTimesheets;

public class SomeUtils {
	
	private static final Logger Log = (Logger) LogManager.getLogger(SomeUtils.class);
	public static void loadproperties() {
		
		FileReader reader=null;
		Properties property=null;
		
		try {
			reader = new FileReader("C:\\Users\\aviba\\eclipse-workspace\\FInalCucumberPractice\\src\\test\\resources\\Config\\config.properties");
			Log.info("config property read");
		} catch (Exception e) {
			Log.error("FILE NOT FOUND");
		}
		
		property = new Properties();
		
		try {
			property.load(reader);
		} catch (Exception e) {
			Log.info("Reader Not Loaded");
		}
		
		
	 Constants.URL=	property.getProperty("URL");
	 Constants.USERNAME = property.getProperty("Username");
	 Constants.PASSWORD = property.getProperty("Password");
	 Constants.BROWSER = property.getProperty("Browser");
	 
		
		
		
		
	}

}
