package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPageObjects extends  PageObjects{
    private WebDriver driver;

    public FirstPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "placeholder")
    private WebElement placeholder;

    public void clickPlaceholder(){
        clickOnElement(placeholder);
    }

    public String getPlaceolderText(){
        return getElementText(placeholder);
    }
}
