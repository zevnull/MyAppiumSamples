package zevnull.MyAppiumSamples.tests.pom.nodelist;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    @FindBy(className = "android.widget.TextView")
    public WebElement newNotes;

//    final WebElement newNotes;

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        //newNotes = driver.findElements(By.className("android.widget.TextView")).get(1);
        PageFactory.initElements(driver, this);
    }

    public MainPage createNewNote(String text) {
        newNotes.click();
        return new NewNotePage(driver, text).createAndSaveNote();
    }

    public List<String> getNotestList() {
        final List<WebElement> notes = driver.findElements(By.className("android.widget.TextView"));
        List<String> result = new ArrayList<String>();

        for (WebElement var : notes) {
            result.add(var.getText());
        }

        return result;
    }
}
