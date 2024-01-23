import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Хищник"));

        List<String> food = mockFeline.eatMeat();

        assertNotNull(food);
        assertFalse(food.isEmpty());
        assertTrue(food.contains("Хищник"));
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int kittens = feline.getKittens();

        assertEquals(1, kittens);
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(3);

        assertEquals(3, kittens);
    }

    @Test
    public void testEatMeatMocked() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Хищник"));

        List<String> food = mockFeline.eatMeat();

        assertNotNull(food);
        assertFalse(food.isEmpty());
        assertTrue(food.contains("Хищник"));
    }

    @Test
    public void testGetKittensMocked() {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(5);

        int kittens = mockFeline.getKittens();

        assertEquals(5, kittens);
    }
}