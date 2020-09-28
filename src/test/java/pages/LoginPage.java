package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class LoginPage {

    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/logo.jpg']")
    public WebElement logo;

    @FindBy(id = "email")
    public WebElement loginInput;

    @FindBy(id = "passwd")
    public WebElement passwordInput;

    @FindBy(name = "SubmitLogin")
    public WebElement loginInButton;

    @FindBy(xpath = "//*[@id='email_create']")
    public WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccountButton;


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String randomMailGenerator() {
        Random r = new Random();
        return "bombelek" + r.nextInt(10000) + "@grzybobranie.eu";
    }

    public void login(String email, String password) {
        loginInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginInButton.click();

    }

}
