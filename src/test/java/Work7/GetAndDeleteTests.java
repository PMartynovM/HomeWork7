package Work7;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetAndDeleteTests {

    static String bookingIdNegative = "100000";

    @Test
    public void GetBookingNegativeTest() {

        Response responsePositive = RestGetBooking.getBookingId(bookingIdNegative);
        Assert.assertEquals(404, responsePositive.statusCode());
        System.out.println("Booking ID: " + bookingIdNegative + " NOT FOUND");
    }

    @Test
    public void deleteBookingTest() {

        String morganId = RestBooking.createBooking(BookingTest.morganBody).jsonPath().getString("bookingid");
        String token = RestToken.createToken(TokenTests.bodyToken).jsonPath().getString("token");
        RestDelete.bookingDelete(morganId, token);
        Response responsePositive = RestGetBooking.getBookingId(morganId);
        Assert.assertEquals(404, responsePositive.statusCode());

        RestDelete.bookingDelete(bookingIdNegative, token);
        Response responseNegative = RestGetBooking.getBookingId(morganId);
        Assert.assertEquals(404, responsePositive.statusCode());
    }
}