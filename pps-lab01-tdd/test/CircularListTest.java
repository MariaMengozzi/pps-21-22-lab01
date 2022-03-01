import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;

    @BeforeEach
    public void setup(){
        this.circularList = new SimpleCircularList();
    }

    @Test
    public void testEmptyList(){
        assertEquals(true, this.circularList.isEmpty());
    }

}
