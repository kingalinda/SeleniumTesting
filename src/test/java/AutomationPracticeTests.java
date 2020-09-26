import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutomationPracticeTests {


    @Test
    void somethingFind() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        List<WebElement> elementsFound = driver.findElements(By.className("col-sm-4"));
        System.out.println(elementsFound.size());
        driver.close();
    }

    @Test
    void picturesFind() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        List<WebElement> picturesFound = driver.findElements(By.tagName("img"));
        System.out.println(picturesFound.size());
        driver.close();
    }

}