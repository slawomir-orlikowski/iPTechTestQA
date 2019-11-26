package testcases;

import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.RoomBookingPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

/*
Test Cases in this class test mandatory field validations
 */

@ExtendWith(SeleniumExtension.class)
class RoomBookingValidationsTest {

    private RoomBookingPage roomBookingPage;

    @DriverUrl
    String url = System.getProperty("url");

    @DriverCapabilities
    Capabilities capabilities = chrome();

    @BeforeEach
    void setup(RemoteWebDriver driver) {
        //page object init
        this.roomBookingPage = PageFactory.initElements(driver, RoomBookingPage.class);

        // browser maximise
        driver.manage().window().maximize();

        // implicit wait setup
        driver.manage().timeouts().implicitlyWait(
                10, TimeUnit.SECONDS);

        //navigate to base URL
        roomBookingPage.navigateToBaseURL();

        //close cookies info
        roomBookingPage.dismissCookiesButton.click();

    }

    /*
    Verification if the mandatory fields are required to proceed with the booking:
    - first name, last name, email, phone, name on card, card number, security code
     */
    @Test
    @DisplayName("Verify the First Name is mandatory")
    void firstNameIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.firstNameField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.firstNameField), "The Web page didn't move the focus to the First Name field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    @Test
    @DisplayName("Verify the Last Name is mandatory")
    void lastNameIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.lastNameField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.lastNameField), "The Web page didn't move the focus to the Last Name field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    @Test
    @DisplayName("Verify the Email is mandatory")
    void emailIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.emailFormField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.emailFormField), "The Web page didn't move the focus to the Email field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    @Test
    @DisplayName("Verify the Phone is mandatory")
    void phoneIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.phoneNumberField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.phoneNumberField), "The Web page didn't move the focus to the Phone field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    @Test
    @DisplayName("Verify the Name on card field is mandatory")
    void nameOnCardIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.nameOnCardField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.nameOnCardField), "The Web page didn't move the focus to the Name on card field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    @Test
    @DisplayName("Verify the Card Number is mandatory")
    void cardNumberIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.cardNumberField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.cardNumberField), "The Web page didn't move the focus to the Card Number field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    @Test
    @DisplayName("Verify the Security Code is mandatory")
    void securityCodeIsMandatory() {
        roomBookingPage.fillAllTheMandatoryFields();
        roomBookingPage.securityCodeField.clear();
        roomBookingPage.completeBookingButton.click();
        assertTrue(roomBookingPage.verifyFocus(roomBookingPage.securityCodeField), "The Web page didn't move the focus to the Security Code field");
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }
}
