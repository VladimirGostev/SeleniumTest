package Test.Yandex.Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by vgostev on 10.04.2017.
 */
public class YandexWeaterPage {
    private WebDriver driver;

    public YandexWeaterPage(WebDriver driver) {
        this.driver = driver;
    }

    By weatherMontLocator = By.xpath("//ul/*/a[@class='link forecast-brief__item-description forecast-brief__item-description_link_yes t t_c_10']");
    By paswordLocator = By.xpath("//input[@placeholder='Пароль']");
    By entranceButton = By.xpath("//div/*/button[@class='button button_theme_action button_size_m i-bem button_js_inited']");
    By equalsUserNameLocator = By.xpath("*//div/*/span[@class='user__name i-bem']");
    By inputSearchWeatherLocator = By.cssSelector("#header2input");
    By newCityWeatherLinkLocator = By.xpath("//ul/*/a[@class='link place-list__item-name']");
    By entranceLocator = By.xpath("//button[@title='Войти']");
    By emailLocator = By.xpath("//input[@placeholder='Логин']");
    By yandexMainPageLocator = By.xpath("//div/*/img[@class='image']");
    By myLocationLocator = By.cssSelector("#my-location");
    String textWeaterLocator = ".copyright-tech";

    public String getTextSelector(String selectorName){
        String textSelector =  driver.findElement(By.cssSelector(selectorName)).getText();
        return textSelector;
    }
    //Метод для перехода на страничку погоды другого города в зависимости от переданного параметра
    public void weaterSearcMoscow(String city){
        driver.findElement(inputSearchWeatherLocator).sendKeys(city, Keys.ENTER);
        WebElement element = driver.findElement(newCityWeatherLinkLocator);
        element.click();
    }
    /*Метод для проверки что мы находимся на страничке погоды нужного нам Города
    (Такая себе проверка тк проверки нет просто выводитсясообщение с текстом про текущей город при условии что пройдет сравнение)*/
    public void equalsWeater(String weaterEqualsCity){
        String weaterEqualsPenzaLocator = getTextSelector(textWeaterLocator);
        Assert.assertEquals(weaterEqualsPenzaLocator, weaterEqualsCity);
        System.out.println(weaterEqualsPenzaLocator);
    }

    //Метод для перехода на страничку погоды для 30-ти дней
    public void cheakWeaterMont(){
        driver.findElement(weatherMontLocator).click();

    }
    //Метод для перехода нас траничку погоды для текущей локации пользывателя
    public void returnMyLocationWeather(){
        WebElement myLocationButton = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(myLocationLocator));
        myLocationButton.click();
    }
    //Метод для открытия всплывающего окна для входа в личный кабинет
    public void clickEntrance(){
        //String parentHandle = driver.getWindowHandle();
        WebElement acauntButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(entranceLocator));
        acauntButton.click();
       /* try {
            //Switch to the Help Popup Browser Window
            driver.switchTo().window("HelpWindow");

        } catch (NoSuchWindowException e) {

        }*/

    }
    //ввод логина ЛК
    public void inputEmail(String email) {

        WebElement login = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(emailLocator));
        login.click();
        login.click();
        login.sendKeys(email);
    }
    //ввод пароля ЛК
    public void inputPasword(String psw){
        WebElement pasword = driver.findElement(paswordLocator);
        pasword.click();
        pasword.click();
        pasword.sendKeys(psw);
        //pasword.sendKeys(Keys.ENTER);

    }
    //Нажатие кнопки Вход на форме всплывающего окна для входа в ЛК
    public void entrance(){
        driver.findElement(entranceButton).click();
    }
    //Метод объединящие все действия для входа в ЛК
    public void entanceLoginYandex(String email, String pasword) {
        clickEntrance();
        inputEmail(email);
        inputPasword(pasword);
        entrance();
        assertUserName();
        System.out.println("Вы вошли под своей учетной записью");
    }
    //Метод для проверки имени пользывателя
    public void assertUserName(){
        Assert.assertEquals("Eror user name", driver.findElement(equalsUserNameLocator).getText(),"gostev-test-sel…");
    }
    //Метод для возврата к стартовой странице Яндекс
    public void returnMainYandexPage(){
        WebElement returnMainYandex = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(yandexMainPageLocator));
        returnMainYandex.click();
    }

}
