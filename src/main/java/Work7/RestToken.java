package Work7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestToken {

    static String baseUrl = "https://restful-booker.herokuapp.com/auth";

    public static Response createToken(String bodyToken) {

        return RestAssured.given()
                .baseUri(baseUrl)
                .body(bodyToken)
                .log()
                .body()
                .contentType(ContentType.JSON)
                .post(baseUrl)
                .then()
                .log()
                .body()
                .extract()
                .response();
    }
}