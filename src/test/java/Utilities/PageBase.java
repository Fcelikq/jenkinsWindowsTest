package Utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PageBase {

    protected WebDriver driver;
    WebDriverWait wait;
    protected Configuration configuration;
    protected Actions action;


    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.configuration = Configuration.getInstance();
        this.action= new Actions(driver);
    }


    protected WebElement findElementByOtomationId(String otomationId) {
        return driver.findElement(By.id(otomationId));
    }
    protected WebElement findElementByXpatch(String xpatch) {
        return driver.findElement(By.xpath(xpatch));
    }

    protected WebElement findElementByName(String name) {
        return driver.findElement(By.name(name));
    }


    protected void clickElementByOtomationId(String otomationId) {
        findElementByOtomationId(otomationId).click();
    }

    protected void clickElementByName(String name) {
        findElementByName(name).click();

    }

    protected void waitUntilElementIsClickableId(String otomationId) {
        wait.until(ExpectedConditions.elementToBeClickable(findElementByOtomationId(otomationId)));
    }
    protected void waitUntilElementIsClickableName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(findElementByName(name)));
    }


    protected void waitUntilElementIsVisibleName(String name) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name(name))));
    }

    protected void waitUntilPresenceOfElement(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
    }

    protected void hoverToElementById(String otomationId) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(otomationId)));
        Actions action = new Actions(driver);
        action.moveToElement(findElementByOtomationId(otomationId)).build().perform();
    }
    protected void hoverToElementByName(String name) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
        Actions action = new Actions(driver);
        action.moveToElement(findElementByOtomationId(name)).build().perform();
    }
    protected void clickElementByLocation(int x , int y) {
       WebElement  win = driver.findElement(By.name("Cafe XxX"));

        action.moveToElement(win,x,y).click().build().perform();
    }
    protected void clickElementByXpath(String xpath) {
         driver.findElement(By.xpath(xpath)).click();
    }




}
