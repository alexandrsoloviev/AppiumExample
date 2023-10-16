package tests;


import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.xpath;

public class WDSearchTest extends TestBase {


    @Test
    @Owner("alexandrsoloviev")
    @DisplayName("Wildberries search test")
    void searchTest() {

        step("Open app", () -> {
            $$(className("android.widget.TextView"))
                    .findBy(text("Беларусь")).click();
            $$(className("android.widget.TextView"))
                    .findBy(text("Пропустить ›")).click();
        });

        step("Click to search input", () -> {
            $(xpath("//android.widget.TextView[@text='Найти на Wildberries']")).click();
        });

        step("Input value and click search", () -> {
            $(className("android.widget.EditText")).sendKeys("Чарльз Петцольд");
            $x("//android.widget.FrameLayout[@resource-id='com.wildberries.ru:id/fragmentTabContainer']/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View").click();


        });

        step("Validate result", () -> {
            $$(id("com.wildberries.ru:id/itemLayout")).shouldBe(sizeGreaterThan(0));
        });

    }
}
