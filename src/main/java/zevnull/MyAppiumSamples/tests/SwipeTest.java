package zevnull.MyAppiumSamples.tests;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipeTest {

    private Logger logger = Logger.getLogger(SwipeTest.class);

    private WebDriver driver;


    @BeforeMethod
    public void setUp() throws Exception {

        logger.info("setUp - started.");

        File app = new File("aut/ListView.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.PLATFORM, "Windows");
        capabilities.setCapability(CapabilityType.VERSION, "4.2");
        capabilities.setCapability("app-package", "com.example.listview");
        capabilities.setCapability("app-activity", ".MainActivity");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        logger.info("setUp - finished.");

    }

    @AfterMethod
    public void tearDown() throws Exception {
        logger.info("Quit application.");
        driver.quit();
    }

    @Test
    public void swipeTest() {

        HashMap<String, Integer> keycode = new HashMap<String, Integer>();
        keycode.put("keycode", 82);
        ((JavascriptExecutor)driver).executeScript("mobile: keyevent", keycode);

        System.out.println("@@@@@@@@@@@@@@@@@@");


        logger.info("3: " + driver.findElements(By.className("android.widget.TextView")).get(3));
        System.out.println("Before swipe: " + driver.findElements(By.className("android.widget.TextView")).get(3).getText());


        WebElement end = driver.findElements(By.className("android.widget.TextView")).get(10);
        logger.info("10 : " + end.getLocation().getX() + "," + end.getLocation().getY());

        WebElement start = driver.findElements(By.className("android.widget.TextView")).get(9);
        logger.info("9 : " + start.getLocation().getX() + "," + start.getLocation().getY());

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            HashMap<String, Integer> swipeObject = new HashMap<String, Integer>();
            swipeObject.put("startX", 10);
            swipeObject.put("startY", end.getLocation().getY());
            swipeObject.put("endX", 10);
            swipeObject.put("endY", start.getLocation().getY());
            swipeObject.put("duration", 1);
            js.executeScript("mobile: swipe", swipeObject);
        } catch (Exception e) {

        }
        System.out.println("After swipe: " + driver.findElements(By.className("android.widget.TextView")).get(3).getText());

    }
}
