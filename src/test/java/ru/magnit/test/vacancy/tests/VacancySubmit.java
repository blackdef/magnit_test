package ru.magnit.test.vacancy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.magnit.test.vacancy.model.VacancyData;

import java.io.File;
import java.util.*;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VacancySubmit extends TestBase {


  @DataProvider
  public Iterator<Object[]> vacansiesWithFile() {
    List<Object[]> list = new ArrayList<Object[]>();
    Set<String> errors = new HashSet<String>();
    errors.add("Текст с картинки указан неверно");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Должность, на которую претендуете'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").
            withRegionId(16).withCityId(115).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});

    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Должность, на которую претендуете'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").
            withRegionId(16).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Должность, на которую претендуете'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'ФИО'");
    list.add(new Object[]{new VacancyData().
            withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Дата рождения (день)'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Дата рождения (год)'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Контактный телефон'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Контактный e-mail'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не заполнено поле 'Я даю согласие на обработку персональных данных'");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/test.docx"))
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Не загружен файл резюме!");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040)
            ,
            errors});
    errors = new HashSet<String>();
    errors.add("Неправильный формат файла");
    list.add(new Object[]{new VacancyData().
            withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
            withEmail("qwe@asd.zx").withApproval(true).withContactPhone("1234567980").
            withRegion("Калужская область").withCity("Калуга").withVacancyName("Директор магазина \"Магнит Косметик\"").
            withRegionId(16).withCityId(115).withVacancyNameId(21605040).
            withResume(new File("src/test/resources/stru.gif"))
            ,
            errors});
    return list.iterator();
  }


  @Test(dataProvider = "vacansiesWithFile")
  public void testSubmitVacancyWithOutParameter(VacancyData vacancy, Set<String> expectedErrors) throws InterruptedException {
    Set<String> actualErrors;

    app.goTo().startPage();
    app.vacancy().fillVacancy(vacancy);
    app.vacancy().submitForm();

    sleep(2000);

    actualErrors = app.vacancy().getErrorlist();
    assertThat(actualErrors, equalTo(expectedErrors));

  }

}
