package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class Basic {
    public Basic (WebDriver driver) {
        this.driver = driver;
    }
    WebDriver driver;
    public static WebDriver setDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/oksanafrasynuyk/autotests/pinpools_selenium_automation_tests/driver/chromedriver");
        return new ChromeDriver();
    }
    public Basic scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
        return this;
}
}
