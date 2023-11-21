package Work7;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class UpdateBookingTest {

    public static String morganBodyUpdate = "{\n" +
            "    \"firstname\" : \"Dexter\",\n" +
            "    \"lastname\" : \"Morgan\",\n" +
            "    \"totalprice\" : 10,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-11-29\",\n" +
            "        \"checkout\" : \"2023-11-30\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"knife\"\n" +
            "}";



    @Test
    public void updateBookingAngGet() {
//        Assett.assertEquals
        String morganId = RestBooking.createBooking(BookingTest.morganBody).jsonPath().getString("bookingid");
        String token = RestToken.createToken(TokenTests.bodyToken).jsonPath().getString("token");
        RestUpdateBooking.bookingUpdate(morganBodyUpdate, morganId, token);
        Response responsePositive = RestGetBooking.getBookingId(morganId);
        Assert.assertEquals(200, responsePositive.statusCode());

    }
}