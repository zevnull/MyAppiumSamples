package zevnull.MyAppiumSamples.tests;


import org.apache.log4j.Logger;
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
import zevnull.MyAppiumSamples.tests.pom.nodelist.MainPage;

import java.io.File;
import java.net.URL;
import java.util.Random;

public class NodeListTest {

    private WebDriver driver;


    @BeforeMethod
    public void setUp() throws Exception {

        File app = new File("aut/NodeList.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(CapabilityType.PLATFORM, "Windows");
        capabilities.setCapability(CapabilityType.VERSION, "4.2");
        capabilities.setCapability("app-package", "com.example.android.notepad");
        capabilities.setCapability("app-activity", ".NotesList");
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void addNewNoteTest() {

        String noteText = "Note" + new Random().nextInt(1000);
        MainPage mainPage = new MainPage(driver);

        Assert.assertTrue(mainPage.createNewNote(noteText).getNotestList().contains(noteText), "New note not present");

    }
}
