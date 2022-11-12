import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EkaterinaKochelorovaTest {

    //   TC_1_1 - Тест кейс:
    //   1. Открыть страницу https://openweathermap.org/
    //   2. Набрать в строке поиска город Paris
    //   3. Нажать пункт меню Search
    //   4. Из выпадающего списка выбрать Paris, FR
    //   5. Подтвердить, что заголовок изменился на "Paris, FR"

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);

        Thread.sleep(5000);
        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']"));
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']"));
        searchButton.click();

        Thread.sleep(1000);
        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']"));
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(By.xpath("//div[@id = 'weather-widget']//h2"));

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(1000);
        driver.quit();
    }

    //    TC_11_01
//    1.  Открыть базовую ссылку
//    2.  Нажать на пункт меню Guide
//    3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide и что title этой страницы
//    OpenWeatherMap API guide - OpenWeatherMap
    @Test
    public void testOpenPageGuideOnclickAHrefGuide() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/guide";
        String expectedResult1 = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);

        Thread.sleep(5000);
        WebElement guideLink = driver.findElement(By.xpath("//div[@id = 'desktop-menu']/ul/li/a[@href = '/guide']"));
        guideLink.click();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        String actualResult1 = driver.getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);

        Thread.sleep(1000);
        driver.quit();
    }

    //    TC_11_02
//    1.  Открыть базовую ссылку
//    2.  Нажать на единицы измерения Imperial: °F, mph
//    3.  Подтвердить, что температура для города показана в Фаренгейтах
    @Test
    public void testSpanClassHeading_WhenImperialF() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String unit = "°F";
        boolean expectedResult = unit.contains(unit);

        driver.get(url);

        Thread.sleep(5000);
        WebElement unitFText = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']"));
        unitFText.click();

        WebElement spanTempHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[@class = 'current-temp']/span[contains(text(), '°F')]"));

        Thread.sleep(2000);
        boolean actualResult = spanTempHeader.getText().contains(unit);

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(1000);
        driver.quit();
    }

    //    TC_11_03
//    1. Открыть базовую ссылку
//    2. Подтвердить, что внизу страницы есть панель с текстом “We use cookies which are essential for the site to work.
//    We also use non-essential cookies to help us improve our services. Any data collected is anonymised. You can allow
//    all cookies or manage them individually.”
//    3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
    @Test
    public void testTextAndTwoButtons_FooterPanel() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "We use cookies which are essential for the site to work. We also use non-essential "
                + "cookies to help us improve our services. Any data collected is anonymised. You can allow all cookies "
                + "or manage them individually.";
        String expectedResult1 = "Allow all";
        String expectedResult2 = "Manage cookies";

        driver.get(url);

        Thread.sleep(5000);
        WebElement footerPanelDescription = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p[@class = 'stick-footer-panel__description']"));

        String actualResult = footerPanelDescription.getText();

        Assert.assertEquals(actualResult, expectedResult);

        WebElement buttonFooterPanelLink = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//button[@type = 'button']"));

        String actualResult1 = buttonFooterPanelLink.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement aHrefFooterPanelLink = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//a[@class = 'stick-footer-panel__link']"));

        String actualResult2 = aHrefFooterPanelLink.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        Thread.sleep(1000);
        driver.quit();
    }

//    TC_11_04
//    1.  Открыть базовую ссылку
//    2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
    public void testSupportDropdownMenu() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        String expectedResult = "FAQ";
        String expectedResult1 = "How to start";
        String expectedResult2 = "Ask a question";

        driver.get(url);

        Thread.sleep(5000);
        WebElement supportDropdownMenu = driver.findElement(By.id("support-dropdown"));
        supportDropdownMenu.click();

        WebElement faqLink = driver.findElement(By.xpath("//ul[@id = 'support-dropdown-menu']/li/a[@href = '/faq']"));

        String actualResult = faqLink.getText();

        Assert.assertEquals(actualResult, expectedResult);

        WebElement appidLink = driver.findElement(By.xpath("//ul[@id = 'support-dropdown-menu']/li/a[@href = '/appid']"));

        String actualResult1 = appidLink.getText();

        Assert.assertEquals(actualResult1, expectedResult1);

        WebElement questionsLink = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']/li/a[@target = '_blank']"));

        String actualResult2 = questionsLink.getText();

        Assert.assertEquals(actualResult2, expectedResult2);

        Thread.sleep(1000);
        driver.quit();
    }

//    TC_11_05
//    1. Открыть базовую ссылку
//    2. Нажать пункт меню Support → Ask a question
//    3. Заполнить поля Email, Subject, Message
//    4. Не подтвердив CAPTCHA, нажать кнопку Submit
//    5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”
    @Test
    public void testError_InNewQuestionForm_WhenIgnoreCaptcha() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        String email = "email@mail.ru";
        String message = "Hi!";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        driver.get(url);

        Thread.sleep(5000);
        WebElement supportDropdownMenu = driver.findElement(By.id("support-dropdown"));
        supportDropdownMenu.click();

        WebElement questionsLink = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']/li/a[@target = '_blank']"));
        questionsLink.click();

        driver.get("https://home.openweathermap.org/questions");
        WebElement emailField = driver.findElement(By.id("question_form_email"));
        emailField.click();
        emailField.sendKeys(email);

        Thread.sleep(2000);
        WebElement subjectField = driver.findElement(By.id("question_form_subject"));
        subjectField.click();

        WebElement otherChoiceInDropdownMenu = driver.findElement(
                By.xpath("//select[@id = 'question_form_subject']/option[@value = 'Other']"));
        Thread.sleep(2000);
        otherChoiceInDropdownMenu.click();

        WebElement messageField = driver.findElement(By.id("question_form_message"));
        messageField.click();
        Thread.sleep(2000);
        messageField.sendKeys(message);

        WebElement submitButton = driver.findElement(
                By.xpath("//form[@id = 'new_question_form']//input[@type = 'submit']"));
        submitButton.click();

        WebElement captchaText = driver.findElement(
                By.xpath("//form[@id = 'new_question_form']//div[@class = 'help-block']"));

        String actualResult = captchaText.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(1000);
        driver.quit();
    }

//    TC_11_06
//    1.  Открыть базовую ссылку
//    2.  Нажать пункт меню Support → Ask a question
//    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//    4.  Оставить пустым поле Email
//    5.  Заполнить поля  Subject, Message
//    6.  Подтвердить CAPTCHA
//    7.  Нажать кнопку Submit
//    8.  Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”
    @Test
    public void testErrorEmail_InAskAQuestion_WhenConfirmingCaptchaAndClickingSubmit() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        String message = "Hi!";
        String expectedResult = "can't be blank";

        driver.get(url);

        Thread.sleep(5000);
        WebElement supportDropdownMenu = driver.findElement(By.id("support-dropdown"));
        supportDropdownMenu.click();

        WebElement questionsLink = driver.findElement(
                By.xpath("//ul[@id = 'support-dropdown-menu']/li/a[@target = '_blank']"));
        questionsLink.click();

        driver.get("https://home.openweathermap.org/questions");

        Thread.sleep(2000);
        WebElement subjectField = driver.findElement(By.id("question_form_subject"));
        subjectField.click();

        WebElement otherChoiceInDropdownMenu = driver.findElement(
                By.xpath("//select[@id = 'question_form_subject']/option[@value = 'Other']"));
        otherChoiceInDropdownMenu.click();

        WebElement messageField = driver.findElement(By.id("question_form_message"));
        messageField.click();
        Thread.sleep(2000);
        messageField.sendKeys(message);
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']")));
        element.click();

        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        WebElement submitButton = driver.findElement(
                By.xpath("//form[@id = 'new_question_form']//input[@type = 'submit']"));
        submitButton.click();

        Thread.sleep(5000);
        WebElement helpBlockEmail = driver.findElement(
                By.xpath("//span[@class = 'help-block']"));

        String actualResult = helpBlockEmail.getText();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);
        driver.quit();
    }

//    TC_11_07
//    1.  Открыть базовую ссылку
//    2.  Нажать на единицы измерения Imperial: °F, mph
//    3.  Нажать на единицы измерения Metric: °C, m/s
//    4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С
    @Test
    public void testSpanClassHeading_WhenTempFChangedToC() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        String unit = "°C";
        boolean expectedResult = unit.contains("°C");

        driver.get(url);

        Thread.sleep(5000);
        WebElement unitFTextImperial = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[text() = 'Imperial: °F, mph']"));
        unitFTextImperial.click();

        WebElement unitFTextMetric = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[text() = 'Metric: °C, m/s']"));
        unitFTextMetric.click();

        Thread.sleep(2000);
        WebElement spanTempHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//div[@class = 'current-temp']/span[contains(text(), '°C')]"));

        Thread.sleep(2000);
        String text = spanTempHeader.getText();
        boolean actualResult = text.contains("°C");

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);
        driver.quit();
    }

//    TC_11_08
//    1.  Открыть базовую ссылку
//    2.  Нажать на лого компании
//    3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась
    @Test
    public void testUrlDoesNotChange_WhenReloadingSite() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/";

        driver.get(url);

        Thread.sleep(5000);

        WebElement logo = driver.findElement(By.xpath("//ul[@id = 'first-level-nav']/li/a/img"));
        logo.click();

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);
        driver.quit();
    }

//    TC_11_09
//    1. Открыть базовую ссылку
//    2. В строке поиска в навигационной панели набрать “Rome”
//    3. Нажать клавишу Enter
//    4. Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
//    5. Подтвердить, что в строке поиска на новой странице вписано слово “Rome”
    @Test
    public void testOpenNewUrl_WhenSearchingInNavigationBarRome() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        String city = "Rome";
        String expectedResult = "https://openweathermap.org/find?q=Rome";
        String expectedResult1 = "Rome";

        driver.get(url);

        Thread.sleep(5000);
        WebElement navigationBar = driver.findElement(
                By.xpath("//div[@id = 'desktop-menu']//input[@placeholder = 'Weather in your city']"));
        navigationBar.click();
        navigationBar.sendKeys(city);
        Thread.sleep(1000);
        navigationBar.sendKeys(Keys.ENTER);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        WebElement search_str = driver.findElement(By.id("search_str"));

        String actualResult1 = search_str.getAttribute("value");

        Assert.assertEquals(actualResult1, expectedResult1);

        Thread.sleep(5000);
        driver.quit();
    }

//    TC_11_10
//    1.  Открыть базовую ссылку
//    2.  Нажать на пункт меню API
//    3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок
    @Test
    public void test30_OrangeButtons_WhenOpenMenuApi() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);

        String url = "https://openweathermap.org/";
        int classbtnBlockBlackRound = 29;
        int owBtnRoundBtnOrange = 1;
        int expectedResult = Integer.sum(classbtnBlockBlackRound, owBtnRoundBtnOrange);

        driver.get(url);

        Thread.sleep(5000);
        WebElement apiMenu = driver.findElement(By.xpath("//div[@id = 'desktop-menu']//a[@href = '/api']"));
        apiMenu.click();

        List<WebElement> classOrangeRound = driver.findElements(
                By.xpath("//a[@type = 'button'][@class = 'btn_block black round']"));
        List<WebElement> classBtnOrange = driver.findElements(
                By.xpath("//a[@href = 'https://home.openweathermap.org/subscriptions/unauth_subscribe/onecall_30/base'][@class = 'ow-btn round btn-orange']"));

        int actualResult = Integer.sum(classOrangeRound.size(), classBtnOrange.size());

        Assert.assertEquals(actualResult, expectedResult);

        Thread.sleep(5000);
        driver.quit();
    }





}
