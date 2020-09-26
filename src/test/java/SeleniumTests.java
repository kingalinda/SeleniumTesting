import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {
    static WebDriver driver;

    @BeforeAll
    static void prepareBrowser() {
        driver = new ChromeDriver();
        driver.get("https://wikipedia.org/");
    }

    @AfterAll
    static void closeBrowser() {
        driver.quit();
    }

    @Test
    void wikipediaTitleCheck() {
        String title = driver.getTitle();
        Assertions.assertEquals("Wikipedia", title);
    }

    @Test
    void wikipediaContentSourceCheck() {

        driver.getPageSource();
        Assertions.assertTrue(driver.getPageSource().contains("js-link-box-it"));

    }

    @Test
    void automationPracticeContactTest() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        WebElement contactUsButton = driver.findElement(By.linkText("Contact us"));
        contactUsButton.click();
    }


    @Test
    void StactOvrflowFind() {
        driver = new ChromeDriver();
        driver.get("https://stackoverflow.com/");
        driver.findElement(By.className("ps-relative"));
        driver.findElement(By.linkText("For developers"));
        driver.findElement(By.className("iconClear"));

    }


}