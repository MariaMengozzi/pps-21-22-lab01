import lab01.tdd.CircularList;
import lab01.tdd.EvenStrategy;
import lab01.tdd.MultipleOfStrategy;
import lab01.tdd.SimpleCircularList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        this.addElements();
        for (Integer element: expectedResult) {
            result.add(this.circularList.next().get());
        }
        assertEquals(expectedResult, result);
    }

    @Test
    public void testReset(){
        this.addElements();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(5, this.circularList.next().get());
    }

    @Test
    public void testPreviousEmptyList(){
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test
    public void testPreviousOneElementInList(){
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(5,5,5));
        List<Integer> result = new ArrayList<>();
        this.circularList.add(5);
        for (int i=0; i<3; i++){
            result.add(this.circularList.previous().get());
        }
        assertEquals(expectedResult, result);
    }

    @Test
    public void testPreviousMoreElementInList(){
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(5, 15, 10, 5));
        List<Integer> result = new ArrayList<>();
        this.addElements();
        for (Integer element: expectedResult) {
            result.add(this.circularList.previous().get());
        }
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextAndPrevious(){
        List<Integer> expectedResult = new ArrayList<>(Arrays.asList(5,10,5,10));
        List<Integer> result = new ArrayList<>();
        this.addElements();
        result.add(this.circularList.next().get());
        result.add(this.circularList.previous().get());
        result.add(this.circularList.next().get());
        result.add(this.circularList.next().get());
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextEvenStrategy(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.empty(),Optional.of(10),Optional.empty(), Optional.empty()));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        for (Optional element: expectedResult) {
            result.add(this.circularList.next(new EvenStrategy()));
        }

        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextMultStrategy(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5),Optional.of(10),Optional.of(15), Optional.empty()));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        this.circularList.add(4);
        for (Optional element: expectedResult) {
            result.add(this.circularList.next(new MultipleOfStrategy(5)));
        }

        assertEquals(expectedResult, result);
    }

    private void addElements(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.add(15);
    }


}
