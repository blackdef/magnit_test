package ru.magnit.test.vacancy.tests;

import org.testng.annotations.Test;
import ru.magnit.test.vacancy.model.VacancyData;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VacancySubmit extends TestBase{

    @Test
    public void testSubmitVacancyWithOutParameter() {
        Set<String> actualErrors = new HashSet<String>();
        Set<String> expectedErrors = new HashSet<String>();
        VacancyData vacancy = new VacancyData().withRegion("Архангельская область").withCity("Архангельск").withVacancyName("Главный юристконсульт").
                withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
                withEmail("qwe@asd.zx").withApproval(true).withVacancyNameId(21696156).withCityId(4339).
                withRegionId(829).withContactPhone("1234567980");

        app.goTo().startPage();
        app.vacancy().fillVacancy(vacancy);
        app.vacancy().submitForm();
        actualErrors = app.vacancy().getErrorlist();
        assertThat(actualErrors, equalTo(expectedErrors));

    }




}
