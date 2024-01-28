import com.example.Feline;
import com.example.Lion;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    public void testGetKittens() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getKittens()).thenReturn(2);

        Lion lion = new Lion("Самец", mockFeline);
        int kittens = lion.getKittens();

        assertEquals(2, kittens);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        Lion lion = new Lion("Самец", mockFeline);
        List<String> food = lion.getFood();

        assertNotNull(food);
        assertFalse(food.isEmpty());
        assertEquals("Мясо", food.get(0));
    }
}