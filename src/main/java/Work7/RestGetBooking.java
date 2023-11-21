package Work7;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestGetBooking {
    public static Response getBookingId(String id) {

        return RestAssured.given()
                .baseUri(Helper.bookingUrl)
                .get(Helper.bookingUrl + id)
                .then()
                .log()
                .status()
                .extract()
                .response();

    }
}
