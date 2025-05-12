package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static Utilities.DriverSetup.getDriver;

public class BasePage  {

    public WebElement getElement (By locator) {

        return getDriver().findElement(locator);
    }

    public void clickOneElement (By locator) {
        getElement(locator).click();}

    public void writeOneElement (By locator, String text) {
        getElement(locator).sendKeys(text);}

    public void loadAnWebpage (String url){

        getDriver().get(url);
    }

    public String getPageTitle (){

        return getDriver().getTitle();
    }

}