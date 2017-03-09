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
import static org.openqa.selenium.OutputType.*;

public class SubmitWithOutAppruv {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void SubmitWithOutAppruv() {
        wd.get("http://magnit-info.ru/work/vacancy/blank/");
        wd.findElement(By.cssSelector("div.cuselFrameRight")).click();
        wd.findElement(By.xpath("//div[@id='cusel-scroll-vregid']//span[.='Калужская область']")).click();
        wd.findElement(By.xpath("//div[@id='cuselFrame-vcid']/div[1]")).click();
        wd.findElement(By.xpath("//div[@id='cusel-scroll-vcid']//span[.='Калуга']")).click();
        wd.findElement(By.xpath("//div[@id='cuselFrame-vac_name']/div[1]")).click();
        wd.findElement(By.xpath("//div[@id='cusel-scroll-vac_name']/span[6]")).click();
        wd.findElement(By.xpath("//div[@id='cuselFrame-vac_name_0']/div[1]")).click();
        wd.findElement(By.xpath("//div[@id='cusel-scroll-vac_name_0']//span[.='Продавец магазина \"Магнит\"']")).click();
        wd.findElement(By.name("user_fio")).click();
        wd.findElement(By.name("user_fio")).clear();
        wd.findElement(By.name("user_fio")).sendKeys("asdasdasd");
        wd.findElement(By.name("user_date_day")).click();
        wd.findElement(By.name("user_date_day")).clear();
        wd.findElement(By.name("user_date_day")).sendKeys("12");
        wd.findElement(By.name("user_date_year")).click();
        wd.findElement(By.name("user_date_year")).clear();
        wd.findElement(By.name("user_date_year")).sendKeys("1231");
        wd.findElement(By.xpath("//div[@id='fast_sub_form']/form")).click();
        wd.findElement(By.cssSelector("div.close-sub")).click();
        wd.findElement(By.name("user_phone")).click();
        wd.findElement(By.name("user_phone")).clear();
        wd.findElement(By.name("user_phone")).sendKeys("123123123");
        wd.findElement(By.name("user_mail")).click();
        wd.findElement(By.name("user_mail")).clear();
        wd.findElement(By.name("user_mail")).sendKeys("qweqwe@qweqwe.we");
        wd.findElement(By.id("form_sbmt")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
