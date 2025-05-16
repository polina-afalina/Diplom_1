package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                { IngredientType.SAUCE, "hot sauce", 100 },
                { IngredientType.FILLING, "cutlet", 150 }
        });
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка: метод getType() вернул неверный тип ингредиента", type, ingredient.getType());

    }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка: метод getName() вернул неверное имя ингредиента", name, ingredient.getName());

    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Ошибка: метод getPrice() вернул неверную цену ингредиента", price, ingredient.getPrice(), 0.001f);

    }
}
