package Testcases;

//import Pages.EmailReader;
import Pages.DisposableMailPage;
import Utilities.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestDisposableMail extends DriverSetup {

    DisposableMailPage disposableMailPage = new DisposableMailPage();

    @Test

    public void getOtpFromDisposableMail() throws InterruptedException {

        getDriver().get("https://www.fakemailgenerator.com");
        Thread.sleep(3000);

        //Get email body
        disposableMailPage.getElement(disposableMailPage.disposable_email_input_field).clear();
        disposableMailPage.getElement(disposableMailPage.disposable_email_input_field).sendKeys("mars");
        disposableMailPage.getElement(disposableMailPage.disposable_email_domain_selector).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        disposableMailPage.getElement(disposableMailPage.jourrapide_dropdown).click();
        Thread.sleep(3000);
        disposableMailPage.getElement(disposableMailPage.copy_btn_de).click();
        Thread.sleep(60000);
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(130));
//        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'unselected')]")));
//        emailElement.click();

        disposableMailPage.getElement(disposableMailPage.first_disposable_email_btn).click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Actions actions = new Actions(getDriver());
        actions.scrollByAmount(0,800).build().perform();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        WebElement lineToScroll = disposableMailPage.getElement(disposableMailPage.line_to_scroll);
//        actions.moveToElement(lineToScroll).build().perform();
        String emailBody = disposableMailPage.getElement(disposableMailPage.disposable_email_body).getText();
        System.out.println("Email Body : \n " + emailBody);

        getDriver().switchTo().frame("emailFrame");
        WebElement otpElement = getDriver().findElement(By.xpath("(//div[@style='width:50%;background-color:#FFFFFF;margin:auto;padding:20px;']/p)[4]"));


        //List <WebElement> fields = getDriver().findElements(By.tagName("p"));
        //WebElement seventeenth_field = fields.get(0);
        String otpNumber = (otpElement).getText();
        System.out.println("OTP is : " + otpNumber);
        // Extract the 6-digit OTP using regex
        DisposableMailPage.EmailReader emailReader = new DisposableMailPage.EmailReader();
        String otp = emailReader.extractOTP(emailBody);
        System.out.println("Email Body Length: " + emailBody.length());

        if (otp != null) {
            System.out.println("Extracted 6-Digit OTP: " + otp);
        } else {
            System.out.println("No 6-digit OTP found in the email body.");
        }

        //copy OTP to clipboard
        StringSelection selection = new StringSelection(otpNumber);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

//        actions.scrollByAmount(0,-800).build().perform();
//        Thread.sleep(15000);
//        actions.doubleClick(disposableMailPage.getElement(disposableMailPage.search_input_field_fp)).build().perform();
//        Thread.sleep(2000);
//        disposableMailPage.getElement(disposableMailPage.search_input_field_fp).sendKeys(otpNumber);
//        Thread.sleep(2000);
//        actions.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
//        Thread.sleep(2000);
//        actions.keyDown(Keys.CONTROL).sendKeys("x").build().perform();
//        Thread.sleep(2000);

        List<String> windowHandles = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(windowHandles.get(0));




//        // Regex for a 6-digit number
//        Pattern pattern = Pattern.compile("\\b\\d{6}\\b"); // Matches exactly 6 digits
//        Matcher matcher = pattern.matcher(emailBody);
//
//        if (matcher.find()) {
//            return matcher.group();
//        }
//
//        return emailBody;
    }
    public String otpNumber;  // Global variable to store OTP

    public void extractAndStoreOTP() {
        WebElement otpElement = getDriver().findElement(By.xpath("(//div[@style='width:50%;background-color:#FFFFFF;margin:auto;padding:20px;']/p)[4]"));

        otpNumber = otpElement.getText();  // Store in global variable

        System.out.println("Stored OTP: " + otpNumber);
    }

}




