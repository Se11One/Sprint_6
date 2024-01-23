import com.example.Cat;
import com.example.Feline;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CatTest {

    @Test
    public void testGetSound() {
        Feline mockFeline = mock(Feline.class);
        Cat cat = new Cat(mockFeline);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        Feline mockFeline = mock(Feline.class);
        when(mockFeline.eatMeat()).thenReturn(List.of("Мясо"));

        Cat cat = new Cat(mockFeline);
        List<String> food = cat.getFood();

        assertNotNull(food);
        assertFalse(food.isEmpty());
        assertEquals("Мясо", food.get(0));
    }
}