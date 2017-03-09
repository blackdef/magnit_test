package ru.magnit.test.vacancy.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.magnit.test.vacancy.model.VacancyData;

/**
 * Created by plotnikov on 09.03.2017.
 */
public class VacancyHelper extends HelperBase {
  public VacancyHelper(WebDriver wd) {
    super(wd);
  }
  public void submitForm() {
    wd.findElement(By.id("form_sbmt")).click();
  }

  public void fillVacancy(VacancyData vacancy) {
    click(By.cssSelector("div.cuselFrameRight"));
    click(By.xpath(String.format("//div[@id='cusel-scroll-vregid']//span[.='%s']",vacancy.getRegion())));
    click(By.xpath("//div[@id='cuselFrame-vcid']/div[1]"));
    click(By.xpath("//div[@id='cusel-scroll-vcid']//span[.='Калуга']"));
    click(By.xpath("//div[@id='cuselFrame-vac_name']/div[1]"));
    click(By.xpath("//div[@id='cusel-scroll-vac_name']/span[6]"));
    click(By.xpath("//div[@id='cuselFrame-vac_name_0']/div[1]"));
    click(By.xpath("//div[@id='cusel-scroll-vac_name_0']//span[.='Продавец магазина \"Магнит\"']"));

    type(By.name("user_fio"),vacancy.getPersonFullName());
    type(By.name("user_date_day"),vacancy.getBirthDay());
    type(By.name("user_date_year"),vacancy.getBirthYear());
    type(By.name("user_phone"),vacancy.getContactPhone());
    type(By.name("user_mail"),vacancy.getEmail());

  }
}
