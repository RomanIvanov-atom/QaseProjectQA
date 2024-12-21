package tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.PropertyReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected LoginPage loginPage;
    protected ProjectsPage projectsPage;
    protected ProjectPage projectPage;
    protected CreateTestCaseModal createTestCaseModal;
    protected ProjectSettingsPage projectSettingsPage;
    protected String login = PropertyReader.getProperty("username");
    protected String password = PropertyReader.getProperty("password");

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");

        // Указываем Selenide использовать наш WebDriver
        WebDriver driver = new ChromeDriver(options);
        // Настраиваем браузер после запуска
        driver.manage().window().maximize(); // Программно разворачиваем окно на полный экран
        WebDriverRunner.setWebDriver(driver);

        // Остальные конфигурации Selenide
        Configuration.headless = false;
        Configuration.clickViaJs = true;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://app.qase.io/";

        loginPage = new LoginPage();
        projectsPage = new ProjectsPage();
        projectPage = new ProjectPage();
        createTestCaseModal = new CreateTestCaseModal();
        projectSettingsPage = new ProjectSettingsPage();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterMethod(alwaysRun = true)
    public void close() {
        closeWebDriver();
    }
}
