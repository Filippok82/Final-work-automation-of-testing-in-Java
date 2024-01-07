package Task_03;

import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws CantBookException {

        LocalDateTime from = LocalDateTime.of(2019, Month.MAY, 15, 12, 15, 0);
        LocalDateTime to = LocalDateTime.of(2019, Month.MAY, 15, 13, 15, 0);
        BookingService bookingService = new BookingService();
        bookingService.checkTimeInBD(from,to);
        bookingService.book("001",from,to);

    }
}
