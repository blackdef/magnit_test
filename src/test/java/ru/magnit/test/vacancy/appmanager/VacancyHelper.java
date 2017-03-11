package ru.magnit.test.vacancy.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.magnit.test.vacancy.model.VacancyData;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;

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
    if (vacancy.getRegionId()!=null) {
      click(By.cssSelector("#cuselFrame-vregid div.cuselFrameRight"));
      sclick(By.cssSelector("#cusel-scroll-vregid span[value=\"" + vacancy.getRegionId().toString() + "\"]"));
      if (vacancy.getCityId()!= null) {
        click(By.cssSelector("div#cuselFrame-vcid div.cuselFrameRight"));
        sclick(By.cssSelector("#cusel-scroll-vcid span[value=\"" + vacancy.getCityId().toString() + "\"]"));

        if (vacancy.getVacancyNameId()!=null) {
          click(By.cssSelector("#cuselFrame-vac_name div.cuselFrameRight"));
          click(By.cssSelector("#cusel-scroll-vac_name span[value=\"" + vacancy.getVacancyNameId().toString() + "\"]"));
        }
      }
    }

    type(By.name("user_fio"), vacancy.getPersonFullName());
    type(By.name("user_date_day"), vacancy.getBirthDay());
    type(By.name("user_date_year"), vacancy.getBirthYear());
    type(By.name("user_phone"), vacancy.getContactPhone());
    type(By.name("user_mail"), vacancy.getEmail());
    if (vacancy.getApproval()!=null) {
      if (vacancy.getApproval()) {
        jclick(By.name("other_agree"));
      }
    }
    if (vacancy.getResume() != null){
      jclick(By.id("ft_1"));
      attach(By.id("File1"), vacancy.getResume());
    }


  }

  public Set<String> getErrorlist() {
    Set<String> errorList = new HashSet<String>();
    String errorText = wd.findElement(By.cssSelector("p#text_err")).getText();
    String[] errors = errorText.split("\\n");
    for (String s : errors) {
      errorList.add(s);
    }

    return errorList;
  }
}
