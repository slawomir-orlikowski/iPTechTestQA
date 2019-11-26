Technical test for QA

Part 1:
The test cases can be found in the "TestCasesList_BookingPage.xlsx" spreadsheet. Every automated test is added to the "Automated Test ID" column which provides the mapping between the spreadsheet and the code in Java.

Part 2:
The testing framework in this repo is built using Java, Selenium, Junit5 and Maven as a build tool. I have also added the Selenium-Jupiter which uses the dependency injection feature of the extension model of JUnit 5 to inject WebDriver objects within @Test methods. It also manages the binaries required by the WebDriver internally. The project utilizes Page Factory (an inbuilt Page Object Model concept for Selenium) as a design pattern.

Running the tests:
The project is setup to be used with Selenium Grid (just pass the Grid url in the command line when running the tests) for example: mvn clean test -Durl="your grid url here"

Thanks!


	
