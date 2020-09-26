import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AutomationPractice2 {

    @Test
    void loginWithCorrectCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='email']")));

        WebElement loginInput = driver.findElement(By.xpath("//div/input[@id='email']"));
        loginInput.sendKeys("test@softie.pl");
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("1qaz!QAZ");
        WebElement loginInButton = driver.findElement(By.name("SubmitLogin"));
        loginInButton.click();

        Wait wait2 = new WebDriverWait(driver, 5000);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='email']")));

        List<WebElement> loginButtonsList = driver.findElements(By.xpath("//div/input[@id='email']"));
        Assertions.assertEquals(0, loginButtonsList.size());
        Assertions.assertTrue(loginButtonsList.size() == 0);
        String headingText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertEquals("MY ACCOUNT", headingText);

    }

    @Test
    void loginWithIncorrectCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        Thread.sleep(5000);
        WebElement loginInput = driver.findElement(By.xpath("//div/input[@id='email']"));
        loginInput.sendKeys("test@softie.pl");
        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("11qaz!QAZ");
        WebElement loginInButton = driver.findElement(By.name("SubmitLogin"));
        loginInButton.click();
        Thread.sleep(5000);
        List<WebElement> loginButtonsList = driver.findElements(By.xpath("//div/input[@id='email']"));
        Assertions.assertEquals(1, loginButtonsList.size());
        Assertions.assertTrue(loginButtonsList.size() != 0);
        String headingText = driver.findElement(By.className("page-heading")).getText();
        Assertions.assertEquals("AUTHENTICATION", headingText);

    }
}
