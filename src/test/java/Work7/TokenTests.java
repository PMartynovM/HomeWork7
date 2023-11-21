package Work7;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class TokenTests {
    static String bodyTokenNegative = "{\n" +
            "    \"username\" : \"adminssss\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    static String bodyToken = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    @Test
    public void negativeToken() {

        Response responsePositive = RestToken.createToken(bodyToken);
        Assert.assertEquals(200, responsePositive.statusCode());
        System.out.println(responsePositive.jsonPath().getString("token"));

        Response responseNegative = RestToken.createToken(bodyTokenNegative);
        Assert.assertEquals(200, responseNegative.statusCode());
        System.out.println(responseNegative.jsonPath().getString("reason"));
    }

}
