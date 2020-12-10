package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class AsIntStreamTest {

    private IntStream intStream, intStreamEmpty;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3}, emptyArr = {};
        intStream = AsIntStream.of(intArr);
        intStreamEmpty = AsIntStream.of(emptyArr);
    }



    @Test
    public void testStreamAverage() {
        System.out.println("average");
        double expResult = 1.0;
        double result = intStream.average();
        assertEquals(expResult, result, 0.00001);
    }

    @Test
    public void testStreamCount() {
        System.out.println("count");
        int expResult = 5;
        long result = intStream.count();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamSum() {
        System.out.println("sum");
        int expResult = 5;
        long result = intStream.sum();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMax() {
        System.out.println("max");
        int expResult = 3;
        long result = intStream.max();
        assertEquals(expResult, result);
    }

    @Test
    public void testStreamMin() {
        System.out.println("min");
        int expResult = -1;
        long result = intStream.min();
        assertEquals(expResult, result);
    }



    
    @Test (expected = IllegalArgumentException.class)
    public void testStreamAverageEmpty() {
        intStreamEmpty.average();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testStreamCountEmpty() {
        intStreamEmpty.count();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testStreamSumEmpty() {
        intStreamEmpty.sum();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testStreamMaxEmpty() {
        intStreamEmpty.max();
    }

    @Test (expected = IllegalArgumentException.class)
    public void testStreamMinEmpty() {
        intStreamEmpty.min();
    }
}
