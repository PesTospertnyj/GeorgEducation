package geoorg.oct10primitivestream;


import geoorg.sep28streams.Employee;
import geoorg.sep28streams.StreamExamples;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class PowerDoubleSummaryStatistics extends DoubleSummaryStatistics
{
    private double squaredSum = 0.0;
    private final double power;

    public PowerDoubleSummaryStatistics(double power) {
        this.power = power;
    }

    @Override
    public void accept(double value) {
        super.accept(value);
        squaredSum += Math.pow(value, power);
    }

    public double getSquaredSum() {
        return squaredSum;
    }

    public double getPower() {
        return power;
    }
}
