package guru.qa.homework.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.homework.configs.ProjectConfig;
import guru.qa.homework.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

  public final static ProjectConfig cfg = ConfigFactory.create(ProjectConfig.class);

  @BeforeAll
  public static void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);

    Configuration.browserSize = "1920x1080";
    Configuration.remote = String.format("https://%s:%s@%s/wd/hub/", cfg.login(), cfg.password(),
        System.getProperty("selenoidUrl", cfg.selenideUrl()));
    Configuration.browserCapabilities = capabilities;
  }

  @AfterEach
  public void tearDown() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }

}
