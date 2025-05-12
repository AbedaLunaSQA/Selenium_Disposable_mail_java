package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisposableMailPage extends BasePage {

    public String disposable_mail_url = "https://www.fakemailgenerator.com/inbox/jourrapide.com/mars/";

    public By disposable_email_input_field = By.xpath("//input[@id='home-email']");

    public By disposable_email_domain_selector = By.xpath("//span[@id='domain']");

    public By jourrapide_dropdown = By.xpath("//a[normalize-space()='@jourrapide.com']");

    public By first_disposable_email_btn = By.xpath("//li[1]//a[1]//div[1]//div[2]//p[1]");


    //if you change email then you also have to change this xpath
    public By email_TO_text_field = By.xpath("//dd[normalize-space()='mars@jourrapide.com']");

    public By copy_btn_de = By.xpath("//button[@id='copy-button']");

    public By search_input_field_fp = By.xpath("//*[@id=\"home-email\"]");


    //if anytime fanfare email changes, then you have to change this xpath also
    public By email_FROM_text_field = By.xpath("//dd[normalize-space()='Fanfare <tech@fanfare.com.bd>']");

    public By disposable_email_body = By.xpath("//iframe[@id='emailFrame']");

    public By line_to_scroll = By.xpath("//h5[contains(text(),\"Please update your profile if you haven't complete\")]");

    public By otp_field = By.tagName("p");


    public static class EmailReader {

        public static String extractOTP(String body) {
            // Regex for a 6-digit number
            Pattern pattern = Pattern.compile("\\b\\d{6}\\b"); // Matches exactly 6 digits
            Matcher matcher = pattern.matcher(body);

            if (matcher.find()) {
                return matcher.group();
            }
            return body;
        }
    }
}