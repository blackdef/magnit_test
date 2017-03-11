package ru.magnit.test.vacancy.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fedor on 14.10.2016.
 */
public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;

  private NavigationHelper navigationHelper;
  private VacancyHelper vacancyHelper;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String userconfig = System.getProperty("userconfig","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", userconfig))));
    if (browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.IE)){
      wd = new InternetExplorerDriver();
    }
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    navigationHelper = new NavigationHelper(wd);
    vacancyHelper = new VacancyHelper(wd);

  }

  public void stop() {
    wd.quit();
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public VacancyHelper vacancy() {
    return vacancyHelper;
  }
}
