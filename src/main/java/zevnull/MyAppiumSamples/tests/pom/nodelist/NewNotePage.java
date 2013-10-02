package zevnull.MyAppiumSamples.tests.pom.nodelist;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewNotePage {

    private final WebDriver driver;

    private final WebElement noteText;

    private final WebElement saveNote;

    private final String text;


    public NewNotePage(WebDriver driver, String text) {
        this.driver = driver;
        this.noteText = driver.findElement(By.className("android.widget.EditText"));
        this.saveNote = driver.findElements(By.className("android.widget.TextView")).get(1);
        this.text = text;

    }

    public final MainPage createAndSaveNote() {

        noteText.sendKeys(this.text);
        saveNote.click();
        return new MainPage(driver);
    }


}
