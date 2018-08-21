package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.Before;

public class GlobalWebDriver {
	private static boolean initialized = false;
	private static WebDriver driver;
	
	private static Thread CLOSE_DRIVER = new Thread() {
        @Override
        public void run() {
            driver.close();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_DRIVER);
    }
	
	@Before
	public void setUp() {
		if (!initialized) {
			String hubURL = "http://100.116.0.4:4444/wd/hub";
	        ChromeOptions options = new ChromeOptions();
	        try {
	        	driver = new RemoteWebDriver(new URL(hubURL), options);
	        } catch (MalformedURLException e) {
	        	e.printStackTrace();
	        }
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			initialized = true;
		}
	}
	

	public WebDriver getDriver() {
		return driver;
	}
}
