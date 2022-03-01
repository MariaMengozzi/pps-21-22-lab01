import lab01.tdd.CircularList;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void testAdd(){
        this.circularList.add(5);
        this.circularList.add(10);
        assertEquals(2, this.circularList.size());
    }

    @Test
    public void testNextOneElementInList(){
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(5,5,5));
        List<Integer> result = new ArrayList<>();
        this.circularList.add(5);
        for (int i=0; i<3; i++){
            result.add(this.circularList.next().get());
        }
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextOptionalEmpty(){
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testNextMoreElementInList(){
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(5,10,15,5));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expectedResult.size(); i++) {
            this.circularList.add(expectedResult.get(i));
        }
        for (Integer element: expectedResult) {
            result.add(this.circularList.next().get());
        }
        assertEquals(expectedResult, result);
    }

}
