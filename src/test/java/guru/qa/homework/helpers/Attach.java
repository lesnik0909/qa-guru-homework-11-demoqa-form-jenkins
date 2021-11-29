package guru.qa.homework.helpers;

import static org.openqa.selenium.logging.LogType.BROWSER;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Attach {

  @Attachment(value = "{attachName}", type = "text/plain")
  public static String attachAsText(String attachName, String message) {
    return message;
  }

  @Attachment(value = "Page source", type = "text/plain")
  public static byte[] pageSource() {
    return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
  }

  @Attachment(value = "{attachName}", type = "image/png")
  public static byte[] screenshotAs(String attachName) {
    return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
  }

  public static void browserConsoleLogs() {
    attachAsText(
        "Browser console logs",
        String.join("\n", Selenide.getWebDriverLogs(BROWSER))
    );
  }

  @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
  public static String addVideo() {
    return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
        + getVideoUrl(getSessionId())
        + "' type='video/mp4'></video></body></html>";
  }

  private static URL getVideoUrl(String sessionId) {
    String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";
    try {
      return new URL(videoUrl);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static String getSessionId() {
    return ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
  }

}
