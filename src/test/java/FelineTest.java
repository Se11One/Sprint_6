import com.example.Feline;
import com.example.Predator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();

        assertNotNull(food);
        assertFalse(food.isEmpty());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int kittensCount = 1;
        int kittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, kittens);
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        int kittensCount = 3;
        int kittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, kittens);
    }

    @Test
    public void testEatMeatMocked() throws Exception {
        Predator mockPredator = mock(Feline.class);
        when(mockPredator.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = mockPredator.eatMeat();

        assertNotNull(food);
        assertFalse(food.isEmpty());
        assertTrue(food.contains("Животные"));
        assertTrue(food.contains("Птицы"));
        assertTrue(food.contains("Рыба"));
    }

    @Test
    public void testGetKittensMocked() {
        Feline mockFeline = mock(Feline.class);
        int kittensCount = 5; // Replace this line with your variable
        when(mockFeline.getKittens()).thenReturn(kittensCount);
        int kittens = mockFeline.getKittens();

        assertEquals(kittensCount, kittens);
    }
}