STC TV SUBSCRIPTION TEST AUTOMATION FRAMEWORK
=============================================

DESCRIPTION:
------------
This is an automated test framework designed to validate the subscription 
packages on the STC TV website (https://subscribe.stctv.com/). The framework 
is built using Java, Selenium WebDriver, TestNG, and Extent Reports.


FEATURES:
---------
- Automates the validation of subscription packages for Saudi Arabia, Bahrain, and Kuwait.
- Verifies subscription package details including:
    - Package Type (Basic, Premium)
    - Price (15, 3, 2.5)
    - Currency (SAR, BHD, KWD)
- Uses TestNG Data Provider for dynamic testing.
- Implements the Page Object Model (POM) for better maintainability.
- Generates detailed Extent Reports with test results.
- Automatically handles WebDriver setup using WebDriverManager.


TECHNOLOGIES USED:
------------------
- Java 17 (Ensure JDK 17 is installed)
- Selenium WebDriver 4.29.0
- TestNG 7.6.0
- Extent Reports 5.1.1
- Maven (for dependency management)
- WebDriverManager 5.9.3 (for automatic ChromeDriver handling)


PROJECT STRUCTURE:
------------------
TestCrew_CodingAssignment/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/                --> Page Object Model (POM) classes
│   │   │   │   ├── SubscriptionPage.java
│   │   │   ├── utils/                 --> Utility classes
│   │   │   │   ├── WebDriverFactory.java
│   │   │   │   ├── ExtentReportManager.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/                 --> Test classes
│   │   │   │   ├── BaseTest.java
│   │   │   │   ├── SubscriptionTest.java
│   │   │   │   ├── SubscriptionTest_Ar.java
│   ├── resources/
│   │   ├── config.properties          --> Configuration file
├── reports/                           --> Extent Reports output folder
├── pom.xml                             --> Maven dependencies
├── testng.xml                          --> TestNG test execution configuration
├── README.txt                          --> Project documentation


INSTALLATION & SETUP:
---------------------
1. Ensure you have Java 17 installed. Check by running:
   java -version

2. Ensure Maven is installed. Check by running:
   mvn -version

3. Clone this repository:
   git clone https://github.com/Hammad1144/TestCrew_CodingAssignment.git
   cd TestCrew_CodingAssignment


RUNNING THE TESTS:
------------------
1. Run the tests using Maven:
   mvn clean test


TEST REPORTS:
-------------
1. Extent Reports (Detailed Report)
   - After test execution, an interactive HTML report is generated at:
     reports/ExtentReport_<timestamp>.html
   - Open the file in a browser to view the results.