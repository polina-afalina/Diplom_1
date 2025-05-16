package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("Ошибка: булка должна называться \"black bun\".","black bun", bun.getName());
    }

    // delta - допустимая погрешность для сравнения чисел с плавающей точкой
    @Test
    public void testGetPrice() {
        Bun bun = new Bun("white bun", 200);
        assertEquals("Ошибка: цена булки не равна 200.",200, bun.getPrice(), 0.001f);
    }
}