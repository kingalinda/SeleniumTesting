package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class AccountCreation {
    @FindBy(name = "id_gender")
    List<WebElement> genderRadio;

    @FindBy(id = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "customer_lastname")
    public WebElement lastName;

    @FindBy(id = "company")
    public WebElement companyName;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(id = "days")
    public WebElement birthDay;

    @FindBy(id = "months")
    public WebElement birthMonth;

    @FindBy(id = "years")
    public WebElement birthYear;

    @FindBy(id = "newsletter")
    public WebElement newsletterCheckBox;

    @FindBy(id = "optin")
    public WebElement specialOffersCheckBox;

    @FindBy(id = "address1")
    public WebElement addressLine1;

    @FindBy(id = "address2")
    public WebElement addressLine2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "id_state")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement postcode;

    @FindBy(id = "id_country")
    public WebElement country;

    @FindBy(id = "other")
    public WebElement additionalInfoTextBox;

    @FindBy(id = "phone")
    public WebElement homePhone;

    @FindBy(id = "phone_mobile")
    public WebElement mobilePhone;

    @FindBy(id = "alias")
    public WebElement emailAlias;

    @FindBy(id = "submitAccount")
    public WebElement submitButton;


    public void createAccountFillAll(String firstName, String lastName, String companyName, String password, String address1, String address2,
                                     String city, String additionalInfo, String aliasEmail) {

        Random random = new Random();
        genderRadio.get(random.nextInt(genderRadio.size())).click();


        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.companyName.sendKeys(companyName);
        this.password.sendKeys(password);

        Select monthSelect = new Select(birthMonth);
        int monthIndex = new Random().nextInt(12) + 1;
        monthSelect.selectByIndex(monthIndex);

        Select yearSelect = new Select(birthYear);
        int yearSize = yearSelect.getOptions().size();
        yearSelect.selectByIndex(new Random().nextInt(yearSize - 1) + 1);

        selectProperDayInMonth(monthIndex);

        //Select daySelect = new Select(birthDay);
        //daySelect.selectByValue(String.valueOf(new Random().nextInt(31) + 1));


        newsletterCheckBox.click();

        specialOffersCheckBox.click();

        addressLine1.sendKeys(address1);

        addressLine2.sendKeys(address2);

        this.city.sendKeys(city);


        Select stateSelect = new Select(state);
        int stateSize = stateSelect.getOptions().size();
        stateSelect.selectByIndex(new Random().nextInt(stateSize - 1) + 1);

        //5digits
        Random r = new Random();
        int randomPostCode = ((r.nextInt(9) + 1) * 10000 + r.nextInt(10000));
        postcode.sendKeys(String.valueOf(randomPostCode));

        Select countrySelect = new Select(country);
        //int countrySize = countrySelect.getOptions().size();
        countrySelect.selectByIndex(1);

        additionalInfoTextBox.sendKeys(additionalInfo);


        int randomHomePhone = ((1 + r.nextInt(10)) * 100000000 + r.nextInt(100000000));
        homePhone.sendKeys(String.valueOf(randomHomePhone));

        int randomMobilePhone = ((1 + r.nextInt(10)) * 100000000 + r.nextInt(100000000));
        mobilePhone.sendKeys(String.valueOf(randomMobilePhone));

        emailAlias.sendKeys(aliasEmail);

        submitButton.click();

    }

    WebDriver driver;
    Wait wait;

    public AccountCreation(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void selectProperDayInMonth(int birthMonth) {
        Select select = new Select(this.birthYear);
        int yearNumber = Integer.parseInt(select.getFirstSelectedOption().getText().trim());
        Select daySelect = new Select(this.birthDay);
        if (birthMonth == 2 && (yearNumber % 4 == 0 && (yearNumber % 100 != 0 || yearNumber % 400 == 0))) {
            daySelect.selectByValue(String.valueOf(new Random().nextInt(29) + 1));
            return;
        }
        if (birthMonth == 2) {
            daySelect.selectByValue(String.valueOf(new Random().nextInt(28) + 1));
            return;
        }
        if (birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11) {
            daySelect.selectByValue(String.valueOf(new Random().nextInt(30) + 1));
        } else {
            daySelect.selectByValue(String.valueOf(new Random().nextInt(31) + 1));
        }


    }
}
