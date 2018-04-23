package iurii.job.interview.codility.flow_traders;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import static org.assertj.core.api.Assertions.assertThat;

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
        // or Math.round
        double rounded3Digits = Math.round(1.23451 * 1000) / 1000;
        System.out.println(rounded3Digits);
        // or BigDecimal
        System.out.println(new BigDecimal(String.valueOf(1.2347)).setScale(3, BigDecimal.ROUND_HALF_UP));
    }

    // last average value
    private double average = 0;
    // count
    private long count = 0;

    // average with new value
    private double supplyNextPrice(long price) {
        average = (average * count + price) / (++count);
        return average;
    }

    // for precision
    // number of last prices
    private final int precision = 20;
    private final List<Long> lastPrices = new ArrayList<>(precision);
    private int index = 0;

    private double supplyNextPriceWithPrecision(long price) {
        if (lastPrices.size() < precision) {
            lastPrices.add(price);
        } else {
            lastPrices.set(index++ % precision, price);
        }
        index = (index + 1) % precision;
        return lastPrices.parallelStream().mapToLong(i -> i).average().orElse(0.0);
    }

    private final Object lock = new Object();

    // ! synchronized on private final object is better than synchronized on the instance of class,
    // cause someone else can synchronize on this object as well externally

    // ArrayList with recalculation
    private double supplyNextPriceWithPrecisionThreadSafe1(long price) {
        synchronized (lock) {
            if (lastPrices.size() < precision) {
                lastPrices.add(price);
            } else {
                lastPrices.set(index++ % precision, price);
            }
            index = (index + 1) % precision;
            return lastPrices.parallelStream().mapToLong(i -> i).average().orElse(0.0);
        }
    }

    private final ArrayDeque<Long> arrayDeque = new ArrayDeque<>();
    private long sum = 0;

    // Deque without re-calculation
    private double supplyNextPriceWithPrecisionThreadSafe2(long price) {
        synchronized (lock) {
            if (arrayDeque.size() == precision) {
                sum -= arrayDeque.poll();
            }
            arrayDeque.addLast(price);
            sum += price;
            return  ((double)sum) / arrayDeque.size();
        }
    }

    /** Non blocking solutions:
     it is hard to come up with non blocking atomic solution,
     cause it is needed to insert and retrieve last from ArrayDeque,
     which could not be done atomically by
     {@link LinkedBlockingDeque} - good for putting/ getting Queue (bounded/unbounded)
     {@link java.util.concurrent.CopyOnWriteArrayList} - good for one writer / many readers
     {@link java.util.concurrent.atomic.AtomicLongArray} - good for switching one array with another atomically
     all have issue: no possibility to poll last and add new (with calculation of current average) atomically
    **/

    @Test
    public void testNotThreadSafeWithoutPrecision() {
        AverageCalculatorCodePairInterviewTest test = new AverageCalculatorCodePairInterviewTest();
        for (int i = 0; i < 20; i++) {
            test.supplyNextPrice(20);
        }
        assertThat(test.supplyNextPrice(20)).isEqualTo(20.0);
        assertThat(test.supplyNextPrice(42)).isEqualTo(21.0);
    }

    @Test
    public void testNotThreadSafeWitPrecision() {
        AverageCalculatorCodePairInterviewTest test = new AverageCalculatorCodePairInterviewTest();
        for (int i = 0; i < 20; i++) {
            test.supplyNextPriceWithPrecision(20);
        }
        assertThat(test.supplyNextPriceWithPrecision(20)).isEqualTo(20.0);
        assertThat(test.supplyNextPriceWithPrecision(620)).isEqualTo(50.0);
    }

    @Test
    public void testThreadSafeWithArrayDequeWithoutRecalculation() {
        AverageCalculatorCodePairInterviewTest test = new AverageCalculatorCodePairInterviewTest();
        for (int i = 0; i < 20; i++) {
            test.supplyNextPriceWithPrecisionThreadSafe2(20);
        }
        assertThat(test.supplyNextPriceWithPrecisionThreadSafe2(20)).isEqualTo(20.0);
        assertThat(test.supplyNextPriceWithPrecisionThreadSafe2(620)).isEqualTo(50.0);
    }

    @Test
    public void testThreadSafeWithArrayListWithRecalculation() {
        AverageCalculatorCodePairInterviewTest test = new AverageCalculatorCodePairInterviewTest();
        for (int i = 0; i < 20; i++) {
            test.supplyNextPriceWithPrecisionThreadSafe1(20);
        }
        assertThat(test.supplyNextPriceWithPrecisionThreadSafe1(20)).isEqualTo(20.0);
        assertThat(test.supplyNextPriceWithPrecisionThreadSafe1(620)).isEqualTo(50.0);
    }
}
