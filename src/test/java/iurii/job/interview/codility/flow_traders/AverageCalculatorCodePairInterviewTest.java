package iurii.job.interview.codility.flow_traders;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Complete class function to supply new price and return average of all the prices (with supplied one)
 * 1) implement the method (we can not store all the prices in the memory)
 * 2) implement method to calculate average only for last "precision" prices
 * 3) make code thread safe
 */
public class AverageCalculatorCodePairInterviewTest {

    // one of the issues is rounding
    // here is the solution for rounding with DecimalFormat
    private final DecimalFormat df = new DecimalFormat("#.###");

    {
        df.setRoundingMode(RoundingMode.HALF_UP);
        String stringValue = df.format(1.23451);
        double roundedValue = Double.parseDouble(stringValue);
        System.out.println(stringValue);
        System.out.println(roundedValue);
        // or
        double rounded3Digits = Math.round(1.23451 * 1000) / 1000;
        System.out.println(rounded3Digits);
        // or
        System.out.println(new BigDecimal(String.valueOf(1.2347)).setScale(3, BigDecimal.ROUND_HALF_UP));
    }

    // last average value
    private double average = 0;
    // count
    private long count = 0;

    // average with new value
    public double supplyNextPrice(long price) {
        average = (average * count + price) / (++count);
        return average;
    }

    // for precision
    // number of last prices
    private final int precision = 20;
    private final List<Long> lastPrices = new ArrayList<>(precision);
    private int index = 0;

    public double supplyNextPriceWithPrecision(long price) {
        lastPrices.set(index++ % precision, price);
        return lastPrices.parallelStream().mapToLong(i -> i).average().orElse(0.0);
    }

    private final Object lock = new Object();

    // ! synchronized on private final object is better than synchronized on the instance of class,
    // cause someone can synchronize on this object as well
    public double supplyNextPriceWithPrecisionThreadSafe1(long price) {
        synchronized (lock) {
            lastPrices.set(index++ % precision, price);
            return lastPrices.parallelStream().mapToLong(i -> i).average().orElse(0.0);
        }
    }

    private CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
    private AtomicLongArray atomicLongArray = new AtomicLongArray(20);
    private LinkedBlockingDeque<Long> deque = new LinkedBlockingDeque<>(20);

    public double supplyNextPriceWithPrecisionThreadSafe2(long price) {
        return 0;
    }

    @Test
    public void test() {
        AverageCalculatorCodePairInterviewTest test = new AverageCalculatorCodePairInterviewTest();
    }

}
