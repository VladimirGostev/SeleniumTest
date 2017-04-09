package Test.Yandex;


import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by VGostev on 03.04.2017.
 */
public class YandexPage {
    private WebDriver driver;

    public YandexPage(WebDriver driver) {
        this.driver = driver;
    }

    By weatherYandexLocator = By.xpath(".//*[@id='wd-_weather']/div/h1/a[1]" );
    By weatherMontLocator = By.xpath("//ul/*/a[@class='link forecast-brief__item-description forecast-brief__item-description_link_yes t t_c_11']");
    By paswordLocator = By.xpath("//input[@placeholder='Пароль']");
    By entranceButton = By.xpath("//div/*/button[@class='button button_theme_action button_size_m i-bem button_js_inited']");
    String inputSearchWeatherLocator = "#header2input";
    String newCityWeatherLinkLocator = "//ul/*/a[@class='link place-list__item-name']";
    String textWeaterLocator = ".copyright-tech";
    String entranceLocator = "//button[@title='Войти']";
    String emailLocator = "//input[@placeholder='Логин']";
    String mapYandexLocator = "//div/*/a[@href='https://yandex.ru/maps/?utm_source=geoblock_maps_penza']";
    String yandexMainPageLocator = "//div/*/img[@class='image']";
    String mapMove = "//div/*/ymaps[@class='ymaps-2-1-48-map']";
    String myLocation = "#my-location";

    //Метод для перехода на страничку погоды яндекс
    public void weatherYandex(){
        driver.findElement(weatherYandexLocator).click();
    }
    //Метод для вытаскивания текста из веб элемента
    public String getTextSelector(String selectorName){
        String textSelector =  driver.findElement(By.cssSelector(selectorName)).getText();
        return textSelector;
    }
    //Метод для перехода на страничку погоды другого города в зависимости от переданного параметра
    public void weaterSearcMoscow(String city){
        driver.findElement(By.cssSelector(inputSearchWeatherLocator)).sendKeys(city, Keys.ENTER);
        WebElement element = driver.findElement(By.xpath(newCityWeatherLinkLocator));
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
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(myLocation)));
        myLocationButton.click();
    }
    //Метод для открытия всплывающего окна для входа в личный кабинет
    public void clickEntrance(){
        //String parentHandle = driver.getWindowHandle();
        WebElement acauntButton = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(entranceLocator)));
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
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(emailLocator)));
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
        System.out.println("Вы вошли под своей учетной записью");
    }
    //Метод для возврата к стартовой странице Яндекс
    public void returnMainYandexPage(){
        WebElement returnMainYandex = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(yandexMainPageLocator)));
        returnMainYandex.click();
    }

    public void actionMap(){
        WebElement mapYandex = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(mapYandexLocator)));
        mapYandex.click();
        WebElement mapYandexMove = (new WebDriverWait(driver,10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(mapMove)));
        Actions action = new Actions(driver);
        /*action.clickAndHold(mapYandexMove);
        action.moveToElement(mapYandexMove, 1000, 2000);*/
        action.dragAndDropBy(mapYandexMove, 1000, 2000);
    }

}
