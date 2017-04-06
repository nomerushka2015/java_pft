package ru.stqa.pft.addressbook;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Workdesk {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.15.0-win64/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }
    
    @Test
    public void Workdesk() {
        wd.get("https://skypetime.hardpoint.eu/");
        wd.findElement(By.id("username")).click();
        wd.findElement(By.id("username")).clear();
        wd.findElement(By.id("username")).sendKeys("point/nomerovskaya.a");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("nomer356131");
        wd.findElement(By.id("SubmitCreds")).click();
        wd.findElement(By.id("btnWorktimeByUser")).click();
        wd.findElement(By.linkText("Открыть выбор даты")).click();
        wd.findElement(By.xpath("//div[@class='ui-datebox-grid']//div[.='1']")).click();
        wd.findElement(By.id("RefreshGridButton")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
