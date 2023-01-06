package scootertests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseOnFirefox extends Constants {
    WebDriver driverFirefox;
    final String PATH_DRIVERS = "\\drivers\\geckodriver.exe";
    final String TYPE_DRIVER = "webdriver.gecko.driver";

    @Before
    public void setUp(){
        System.setProperty(TYPE_DRIVER,System.getProperty("user.dir")+PATH_DRIVERS);
        driverFirefox = new FirefoxDriver();
    }
    @After
    public void tearDown(){
        driverFirefox.quit();
    }
}
