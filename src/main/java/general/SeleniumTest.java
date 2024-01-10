package general;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class SeleniumTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        //locally you need to uncomment these two lines and put chromedriver that is in folder to location unfortunately it has to be absolute path and not relative
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {
        //locally you need to uncomment these two lines and put chromedriver that is in folder to location unfortunately it has to be absolute path and not relative
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        options.addArguments("--verbose");
        options.addArguments("window-size=1400,1500");
        options.addArguments("--disable-gpu");
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("user-agent=SeleniumTest");

        System.out.println(options.toString());

        // Change default download directory to custom one
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", chromePrefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    public WebDriver driver(WebDriver driver) {
        this.driver = driver;
        return driver;
    }
}