package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryPage {

    @FindBy(xpath = "//*[@class='product_img_link']")
    public WebElement product;

    @FindBy(xpath = "//*[@class='ajax_cart_quantity unvisible']")
    public WebElement quantityInCart;

    WebDriver driver;
    Wait wait;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
}
