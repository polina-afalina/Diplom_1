package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    private Bun bun;

    // Инициализируем одинаковый объект и проверяем его методы в отдельных тестах
    @Before
    public void setUp() {
        bun = new Bun("black bun", 200);
    }

    @Test
    public void testGetName() {
        assertEquals("Ошибка: булка должна называться 'black bun'.","black bun", bun.getName());
    }

    // delta - допустимая погрешность для сравнения чисел с плавающей точкой
    @Test
    public void testGetPrice() {
        assertEquals("Ошибка: цена булки не равна 200.",200, bun.getPrice(), 0.001f);
    }
}