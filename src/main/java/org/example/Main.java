package org.example;

import java.util.HashMap;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {

    protected static WebDriver driver;

    public static void DefineChrome() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        System.out.printf("Environment: https://%s@%s%n", System.getProperty("Credentials"), System.getProperty("baseUrl"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
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

    public static void main(String[] args) {

        //toto otvori chrome
        DefineChrome();

        //toto otvori google
        driver.get("https://www.google.com/");

        //toto napise daco do search fieldu
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("co chcete vyhladat");
//
//        //tuna kliknete na button ktory spusti vyhladavanie
//        driver.findElement(By.xpath("lokator sem")).click();



    }
}