package ru.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * Created by Nastya Nomerovskaya on 11.04.2017.
 */
public class ApplicationManager {
  FirefoxDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;



  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:/geckodriver-v0.15.0-win64/geckodriver.exe");
    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
    capabilities.setCapability("marionette", true);

    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
