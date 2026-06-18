package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);
        assertEquals("Ошибка: булка из метода setBuns() должно совпадать с переданным мок-объектом mockBun.",mockBun, burger.bun);
    }

    @Test
    public void shouldIncreaseIngredientListSizeAfterAddingIngredient() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Ошибка: количество ингредиентов после добавления mockIngredient1 должно быть 1.",
                1, burger.ingredients.size());
    }

    @Test
    public void shouldAddCorrectIngredientToList() {
        burger.addIngredient(mockIngredient1);
        assertEquals("Ошибка: добавленный ингредиент должен совпадать с mockIngredient1.",
                mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(mockIngredient1);
        burger.removeIngredient(0);
        assertTrue("Ошибка: список ингредиентов должен быть пустым после удаления ингредиента.", burger.ingredients.isEmpty());
    }

    @Test
    public void shouldMoveIngredientToNewPosition_FirstBecomesSecond() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ошибка: после перемещения mockIngredient1 должен быть на позиции 1.",
                mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void shouldMoveIngredientToNewPosition_SecondBecomesFirst() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Ошибка: после перемещения mockIngredient2 должен быть на позиции 0.",
                mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        when(mockBun.getPrice()).thenReturn(100f);
        when(mockIngredient1.getPrice()).thenReturn(50f);
        when(mockIngredient2.getPrice()).thenReturn(30f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        // Цена за две булки (100 * 2) + два ингредиента (50 + 30)
        float expectedPrice = 100 * 2 + 50 + 30;
        // delta - допустимая погрешность для сравнения чисел с плавающей точкой
        assertEquals("Ошибка: итоговая цена не равна 280 (100 * 2 + 50 + 30).", expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void receiptShouldContainBunName() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getPrice()).thenReturn(100f);

        String receipt = burger.getReceipt();
        assertTrue("Ошибка: чек не содержит названия булки 'black bun'.", receipt.contains("black bun"));
    }

    @Test
    public void receiptShouldContainFormattedIngredientLine() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getPrice()).thenReturn(100f);

        String receipt = burger.getReceipt();
        assertTrue("Ошибка: чек не содержит корректного описания ингредиента 'sauce hot sauce'.",
                receipt.contains("sauce hot sauce"));
    }

    @Test
    public void receiptShouldContainTotalPrice() {
        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        when(mockIngredient1.getName()).thenReturn("hot sauce");
        when(mockIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient1.getPrice()).thenReturn(100f);

        String receipt = burger.getReceipt();
        assertTrue("Ошибка: чек не содержит итоговой цены 'Price: 300.000000'.",
                receipt.contains("Price: 300.000000"));
    }
}