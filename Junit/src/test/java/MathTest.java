import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.*;

class MathTest {
   // @BeforeAll//аннотация для запуска чего-либо перед классом
   //@AfterAll --- что-то происходит после всего класса
   // @AfterEach ---что-то происходит после каждой функции

    Math m =null;

    @BeforeEach//функция будет вызываться перед каждой функцией(теперь можно не прописывать "Math m = new Math();" в каждой из них)
    public void setUp(){
        m= new Math();
    }



//анотации///////////////////////////////
    @Disabled//игнорирование функции
    @Test
    @DisplayName("функция для суммирования")//переименнование функции
    public void summ() {
        Math m = new Math();
        int res = m.summ(5,7);
        assertAll(  //объединение функций 
                () -> assertEquals(res,12, "сложение не работает"),
                () -> assertNotEquals(res, 10)
        );
     //   assertEquals(res,12, "сложение не работает");
     //           assertNotEquals(res, 10);
    }

    @Test
    @RepeatedTest(3)//указывание сколько раз прогоняем функцию
    @Tag("array")//добавить тэг к фукции
    public void testSetArrey(){
        Math a = new Math();
        int[] arr = a.setArray(4,6,8,10,0);
        int[] exprcted = {4,6,8,10,0};
        assertArrayEquals(exprcted,arr);
    }

@Test
    public void testDevide(){
    Math a = new Math();
    assertEquals(5, a.divide(10,2));
    assertThrows(ArithmeticException.class, ()-> a.divide(5,0));//проверка на выбрасывание ошибки ArithmeticException
}

@Nested//наследование у тестов
@DisplayName("простая математика")//переименнование функции
    class SimpleMath{
    @Test
    @RepeatedTest(3)//указывание сколько раз прогоняем функцию
    @Tag("array")//добавить тэг к фукции
    public void testSetArrey(){
        Math a = new Math();
        int[] arr = a.setArray(4,6,8,10,0);
        int[] exprcted = {4,6,8,10,0};
        assertArrayEquals(exprcted,arr);
    }

    @Test
    public void testDevide(){
        Math a = new Math();
        assertEquals(5, a.divide(10,2));
        assertThrows(ArithmeticException.class, ()-> a.divide(5,0));//проверка на выбрасывание ошибки ArithmeticException
    }
}

}