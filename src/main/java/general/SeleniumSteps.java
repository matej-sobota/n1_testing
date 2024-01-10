package general;


import org.openqa.selenium.WebDriver;

public class SeleniumSteps {
    protected static WebDriver driver;

    public WebDriver driver(WebDriver driver) {
        this.driver = driver;
        return driver;
    }
}
