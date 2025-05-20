package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valueOfShouldReturnSauce() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfShouldReturnFilling() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    // Дополнительно проверяем исключение IllegalArgumentException для несуществующего IngredientType
    @Test(expected = IllegalArgumentException.class)
    public void valueOfWithInvalidValueShouldThrowException() {
        IngredientType.valueOf("SIDE_DISH");
    }
}