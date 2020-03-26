package Pages;

import Utilities.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CalculatePage extends PageBase {

    public CalculatePage(WebDriver driver) {
        super(driver);
    }

    public void TestLogin(String username, String password) {
        clickElementByName("Maximize");
        findElementByXpatch("//*[@AutomationId='txtId']").sendKeys(username);
        findElementByXpatch("//*[@AutomationId='txtPass']").sendKeys(password);
        clickElementByLocation(402,316);
    }
    public void TestGoTable() {
        waitUntilElementIsClickableName("Genel Tablo");
      clickElementByName("Genel Tablo");
    }
}