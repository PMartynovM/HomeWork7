package Work7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestUpdateBooking {
    static String bookingUrl = "https://restful-booker.herokuapp.com/booking/";

    public static Response bookingUpdate(String body, String id, String token) {

        return RestAssured.given()
                .baseUri(bookingUrl)
                .body(body)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Cookie", "token=" + token)
                .put(bookingUrl + id)
                .then()
                .log()
                .body()
                .extract()
                .response();
    }
}

