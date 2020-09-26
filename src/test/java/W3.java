import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class W3 {
    @Test
    void checkRowCount() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        Thread.sleep(5000);
        WebElement acceptCookies = driver.findElement(By.id("accept-choices"));
        acceptCookies.click();
        List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        Assertions.assertEquals(7, rowList.size());
        driver.quit();
    }

    @Test
    void checkFirstRowColumnCount() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        Thread.sleep(5000);
        WebElement acceptCookies = driver.findElement(By.id("accept-choices"));
        acceptCookies.click();
        List<WebElement> columnSizeList = driver.findElements(By.xpath("//table[@id='customers']//th"));
        Assertions.assertEquals(3, columnSizeList.size());
        driver.quit();
    }

    @Test
    void checkValuesInTable() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        Thread.sleep(5000);
        WebElement acceptCookies = driver.findElement(By.id("accept-choices"));
        acceptCookies.click();
        String firstCheck = driver.findElement(By.xpath("//table[@id='customers']//tr[7]/td[2]")).getText();
        String secondCheck = driver.findElement(By.xpath("//table[@id='customers']//td[text()='Centro comercial Moctezuma']/../td[3]")).getText();
        String thirdCheck = driver.findElement(By.xpath("//table[@id='customers']//td[text()='Laughing Bacchus Winecellars']/../td[3]")).getText();
        Assertions.assertEquals("Giovanni Rovelli", firstCheck);
        Assertions.assertEquals("Mexico", secondCheck);
        Assertions.assertEquals("Canada", thirdCheck);
        driver.quit();
    }
}

