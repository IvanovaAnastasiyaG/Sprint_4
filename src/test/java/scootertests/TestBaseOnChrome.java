package scootertests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBaseOnChrome extends Constants {
    WebDriver driverChrome;
    final String PATH_DRIVERS = "\\drivers\\chromedriver.exe";
    final String TYPE_DRIVER = "webdriver.chrome.driver";

    @Before
    public void setUp(){
        System.setProperty(TYPE_DRIVER,System.getProperty("user.dir")+PATH_DRIVERS);
        driverChrome = new ChromeDriver();
    }
    @After
    public void tearDown(){
        driverChrome.quit();
    }

}
