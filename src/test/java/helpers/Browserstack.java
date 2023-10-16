package helpers;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    // curl -u "qagurumobile_piB8or:dqCgQsyscHYt4iEy2vUi" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic("bsuser_OxDSjP", "81QEMp7pBXG3d9UrHcy4")
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}