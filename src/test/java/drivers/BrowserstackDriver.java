package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigReader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;


public class BrowserstackDriver implements WebDriverProvider {

    private static final String USER = ConfigReader.browserStackConfig.user();
    private static final String KEY = ConfigReader.browserStackConfig.key();
    private static final String APP = ConfigReader.browserStackConfig.app();
    private static final String DEVICE = ConfigReader.browserStackConfig.device();
    private static final String OS_VERSION = ConfigReader.browserStackConfig.os_version();
    private static final String PROJECT = ConfigReader.browserStackConfig.project();
    private static final String BUILD = ConfigReader.browserStackConfig.build();
    private static final String NAME = ConfigReader.browserStackConfig.name();
    private static final String REMOTE_URL = ConfigReader.browserStackConfig.remoteUrl();

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", USER);
        mutableCapabilities.setCapability("browserstack.key", KEY);

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", APP);

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", DEVICE);
        mutableCapabilities.setCapability("os_version", OS_VERSION);

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", PROJECT);
        mutableCapabilities.setCapability("build", BUILD);
        mutableCapabilities.setCapability("name", NAME);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(REMOTE_URL), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}