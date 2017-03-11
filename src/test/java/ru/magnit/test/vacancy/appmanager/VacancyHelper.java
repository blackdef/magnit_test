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
    click(By.cssSelector("#cuselFrame-vregid div.cuselFrameRight"));
    click(By.cssSelector("#cusel-scroll-vregid span[value=\""+vacancy.getRegionId().toString()+"\"]"));
    click(By.cssSelector("div#cuselFrame-vcid div.cuselFrameRight"));
    click(By.cssSelector("#cusel-scroll-vcid span[value=\""+vacancy.getCityId().toString()+"\"]"));
    click(By.cssSelector("#cuselFrame-vac_name div.cuselFrameRight"));
    click(By.cssSelector("#cusel-scroll-vac_name span[value=\""+vacancy.getVacancyNameId().toString()+"\"]"));


    type(By.name("user_fio"),vacancy.getPersonFullName());
    type(By.name("user_date_day"),vacancy.getBirthDay());
    type(By.name("user_date_year"),vacancy.getBirthYear());
    type(By.name("user_phone"),vacancy.getContactPhone());
    type(By.name("user_mail"),vacancy.getEmail());

  }
}
