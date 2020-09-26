import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class AutomationPrac {

    @Test
    void printMonthOptions() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        Thread.sleep(5000);
        WebElement loginInput = driver.findElement(By.xpath("//div/input[@id='email_create']"));
        loginInput.sendKeys("aa@bb.pl");
        WebElement newAccountButton = driver.findElement(By.id("SubmitCreate"));
        newAccountButton.click();
        Thread.sleep(5000);
        Select months = new Select(driver.findElement(By.id("months")));
        List<WebElement> listOfOptions = months.getOptions();
        for (int i = 0; i < listOfOptions.size(); i++) {
            System.out.println(listOfOptions.get(i).getText());
        }
        driver.quit();

    }

    @Test
    void checkAccountCreationSuccess() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();
        Thread.sleep(5000);
        WebElement loginInput = driver.findElement(By.xpath("//div/input[@id='email_create']"));
        loginInput.sendKeys("randomewowy1@mail.com");
        WebElement newAccountButton = driver.findElement(By.id("SubmitCreate"));
        newAccountButton.click();
        Thread.sleep(5000);
        List<WebElement> genderRadio = driver.findElements(By.name("id_gender"));
        Random random = new Random();
        int index = random.nextInt(genderRadio.size());
        genderRadio.get(index).click();
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        firstName.sendKeys("Grażynka");
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        lastName.sendKeys("Kowalska");
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("qwerty2!");

        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByIndex(1);
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByIndex(1);
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByIndex(1);


        WebElement address = driver.findElement(By.id("address1"));
        address.sendKeys("Moon");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Denver");

        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex(1);

        WebElement postalCode = driver.findElement(By.id("postcode"));
        postalCode.sendKeys("21333");

        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByIndex(1);

        WebElement mobilePhone = driver.findElement(By.id("phone_mobile"));
        mobilePhone.sendKeys("9999999999");
        WebElement alias = driver.findElement(By.id("alias"));
        alias.sendKeys("jdhjfhd@jdj.pl");
        WebElement submitButton = driver.findElement(By.id("submitAccount"));
        submitButton.click();
        Thread.sleep(5000);

        String headingText = driver.findElement(By.xpath("//*[@class=\"page-heading\"]")).getText();
        Assertions.assertEquals("MY ACCOUNT", headingText);

        driver.quit();


    }
}