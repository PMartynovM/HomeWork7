package Work7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestBooking {
    static String bookingUrl = "https://restful-booker.herokuapp.com/booking/";

    public static Response createBooking(String body) {

        return RestAssured.given()
                .baseUri(bookingUrl)
                .body(body)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post(bookingUrl)
                .then()
                .extract()
                .response();
    }
}

