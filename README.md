# Selenium_Disposable_mail_java
This repository provides an automated test script using Selenium and TestNG to interact with a disposable email service ([fakemailgenerator.com](https://www.fakemailgenerator.com)), retrieve an email containing a One-Time Password (OTP), and extract the OTP for further use.
# Features
Automatically navigates to a disposable email site
- Configures a custom email address and domain
- Waits for the OTP email to arrive
- Opens and extracts the OTP from the email content
- Copies the OTP to the clipboard
- Utilizes TestNG for test structure and execution
# Technologies used
- Java 21.0.2
- Selenium
- TestNG
- Maven
- Page Object Model (POM)
- Allure
# Getting started
- Install and configure Java updated and stable version
- Install IDE (Intellij/Eclipse)
- Maven project
- Add essential dependencies to pom.xml file 
  * selenium-java
  * testng
  * allure-testing
- Configure the WebDriver:
  Update DriverSetup.java to initialize your browser (Chrome, Firefox, etc.)
- Run the test
  * Open terminal and run using - **mvn test**
  * This will open (https://www.fakemailgenerator.com)
# Project Structure
├── Pages/
│   └── DisposableMailPage.java        # Page Object Model for mail interactions
├── Testcases/
│   └── TestDisposableMail.java        # Main test class to extract OTP
├── Utilities/
│   └── DriverSetup.java               # WebDriver setup and teardown
├── pom.xml                            # Maven config with dependencies
└── README.md                          # Project documentation
# Sample Flow
- Opens fakemailgenerator.com.
- Sets a custom email like mars@jourrapide.com.
- Waits for the email to arrive.
- Clicks to open the email.
- Switches to the email iframe and reads the OTP from a specific paragraph.
- Extracts the OTP using regex and prints it.
- Copies the OTP to the clipboard for further use.
