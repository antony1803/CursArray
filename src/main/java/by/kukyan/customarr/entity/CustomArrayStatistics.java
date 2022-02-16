package by.kukyan.customarr.entity;

import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class CustomArrayStatistics {
    private OptionalInt max;
    private OptionalInt min;
    private OptionalDouble avg;
    private OptionalLong sum;
    public CustomArrayStatistics(){}
    public  CustomArrayStatistics(int newMax, int newMin, double newAvg, long newSum){
        max = OptionalInt.of(newMax);
        min = OptionalInt.of(newMin);
        avg = OptionalDouble.of(newAvg);
        sum = OptionalLong.of(newSum);
    }

    public OptionalInt getMax(){
        return max;
    }

    public void setMax(int newMax){
        max = OptionalInt.of(newMax);
    }

    public void setMin(int newMax){
        min = OptionalInt.of(newMax);
    }
    public OptionalInt getMin(){
        return min;
    }

    public void setAvg(double newMax){
        avg = OptionalDouble.of(newMax);
    }

    public OptionalDouble getAvg(){
        return avg;
    }

    public OptionalLong getSum(){
        return sum;
    }

    public void setSum(long newMax){
        sum = OptionalLong.of(newMax);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArrayStatistics temp = (CustomArrayStatistics) o;
        return Objects.equals(sum, temp.sum) && Objects.equals(max, temp.max) && Objects.equals(min, temp.min) && Objects.equals(avg, temp.avg);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayStatistics{");
        sb.append("max = ").append(max.getAsInt());
        sb.append(", min = ").append(min.getAsInt());
        sb.append(", avg = ").append(avg.getAsDouble());
        sb.append(", sum = ").append(sum.getAsLong());
        sb.append('}');
        return sb.toString();
    }


}
