package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductQuickViewIframe {

    @FindBy(id = "add_to_cart")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@class='cross']")
    public WebElement closeWindowButton;

    WebDriver driver;
    Wait wait;

    public ProductQuickViewIframe(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
