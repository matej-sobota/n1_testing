package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.FirstPageObjects;

public class FirstPageSteps {

    private WebDriver driver;

    public FirstPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    private FirstPageObjects firstPageObjects() {
        return new FirstPageObjects(driver);
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
