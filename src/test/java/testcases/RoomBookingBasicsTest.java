package testcases;

import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Capabilities;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.RoomBookingPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.remote.DesiredCapabilities.chrome;

/*
Test Cases in this class test the bare basics of the hotel booking page:
- page title (AUTOMATED)
- desired WebElements presence and visibility (fields, drop-downs, buttons etc)
- correctness of the drop-downs contents
- Web page header visibility and contents (AUTOMATED)
- Web page footer visibility
 */

@ExtendWith(SeleniumExtension.class)
class RoomBookingBasicsTest {

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
    The Room Booking page title.
    Expected: "Hotels Booking Checkout"
     */
    @Test
    @DisplayName("Verify the Room Booking page title")
    void webPageTitle() {
        assertEquals("Hotels Booking Checkout", roomBookingPage.getTitle());
    }

    /*
    The Room Booking page header presence and contents.
    Expected: Header is visible and contains:
    - telephone details
    - menu/navigation elements
    */
    @Test
    @DisplayName("Verify the Room Booking page header presence and it's core contents")
    void webPageHeader() {
        assertTrue(roomBookingPage.verifyVisibility(roomBookingPage.header), "The Room Booking page header is not visible.");
        assertTrue(roomBookingPage.verifyVisibility(roomBookingPage.headerPhoneDetails), "Phone details located in the Room Booking page header are not visible.");
        assertTrue(roomBookingPage.headerPhoneDetails.getText().contains("Call Now : +1-234-56789"), "Phone details located in the Room Booking page header are different than \"Call Now : +1-234-56789\"");
        assertTrue(roomBookingPage.verifyVisibility(roomBookingPage.headerMenu), "The Room Booking page header menu is not visible");
    }
}