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
import java.util.concurrent.TimeUnit;

public class Waits {
    @Test
    void checkhelloWorld() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        List<WebElement> helloWorldElements = driver.findElements(By.xpath("//*[text()='Hello World!']"));
        Assertions.assertEquals(1, helloWorldElements.size());

    }

    @Test
    void checkhelloWorld2() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement button = driver.findElement(By.xpath("//button"));
        button.click();
        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Hello World!']")));
        List<WebElement> helloWorldElements = driver.findElements(By.xpath("//*[text()='Hello World!']"));
        Assertions.assertEquals(1, helloWorldElements.size());

    }

    
}