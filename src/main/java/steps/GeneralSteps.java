package steps;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FilenameFilter;
import java.time.Duration;
import java.util.Arrays;

public class GeneralSteps {
    private WebDriver driver;

    // INFO parameters for Jenkins run - comment for local run
//    private String environment = System.getProperty("baseUrl");
//    private String credentials = System.getProperty("Credentials");

    //info this is for local run
    private String environment = "www.google.com";
    private String credentials = "";

    //info here we go
    private String baseUrl;
    public GeneralSteps(WebDriver driver) {
        super();
        this.driver = driver;
    }

    public void getTestedPage() {
        driver.get(getBaseUrl());
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void getTitle() {
        System.out.println(driver.getTitle());
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void verifyRedirectToExpectedPage(String msg, String url) {
        verifyRedirectToExpectedPage(msg, url, null);
    }

    public void verifyRedirectToExpectedPageContains(String msg, String url) {
        verifyRedirectToExpectedPageContains(msg, url, null);
    }


    public void verifyUrlContains(String msg, String contains) {
        System.out.println("Current url: " + driver.getCurrentUrl());
        Assert.assertTrue(msg, driver.getCurrentUrl().contains(contains));
    }

    public void verifyUrlDontContains(String msg, String contains) {
        Assert.assertFalse(msg, driver.getCurrentUrl().contains(contains));
    }

    public void verifyTitle(String msg, String title) {
        try {
            String actualTitle = driver.findElement(By.tagName("h1")).getText().trim();
            Assert.assertEquals(msg, title, actualTitle);
        } catch (StaleElementReferenceException ex) {
            String actualTitle = driver.findElement(By.tagName("h1")).getText().trim();
            Assert.assertEquals(msg, title, actualTitle);
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void waitUntilUrlChange(String original) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return !driver.getCurrentUrl().equals(original);
                }
            });
        } catch (Throwable t) {
        }
    }

    public String getEnvironment() {
        return environment;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

}
