import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectHomework {

    private ChromeDriver driver;
    private WebDriverWait wait;


    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://automationpractice.com/");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    private void login(String email, String password) {
        LoginPage loginPage = new MainPage(driver).signin();
        loginPage.login(email, password);
    }

    //1
    @Test
    void loginWithoutEmail() {
        login("", "1qaz");
        List<WebElement> loginErrors = driver.findElements(By.xpath("//div//*[contains(text(), \"An email address required.\")]"));
        Assertions.assertEquals(1, loginErrors.size());
    }

    //2
    @Test
    void loginWithoutCredentials() {
        login("", "");
        List<WebElement> loginErrors = driver.findElements(By.xpath("//div//*[contains(text(), \"An email address required.\")]"));
        Assertions.assertEquals(1, loginErrors.size());
    }

    //3
    @Test
    void logoAndSearchDisplayedOnMainPage() {
        MainPage mainPage = new MainPage(driver);
        Boolean displayLogo = mainPage.logo.isDisplayed();
        Boolean displaySearch = mainPage.search.isDisplayed();
        assertTrue(displayLogo && displaySearch);
    }

    //4 refactor login & apply (applied)
    //5
    @Test
    void goToContactPageFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.contactUsButton.click();
        ContactPage contactPage = new ContactPage(driver);
        wait.until(ExpectedConditions.visibilityOf(contactPage.navigationBreadcrumbs));
        String contactHeader = contactPage.navigationBreadcrumbs.getText();
        Assertions.assertEquals("Contact", contactHeader);
    }

    //6
    @Test
    void goToMainPageFromLoginPage() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logo.click();
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("My Store", pageTitle);
    }

    //7
    @Test
    void addProductToCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.mainCategory.click();
        CategoryPage categoryPage = new CategoryPage(driver);
        wait.until(ExpectedConditions.visibilityOf(categoryPage.product));
        categoryPage.product.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
        ProductQuickViewIframe productQuickViewIframe = new ProductQuickViewIframe(driver);
        productQuickViewIframe.addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(productQuickViewIframe.closeWindowButton));
        productQuickViewIframe.closeWindowButton.click();
        int quantityInCart = Integer.parseInt(categoryPage.quantityInCart.getText());
        assertEquals(1, quantityInCart);
    }

    //8
    @Test
    void addAndDeleteProductFromCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.product.click();
        ProductPage productPage = new ProductPage(driver);
        wait.until(ExpectedConditions.visibilityOf(productPage.addToCartButton));
        productPage.addToCartButton.click();
        AddedToCartPopup addedToCartPopup = new AddedToCartPopup(driver);
        wait.until(ExpectedConditions.visibilityOf(addedToCartPopup.checkoutButton));
        addedToCartPopup.checkoutButton.click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        int quantityInCart = Integer.parseInt(checkoutPage.quantityInCart.getText());
        assertEquals(1, quantityInCart);
        checkoutPage.deleteIcon.click();
        wait.until(ExpectedConditions.visibilityOf(checkoutPage.error));
        boolean displayAlertText = checkoutPage.error.isDisplayed();
        assertTrue(displayAlertText);


    }

    //9
    @Test
    void loginWithCorrectCredentials() {
        login("test@softie.pl", "1qaz!QAZ");
        String pageTitle = driver.getTitle();
        Assertions.assertEquals("My account - My Store", pageTitle);
    }

    //10
    @Test
    void checkAccountCreation() {
        LoginPage loginPage = new MainPage(driver).signin();
        loginPage.emailInput.sendKeys(loginPage.randomMailGenerator());
        loginPage.createAccountButton.click();
        AccountCreation accountCreation = new AccountCreation(driver);
        wait.until(ExpectedConditions.visibilityOf(accountCreation.firstName));
        accountCreation.createAccountFillAll("Jan", "Kowalski", "BombelekCorp", "qwerty21", "Monroe", "Drive",
                "Santa Clara", "I want a pony", "ponytail@rainbow.nn");
        Assertions.assertEquals("My account - My Store", driver.getTitle());


    }


}