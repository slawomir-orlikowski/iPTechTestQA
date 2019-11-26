package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoomBookingPage {
    private final WebDriver driver;

    public RoomBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    //WebElements
    @FindBy(id = "first_name")
    public WebElement firstNameField;

    @FindBy(id = "last_name")
    public WebElement lastNameField;

    @FindBy(xpath = "//form[contains(@name, 'bookingForm')]//*[contains(@id, 'email')]")
    public WebElement emailFormField;

    @FindBy(id = "phone_number")
    public WebElement phoneNumberField;

    @FindBy(id = "cardHolderName")
    public WebElement nameOnCardField;

    @FindBy(id = "cardNumber")
    public WebElement cardNumberField;

    @FindBy(id = "cardCVC")
    public WebElement securityCodeField;

    @FindBy(id = "completeBooking")
    public WebElement completeBookingButton;

    @FindBy(id = "header-waypoint-sticky")
    public WebElement header;

    @FindBy(xpath = "//div[contains(@class, 'navbar-phone')]")
    public WebElement headerPhoneDetails;

    @FindBy(id = "mobileMenuMain")
    public WebElement headerMenu;

    @FindBy(xpath = "//button[contains(@class, 'cc-btn cc-dismiss')]")
    public WebElement dismissCookiesButton;

    //methods
    public String getTitle() {
        return driver.getTitle();
    }

    public boolean verifyVisibility(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void navigateToBaseURL() {
        driver.get("https://www.phptravels.net/thhotels/checkout/Ambassador%20Bangkok%20Hotel");
    }

    public void fillAllTheMandatoryFields() {
        firstNameField.sendKeys("John");
        lastNameField.sendKeys("Short");
        emailFormField.sendKeys("John@Short.com");
        phoneNumberField.sendKeys("123456789");
        nameOnCardField.sendKeys("John Short");
        cardNumberField.sendKeys("1234123412341234");
        securityCodeField.sendKeys("123");
    }

    public boolean verifyFocus(WebElement element) {
        return element.equals(driver.switchTo().activeElement());
    }
}
