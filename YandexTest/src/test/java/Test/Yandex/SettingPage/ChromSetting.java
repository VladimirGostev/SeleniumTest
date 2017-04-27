package Test.Yandex.SettingPage;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



/**
 * Created by VGostev on 03.04.2017.
 */
public class ChromSetting {
    protected WebDriver driver = new ChromeDriver();
    protected String cityMoscow = "москва";
    protected String weaterChekPenza = "Пензе";
    protected String weaterCheksMoscow = "Москве";
    protected String email = "gostev.test-selenium@yandex.ru";
    protected String pasword = "Ntcn14as12";
    protected String timeLocator = ".current-weather__today";
    @Before
    public void yandexSearch(){
        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void driverQuit(){
        driver.close();
    }
}


