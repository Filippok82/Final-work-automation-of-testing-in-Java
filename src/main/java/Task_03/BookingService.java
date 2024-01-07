package Task_03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class BookingService {
    private static final Logger logger
            = LoggerFactory.getLogger(BookingService.class);

    //запись
    public boolean book(String userId, LocalDateTime from, LocalDateTime to) throws CantBookException {
        logger.info("Вызвана функция записи со временем {}, {}", from,to);
        if(checkTimeInBD(from, to)) {
            logger.info("Запись успешно осуществлена");
            return createBook(userId,from, to);

        }
        logger.error("Время занято");
        throw new CantBookException();
    }
    //метод занятости слота времени в СУБД
    public boolean checkTimeInBD(LocalDateTime from, LocalDateTime to) {
        return false;
    }
    // метод бронирования
    public boolean createBook(String userId, LocalDateTime from, LocalDateTime to) {
        return false;
    }
}
