package Task_02;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTask02 {

    @Test
    void testPositiveAnswer() throws NotFoundAnswerException {
        //given
        MathService mathService = new MathService();
        //then
        assertEquals("Answer{first=2.0, second=-16.0}",mathService.getAnswer(-1,7,8).toString());
    }
    @Test
    void testDiscriminantPositive() {
        //given
        MathService mathService = new MathService();
        //then
        assertEquals(81,mathService.getD(-1,7,8));
    }
    @Test
    void testDiscriminantZero()  {
        //given
        MathService mathService = new MathService();
        //then
        assertEquals(0,mathService.getD(1,0,0));
    }
    @Test
    void testDiscriminantNegative(){
        //given
        MathService mathService = new MathService();
        //then
        assertEquals(-24, mathService.getD(1,0,6));
    }

    @ParameterizedTest
    @CsvSource({"1,1,1","12,4,5","4,6,8"})
    void testParameterizedNegative(int a,int b, int c)  {
        //given
        MathService mathService = new MathService();
        //then
        assertThrows(NotFoundAnswerException.class, () -> {
           mathService.getAnswer(a,b,c);
        }, "Корни не могут быть найдены");
    }
}
