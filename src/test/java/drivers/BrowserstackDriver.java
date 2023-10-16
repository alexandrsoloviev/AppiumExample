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

        mutableCapabilities.setCapability("browserstack.user", USER);
        mutableCapabilities.setCapability("browserstack.key", KEY);

        mutableCapabilities.setCapability("app", APP);

        mutableCapabilities.setCapability("device", DEVICE);
        mutableCapabilities.setCapability("os_version", OS_VERSION);

        mutableCapabilities.setCapability("project", PROJECT);
        mutableCapabilities.setCapability("build", BUILD);
        mutableCapabilities.setCapability("name", NAME);


        try {
            return new RemoteWebDriver(
                    new URL(REMOTE_URL), mutableCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


}