package helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestMethods {
    public TestMethods(WebDriver driver) {
        this.driver = driver;
        this.basic = new Basic(driver);
    }

    WebDriver driver;
    Basic basic;
    Map<String, By> fields;

    By buttonAdd = By.id("addNewRecordButton");
    By buttonSubmitForm = By.id("submit");
    By buttonEdit = By.id("edit-record-4");
    By record  = By.xpath("//*[text()[contains(.,'Oksana')]]/parent::*");

    public void initializeFormData() {
        this.fields = new HashMap<>();
        this.fields.put("fieldName", By.xpath("//input[@id='firstName']"));
        this.fields.put("fieldLastName", By.xpath("//input[@id='lastName']"));
        this.fields.put("fieldEmail", By.xpath("//input[@id='userEmail']"));
        this.fields.put("fieldAge", By.xpath("//input[@id='age']"));
        this.fields.put("fieldSalary", By.xpath("//input[@id='salary']"));
        this.fields.put("fieldDepartment", By.xpath("//input[@id='department']"));
    }


    public TestMethods clickOnAddForm() {
        driver.findElement(buttonAdd).click();
        return this;
    }

    public TestMethods changeForm(Map<String, String> map) {
        this.initializeFormData();
        basic.scroll();
        for (String key : map.keySet()) {
            driver.findElement(fields.get(key)).clear();
            driver.findElement(fields.get(key)).sendKeys(map.get(key));
        }
        driver.findElement(buttonSubmitForm).click();
        return this;
    }

    public TestMethods clickOnEdit() {
        driver.findElement(buttonEdit).click();
        return this;
    }

    public TestMethods checkText(Map<String, String> create){
        String actualRecord = (driver.findElement(record).getText());
        for (String key : create.keySet()) {
            Assert.assertTrue(actualRecord.contains(create.get(key)), "wrong record "+key);
        }
        return this;
    }

}
