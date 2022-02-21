import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)//позволяет выполнить BeforAll один раз на весь класс без static
class CalculatorTest {

    Calculator cal=null;
 // ICalculator iCalculator= new ICalculator() { // можно сделать используя mockito
 //     @Override
 //     public int add(int a, int b) {
 //         return a+b;
 //     }
 // };


    ICalculator iCalculator=mock(ICalculator.class);//на освнове  icalculator создаем подделку этого интерфейся

    @BeforeAll
    public void setUp(){
    cal= new Calculator(iCalculator);
    }


    @Test
    void testMult() {
        when(iCalculator.add(2, 3)).thenReturn(5);//"переопределяем функцию" пишем что она должна возвращать при определенных вводных данных
        assertEquals(10, cal.mult(2,3));
        verify(iCalculator).add(2,3);// проверка, чтобы узнать обращались ли мы к функции через интерфейс
    }
}