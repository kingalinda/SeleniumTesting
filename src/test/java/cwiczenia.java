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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class cwiczenia {
    //1
    @Test
    void loginWithoutLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='email']")));

        WebElement passwordInput = driver.findElement(By.id("passwd"));
        passwordInput.sendKeys("1qaz!QAZ");
        WebElement loginInButton = driver.findElement(By.name("SubmitLogin"));
        loginInButton.click();

        List<WebElement> loginErrors = driver.findElements(By.xpath("//div//*[contains(text(), \"An email address required.\")]"));
        Assertions.assertEquals(1, loginErrors.size());

    }

    //2
    @Test
    void loginWithoutCredentials() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement signInButton = driver.findElement(By.className("login"));
        signInButton.click();

        Wait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='email']")));

        WebElement loginInButton = driver.findElement(By.name("SubmitLogin"));
        loginInButton.click();

        List<WebElement> loginErrors = driver.findElements(By.xpath("//div//*[contains(text(), \"An email address required.\")]"));
        Assertions.assertEquals(1, loginErrors.size());

    }

    //3
    @Test
    void logoAndSearchDisplayedOnMainPage() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        Boolean displayLogo = driver.findElement(By.xpath("//img[@src='http://automationpractice.com/img/logo.jpg']")).isDisplayed();
        Boolean displaySearch = driver.findElement(By.xpath("//*[@id='search_query_top']")).isDisplayed();
        assertTrue(displayLogo);
        assertTrue(displaySearch);
        driver.quit();
    }

    //4 refacor login & apply
    //5
    @Test
    void goToContactPageFromMainPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement contactUsButton = driver.findElement(By.xpath("//*[@title='Contact Us']"));
        contactUsButton.click();
        Thread.sleep(5000);
        String contactHeader = driver.findElement(By.className("navigation_page")).getText();
        Assertions.assertEquals("Contact", contactHeader);
        driver.quit();
    }

    //6
    @Test
    void goToMainPageFromAuthenticationPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        WebElement logo = driver.findElement(By.xpath("//*[@class='logo img-responsive']"));
        logo.click();
        Thread.sleep(5000);
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("My Store", pageTitle);
        driver.quit();
    }

    //7
    @Test
    void addProductToCartFromMainPage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
        WebElement category = driver.findElement(By.xpath("//*[@class='sf-with-ul']"));
        category.click();
        Thread.sleep(5000);
        WebElement product = driver.findElement(By.xpath("//*[@class='product_img_link']"));
        product.click();
        Thread.sleep(5000);
        //WebElement addToCartButton = driver.findElement(By.xpath("//*[@name='Submit']"));
        WebElement addToCartButton = driver.findElement(By.name("Submit"));
        addToCartButton.click();
        Thread.sleep(5000);
        WebElement closeWindowButton = driver.findElement(By.xpath("//*[@class='fancybox-item fancybox-close']"));
        closeWindowButton.click();
        Thread.sleep(5000);
        int quantityInCart = Integer.parseInt(driver.findElement(By.xpath("//*[@class='ajax_cart_quantity unvisible']")).getText());
        assertEquals(1, quantityInCart);







        /*Actions hover = new Actions(driver);

        WebElement product = driver.findElement(By.xpath("//*[@class='tab-content']"));
        hover.moveToElement(product);
        hover.build();
        hover.perform();

        WebElement addToCartButton = driver.findElement(By.xpath("//*[@data-id-product=6]/span"));
        addToCartButton.click();
        WebElement checkoutButton = driver.findElement(By.xpath("//*[@title='Proceed to checkout']"));
        Assertions.assertTrue(checkoutButton.isDisplayed());*/

    }
}