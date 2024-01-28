import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionDoesHaveManeTest {

    private final String sex;
    private final boolean expectedHasMane;
    private final Feline feline;

    public LionDoesHaveManeTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.feline = mock(Feline.class);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"InvalidSex", false}
        });
    }

    @Test
    public void testDoesHaveMane() {
        try {
            Lion lion = new Lion(sex, feline);
            assertEquals(expectedHasMane, lion.doesHaveMane());
        } catch (Exception e) {
            if ("Используйте допустимые значения пола животного - самей или самка".equals(e.getMessage())) {
                assertFalse(expectedHasMane);
            }
        }
    }
}