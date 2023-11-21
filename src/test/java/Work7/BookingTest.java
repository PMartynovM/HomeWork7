package Work7;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class BookingTest {
    public static String morganBody = "{\n" +
            "    \"firstname\" : \"Dexter\",\n" +
            "    \"lastname\" : \"Morgan\",\n" +
            "    \"totalprice\" : 1000,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-11-20\",\n" +
            "        \"checkout\" : \"2023-11-28\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast + knife\"\n" +
            "}";

    public static String morganBodyNegative = "{\n" +
            "    \"firstname\" : \"Dexter\",\n" +
            "    \"lastname\" : \"Morgan\",\n" +
            "    \"totalprice\" : &&&,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2023-11-20\",\n" +
            "        \"checkout\" : \"2023-11-28\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast + knife\"\n" +
            "}";

    @Test
    public void createAndGetBooking(){

        String bookingId = RestBooking.createBooking(morganBody).jsonPath().getString("bookingid");
        Response responsePositive = RestGetBooking.getBookingId(bookingId);
        Assert.assertEquals(200, responsePositive.statusCode());
        System.out.println("Booking ID: " + bookingId);

        Response responseNegative = RestBooking.createBooking(morganBodyNegative);
        Assert.assertEquals(400, responseNegative.statusCode());
        System.out.println(responseNegative);
    }
}

