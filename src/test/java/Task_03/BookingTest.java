package Task_03;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingTest {

    private static final Logger logger
            = LoggerFactory.getLogger(BookingTest.class);

    @Mock
    private BookingService bookingService;

    @Test
    void bookValidTimeTrue() throws CantBookException {

        LocalDateTime from = LocalDateTime.of(2019, Month.MAY, 15, 12, 15, 0);
        LocalDateTime to = LocalDateTime.of(2019, Month.MAY, 15, 13, 15, 0);
        logger.info("Запущен тест проверки валидного времени {} {} для записи", from, to);
        //given
        logger.debug("Мокирование поведения для метода book()");
        when(bookingService.book("001", from, to)).thenReturn(true);
        //when
        boolean result = bookingService.book("001", from, to);
        //then
        logger.info("Тест успешно пройден");
        assertTrue(result);
        logger.info("Проверка что произошел вызов метода с определенными параметрами");
        verify(bookingService).book("001", from, to);


    }

    @Test
    void bookInvalidTimeCantBookExceptionThrown() throws CantBookException {

        LocalDateTime from = LocalDateTime.of(2019, Month.MAY, 15, 12, 15, 0);
        LocalDateTime to = LocalDateTime.of(2019, Month.MAY, 15, 13, 15, 0);
        logger.info("Запущен тест проверки невалидного времени {} {} для записи", from, to);

        //given
        logger.debug("Мокирование поведения для метода book()");
        Mockito.doThrow(CantBookException.class).when(bookingService).book("001", from, to);
        //then
        logger.info("Тест успешно пройден");
        assertThrows(CantBookException.class, () -> {
            bookingService.book("001", from, to);
        }, "Время занято");

    }

}
