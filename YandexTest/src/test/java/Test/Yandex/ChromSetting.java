package Test.Yandex;

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
    protected String weaterEqualsPenza = "Прогноз погоды в Пензе с точностью до района — рассчитан с помощью технологии Meteum";
    protected String weaterEqualsMoscow = "Прогноз погоды в Москве с точностью до района — рассчитан с помощью технологии Meteum";
    protected String emailLogin = "gostev.test-selenium@yandex.ru";
    protected String paswordLogin = "Ntcn14as12";
    protected String timeLocator = ".current-weather__today";
    @Before
    public void YandexSearch(){
        driver.get("https://yandex.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @After
    public void DriverQuit(){
        driver.close();
    }

}


