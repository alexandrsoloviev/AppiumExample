package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
     public static RemoteWebDriver driver;
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", "bsuser_OxDSjP");
        mutableCapabilities.setCapability("browserstack.key", "81QEMp7pBXG3d9UrHcy4");

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://8a316e12dc2c8963147236624dccb7fa9045b62b");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", "Google Pixel 3");
        mutableCapabilities.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
      driver = new RemoteWebDriver(getBrowserstackUrl(),mutableCapabilities);
      return driver;
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL("https://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}