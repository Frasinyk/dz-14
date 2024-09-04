package org.example;
import helpers.TestMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import helpers.Basic;
import java.util.HashMap;
import java.util.Map;

public class MyTest {
    private WebDriver driver;
    Basic basic;
    TestMethods methods;

    @BeforeMethod
    public void beforeFirstTest() {
        driver = basic.setDriver();
        driver.manage().window().maximize();
        methods = new TestMethods(driver);
    }

    @AfterTest
    public void closeChrome(){
        driver.close();
    }

    @Test(priority = 1)
    public void clickOnButtons() {
        driver.get("https://demoqa.com/elements");
        By button = By.id("item-4");
        By buttonClickMe = By.xpath("//*[text() = 'Click Me']");
        By message = By.id("dynamicClickMessage");
        driver.findElement(button).click();
        driver.findElement(buttonClickMe).click();
        System.out.println(driver.findElement(message).getText());
    }

    @Test(priority = 2)
    public void fillForm(){
        Map<String, String> create = new HashMap<>();
        create.put("fieldName", "Oksana");
        create.put("fieldLastName", "Frasyniuk");
        create.put("fieldEmail", "test@email.com");
        create.put("fieldAge", "30");
        create.put("fieldSalary", "1000000000");
        create.put("fieldDepartment", "IT");

        Map<String, String> edit = new HashMap<>();
        edit.put("fieldName", "Solomia");
        edit.put("fieldAge", "9");

        driver.get("https://demoqa.com/webtables");
        methods.clickOnAddForm()
                .changeForm(create).checkText(create)
                .clickOnEdit()
                .changeForm(edit);
    }
}
