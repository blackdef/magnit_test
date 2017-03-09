package ru.magnit.test.vacancy.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Fedor on 14.10.2016.
 */
public class SessionHelper extends HelperBase{

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String userName, String password) {
    type(By.name("user"),userName);
    type(By.name("pass"),password);
    click(By.xpath("//form[@id='LoginForm']/input[3]"));

  }
}
