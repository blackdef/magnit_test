package ru.magnit.test.vacancy.tests;

import org.testng.annotations.Test;
import ru.magnit.test.vacancy.model.VacancyData;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VacancySubmit extends TestBase{

    @Test
    public void testSubmitVacancyWithOutParameter() throws InterruptedException {
        Set<String> actualErrors;
        Set<String> expectedErrors = new HashSet<>();
        expectedErrors.add("Не загружен файл резюме!");

        VacancyData vacancy = new VacancyData().withRegion("Архангельская область").withCity("Архангельск").withVacancyName("Главный юристконсульт").
                withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
                withEmail("qwe@asd.zx").withApproval(true).
                withRegionId(1389).withContactPhone("1234567980");
        //.withVacancyNameId(8857368)  withRegionId(1389)  withCityId(2320326)

        app.goTo().startPage();
        app.vacancy().fillVacancy(vacancy);
        app.vacancy().submitForm();
        sleep(1000);

        actualErrors = app.vacancy().getErrorlist();
        assertThat(actualErrors, equalTo(expectedErrors));

    }

    @Test
    public void testWorkWithSet() {

        Set<String> actualErrors = new HashSet<String>();


        app.goTo().startPage();
        app.vacancy().submitForm();

        actualErrors = app.vacancy().getErrorlist();

    }




}
