package ru.magnit.test.vacancy.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.magnit.test.vacancy.model.VacancyData;

import static org.openqa.selenium.OutputType.*;

public class VacancySubmit extends TestBase{

    @Test
    public void testSubmitVacancyWithOutParameter() {
        VacancyData vacancy = new VacancyData().withRegion("Архангельская область").withCity("Архангельск").withVacancyName("Главный юристконсульт").
                withPersoneFullName("Пупкин Иван Иванович").withBirthDay("12").withBirthYear("1234").
                withEmail("qwe@asd.zx").withApproval(true).withVacancyNameId(21696156).withCityId(4339).
                withRegionId(829).withContactPhone("1234567980");

        app.goTo().startPage();
        app.vacancy().fillVacancy(vacancy);
        app.vacancy().submitForm();
        //app.vacancy().getErrorlist();
    }




}
