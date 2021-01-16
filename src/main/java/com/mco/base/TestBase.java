package com.mco.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.mco.utill.TestUtill;
import com.mco.utill.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver eventFiring;
	public static WebEventListener eventListener;
public static String conProp ="/Users/khosruzzaman/Downloads/MultiCartOnline/src/main/java/com/mco/configuration/config.properties";
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(conProp);
			prop.load(fis);
		} catch (FileNotFoundException nfe) {
			nfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","/Users/khosruzzaman/Drivers/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("ff")) {
			System.setProperty("webdriver.gecko.driver","/Users/khosruzzaman/Drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			driver = new SafariDriver();
		}
		eventFiring = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		eventFiring.register(eventListener);
		driver = eventFiring;
		
		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtill.IMPLECITELY_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
