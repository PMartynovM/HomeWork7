package Work7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestDelete {

    public static void bookingDelete(String id, String token) {
        RestAssured.given()
                .baseUri(Helper.bookingUrl)
                .contentType(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .delete(Helper.bookingUrl + id)
                .then()
                .log()
                .body()
                .extract()
                .response();
    }
}

