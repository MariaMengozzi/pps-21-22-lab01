import lab01.tdd.*;
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
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5), Optional.of(5), Optional.of(5)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.circularList.add(5);
        expectedResult.forEach(e -> result.add(this.circularList.next()));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextOptionalEmpty(){
        assertEquals(Optional.empty(), this.circularList.next());
    }

    @Test
    public void testNextMoreElementInList(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5), Optional.of(10), Optional.of(15), Optional.of(5)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        expectedResult.forEach(e -> result.add(this.circularList.next()));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testReset(){
        this.addElements();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(Optional.of(5), this.circularList.next());
    }

    @Test
    public void testPreviousEmptyList(){
        assertEquals(Optional.empty(), this.circularList.previous());
    }

    @Test
    public void testPreviousOneElementInList(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5), Optional.of(5), Optional.of(5)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.circularList.add(5);
        expectedResult.forEach(x -> result.add(this.circularList.previous()));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testPreviousMoreElementInList(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(15), Optional.of(10), Optional.of(5), Optional.of(15)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        expectedResult.forEach(x-> result.add(this.circularList.previous()));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextAndPrevious(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5), Optional.of(5), Optional.of(5), Optional.of(10)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        result.add(this.circularList.next());
        result.add(this.circularList.previous());
        result.add(this.circularList.next());
        result.add(this.circularList.next());
        assertEquals(expectedResult, result);
    }

    //Strategy pattern tests
    @Test
    public void testNextEvenStrategy(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(10)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        expectedResult.forEach(x -> result.add(this.circularList.next(new EvenStrategy())));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextMultipleOfStrategy(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5),Optional.of(10),Optional.of(15)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        this.circularList.add(4);
        expectedResult.forEach(x -> result.add(this.circularList.next(new MultipleOfStrategy(5))));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextEqualsStrategy(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5), Optional.of(5)));
        List<Optional<Integer>> result = new ArrayList<>();
        this.addElements();
        expectedResult.forEach(x -> result.add(this.circularList.next(new EqualsStrategy(5))));
        assertEquals(expectedResult, result);
    }

    //abstract factory pattern tests
    @Test
    public void testNextEvenStrategyWithAbstractFactory(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(10)));
        List<Optional<Integer>> result = new ArrayList<>();
        AbstractFactory strategyFactory = new Strategies();
        this.addElements();
        expectedResult.forEach(x-> result.add(this.circularList.next(strategyFactory.getStrategy(StrategyTypes.EVEN_STRATEGY, null))));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextMultipleOfStrategyWithAbstractFactory(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5),Optional.of(10),Optional.of(15)));
        List<Optional<Integer>> result = new ArrayList<>();
        AbstractFactory strategyFactory = new Strategies();
        this.addElements();
        this.circularList.add(4);
        expectedResult.forEach(x-> result.add(this.circularList.next(strategyFactory.getStrategy(StrategyTypes.MULTIPLE_OF_STRATEGY, 5))));
        assertEquals(expectedResult, result);
    }

    @Test
    public void testNextEqualsStrategyWithAbstractFactory(){
        List<Optional<Integer>> expectedResult = new ArrayList<>(Arrays.asList(Optional.of(5), Optional.of(5)));
        List<Optional<Integer>> result = new ArrayList<>();
        AbstractFactory strategyFactory = new Strategies();
        this.addElements();
        expectedResult.forEach(x-> result.add(this.circularList.next(strategyFactory.getStrategy(StrategyTypes.EQUAL_STRATEGY, 5))));
        assertEquals(expectedResult, result);
    }

    private void addElements(){
        this.circularList.add(5);
        this.circularList.add(10);
        this.circularList.add(15);
    }


}
