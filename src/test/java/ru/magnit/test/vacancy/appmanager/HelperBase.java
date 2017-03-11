package ru.magnit.test.vacancy.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

/**
 * Created by Fedor on 15.10.2016.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    WebElement webElement = wd.findElement(locator);
   //((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", webElement);
    webElement.click();
  }
  protected void sclick(By locator) {
    WebElement webElement = wd.findElement(locator);
    ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", webElement);
    webElement.click();
  }
  protected void jclick(By locator) {

    WebElement webElement = wd.findElement(locator);
    ((JavascriptExecutor)wd).executeScript("arguments[0].click()", webElement);
  }



  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }
  protected void attach(By locator, File file) {
    wd.findElement(locator).sendKeys(file.getAbsolutePath());
  }

  public  boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected boolean isElementPresent(By locator) {
    try{
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e){
      return false;
    }
  }


}
