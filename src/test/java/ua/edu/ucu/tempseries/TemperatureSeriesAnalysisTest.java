package ua.edu.ucu.tempseries;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDevitation() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-35, 3.23, -4.54, -215, 45.533};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        double expResult = 2;
        double expResult2 = 90.64818;
        double actualResult = seriesAnalysis.deviation();
        double actualResult2 = seriesAnalysis2.deviation();
        assertEquals(expResult, actualResult, 0.00001);
        assertEquals(expResult2, actualResult2, 0.00001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-35, 3.23, -4.54, -222, 45.533};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        double expResult = 2.0;
        double expResult2 = -222;
        double actualResult = seriesAnalysis.min();
        double actualResult2 = seriesAnalysis2.min();
        assertEquals(expResult, actualResult, 0.00001);
        assertEquals(expResult2, actualResult2, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-35, 3.23, -4.54, -222, 533};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        double expResult = 9.0;
        double expResult2 = 533;
        double actualResult = seriesAnalysis.max();
        double actualResult2 = seriesAnalysis2.max();
        assertEquals(expResult, actualResult, 0.00001);
        assertEquals(expResult2, actualResult2, 0.00001);
    }

    @Test
    public void testfindTempClosestToZero() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-25, 30.23, -4.54, -225, 45.533};
        double[] temperatureSeries3 = {-5.0, 5.0, 10.3, -200.0, 44444.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        TemperatureSeriesAnalysis seriesAnalysis3 = new TemperatureSeriesAnalysis(temperatureSeries3);
        double expResult = 2.0;
        double expResult2 = -4.54;
        double expResult3 = 5;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        double actualResult2 = seriesAnalysis2.findTempClosestToZero();
        double actualResult3 = seriesAnalysis3.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
        assertEquals(expResult2, actualResult2, 0.00001);
        assertEquals(expResult3, actualResult3, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTemps() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] t1 = {-355, 3.23, -4.54, -2345, 45.533};
        double[] t2 = {355, 3.23, -4.54, 2345, 45.533};
        double[] t3 = {-5.0, 5.0, 10.3, -200.0, 44444.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 13;
        double expResult2 = 18;

        double actualResult = seriesAnalysis.addTemps(t3);
        double actualResult2 = seriesAnalysis.addTemps(t2);
        assertEquals(expResult, actualResult, 0.00001);
        assertEquals(expResult2, actualResult2, 0.00001);

        seriesAnalysis.addTemps(t1);

    }

    @Test(expected = InputMismatchException.class)
    public void testfindTempClosestToValue() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-35, 3.23, -4.54, -222, 45.533};
        double[] temperatureSeries3 = {-5.0, 5.0, 10.3, -200.0, 44444.0};
        double[] temperatureSeries4 = {-5.0, 5.0, 10.3, -2000.0, 44444.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        TemperatureSeriesAnalysis seriesAnalysis3 = new TemperatureSeriesAnalysis(temperatureSeries3);
        TemperatureSeriesAnalysis seriesAnalysis4 = new TemperatureSeriesAnalysis(temperatureSeries4);
        double expResult = 4.0;
        double expResult2 = -222;
        double expResult3 = 10.3;
        double actualResult = seriesAnalysis.findTempClosestToValue(3);
        double actualResult2 = seriesAnalysis2.findTempClosestToValue(-2000);
        double actualResult3 = seriesAnalysis3.findTempClosestToValue(55.5);
        assertEquals(expResult, actualResult, 0.00001);
        assertEquals(expResult2, actualResult2, 0.00001);
        assertEquals(expResult3, actualResult3, 0.00001);

        seriesAnalysis4.findTempClosestToValue(4);
    }
    @Test
    public void testfindTempsLessThen() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-75, 3.23, -4.54, -45, 45.533};
        double[] temperatureSeries3 = {-5.0, 5.0,  44444.0,10.3, -200.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        TemperatureSeriesAnalysis seriesAnalysis3 = new TemperatureSeriesAnalysis(temperatureSeries3);
        double [] expResult = {2.0};
        double [] expResult2 = {-75, 3.23, -4.54, -45};
        double [] expResult3 = {-5.0, 5.0, 10.3, -200.0};
        double [] actualResult = seriesAnalysis.findTempsLessThen(3);
        double [] actualResult2 = seriesAnalysis2.findTempsLessThen(20);
        double [] actualResult3 = seriesAnalysis3.findTempsLessThen(111);
        assertArrayEquals(expResult, actualResult, 0.0001);
        assertArrayEquals(expResult2, actualResult2, 0.0001);
        assertArrayEquals(expResult3, actualResult3, 0.0001);
}
    @Test
    public void testfindTempsMoreThen() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double[] temperatureSeries2 = {-75, 3.23, -4.54, -45, 45.533};
        double[] temperatureSeries3 = {-5.0, 5.0,  44444.0,10.3, -200.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries2);
        TemperatureSeriesAnalysis seriesAnalysis3 = new TemperatureSeriesAnalysis(temperatureSeries3);
        double [] expResult = {4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0};
        double [] expResult2 = {45.533};
        double [] expResult3 = {44444.0};
        double [] actualResult = seriesAnalysis.findTempsGreaterThen(3);
        double [] actualResult2 = seriesAnalysis2.findTempsGreaterThen(20);
        double [] actualResult3 = seriesAnalysis3.findTempsGreaterThen(111);
        assertArrayEquals(expResult, actualResult, 0.0001);
        assertArrayEquals(expResult2, actualResult2, 0.0001);
        assertArrayEquals(expResult3, actualResult3, 0.0001);
    }

    @Test
    public void TestSummaryStatistics() {
        double[] temperatureSeries = {2.0, 4.0, 4.0, 4.0, 5.0, 5.0, -7.0, -9.0, 777.7777};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics stat = seriesAnalysis.summaryStatistics();
        assertArrayEquals(new double[]{87.3086, 244.1686, 777.7777, -9.0},
                new double[]{stat.getAvgTemp(), stat.getDevTemp(), stat.getMaxTemp(), stat.getMinTemp()}, 0.001);
    }

}
