package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    @FindBy(className = "login")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@title='Contact Us']")
    public WebElement contactUsButton;

    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/logo.jpg']")
    public WebElement logo;

    @FindBy(xpath = "//*[@id='search_query_top']")
    public WebElement search;

    @FindBy(xpath = "//*[@class='sf-with-ul']")
    public WebElement mainCategory;

    @FindBy(className = "product-container")
    public WebElement product;


    WebDriver driver;
    Wait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public LoginPage signin() {
        signInButton.click();
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOf(loginPage.emailInput));
        return new LoginPage(driver);
    }
}
