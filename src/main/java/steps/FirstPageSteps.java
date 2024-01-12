package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.FirstPagePageObjects;

public class FirstPageSteps {

    private WebDriver driver;

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    private FirstPagePageObjects firstPageObjects() {
        return new FirstPagePageObjects(driver);
    }

    public void clickOnPlaceholder(){
        firstPageObjects().clickPlaceholder();
    }

    public String getPlaceholderText(){
        return firstPageObjects().getPlaceolderText();
    }

    public void verifyPlaceholderText(String msg, String expected){
        Assert.assertEquals(msg, expected, firstPageObjects().getPlaceolderText());
    }
}
