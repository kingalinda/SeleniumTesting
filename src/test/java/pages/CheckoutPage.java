package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    @FindBy(xpath = "//*[@class='ajax_cart_quantity']")
    public WebElement quantityInCart;

    @FindBy(className = "cart_quantity_delete")
    public WebElement deleteIcon;

    @FindBy(xpath = "//*[@class='alert alert-warning']")
    public WebElement error;

    WebDriver driver;
    Wait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
