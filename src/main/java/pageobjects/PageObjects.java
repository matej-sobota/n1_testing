package pageobjects;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObjects {
    private WebDriver driver;

    public PageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnElement(WebElement element) {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (StaleElementReferenceException ex) {
            System.out.println("Catched stale element reference");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
    }

    public void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public String getElementText(WebElement element) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return element.getText().trim();
    }

    public void clearInputElement(WebElement element){
        element.clear();
    }

    public void sendKeysToElement(WebElement element, String stringToSend) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            element.clear();
            element.sendKeys(stringToSend);
        } catch (StaleElementReferenceException ex) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            element.clear();
            element.sendKeys(stringToSend);
        }
    }

    public String getElementAttribute(WebElement element, String attributeName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return element.getAttribute(attributeName);
    }

    public void selectValueFromDropdown(WebElement element, String value) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }

    public void selectValueFromDropdownByIndex(WebElement element, int index){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    public String getHeader() {
        return driver.getTitle();
    }

    public boolean isElementVisible(WebElement element){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return element.isDisplayed();
    }

    public Boolean isElementEnabled(WebElement element){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return element.isEnabled();
    }

    public void waitForElementToBeClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementIsNotVisible(WebElement element){
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            System.out.println("INFO Wait for element failed. Message: " + e.getMessage());
        }
    }
}
