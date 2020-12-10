package ua.edu.ucu.stream;

import ua.edu.ucu.function.IntBinaryOperator;
import ua.edu.ucu.function.IntConsumer;
import ua.edu.ucu.function.IntPredicate;
import ua.edu.ucu.function.IntToIntStreamFunction;
import ua.edu.ucu.function.IntUnaryOperator;

import java.util.ArrayList;

public class AsIntStream implements IntStream {
    private ArrayList<Integer> stream = new ArrayList<>();

    private AsIntStream(int... values) {
        for (int num: values) {
            stream.add(num);
        }

    }

    public static IntStream of(int... values) {
        return new AsIntStream(values);
    }

    @Override
    public Double average() {
        return sum().doubleValue() / stream.size();
    }

    @Override
    public Integer max() {
        if (stream.size() == 0) {
            throw new IllegalArgumentException("stream is empty");
        }
        int max = stream.get(0);
        for (int num: stream) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @Override
    public Integer min() {
        if (stream.size() == 0) {
            throw new IllegalArgumentException("stream is empty");
        }
        int min = stream.get(0);
        for (int num: stream) {
            if (num < min) {
                min = num;
            }
        }
        return min;       }

    @Override
    public long count() {
        if (stream.size() == 0) {
            throw new IllegalArgumentException("stream is empty");
        }
        return stream.size();
    }

    @Override
    public Integer sum() {
        if (stream.size() == 0) {
            throw new IllegalArgumentException("stream is empty");
        }
        Integer sum = 0;
        for (Integer num: stream) {
            sum += num;
        }
        return sum;
    }


    @Override
    public IntStream filter(IntPredicate predicate) {
        ArrayList<Integer> filtered = new ArrayList<>();
        for (Integer num: stream) {
            if (predicate.test(num)) {
                filtered.add(num);
            }
        }
        int[] intArray = new int[filtered.size()];
        for (int i = 0; i < filtered.size(); i++) {
            intArray[i] = filtered.get(i);
        }

        return of(intArray);
    }

    @Override
    public void forEach(IntConsumer action) {
        for (int num: stream) {
            action.accept(num);
        }
    }

    @Override
    public IntStream map(IntUnaryOperator mapper) {
        int[] intArray = new int[stream.size()];
        for (int i = 0; i < stream.size(); i++) {
            intArray[i] = mapper.apply(stream.get(i));
        }
        return of(intArray);
    }

    @Override
    public IntStream flatMap(IntToIntStreamFunction func) {
        ArrayList<Integer> intList = new ArrayList<>();
        for (Integer integer : stream) {
            for (int num : func.applyAsIntStream(integer).toArray()) {
                intList.add(num);
            }
        }
        int[] intArr = new int[intList.size()];
        for (int i = 0; i < intList.size(); i++) {
            intArr[i] = intList.get(i);
        }

        return of(intArr);
    }

    @Override
    public int reduce(int identity, IntBinaryOperator op) {
        int reduced = identity;
        for (int num: stream) {
            reduced = op.apply(reduced, num);
        }
        return reduced;
    }

    @Override
    public int[] toArray() {
        int[] intArray = new int[stream.size()];
        for (int i = 0; i < stream.size(); i++) {
            intArray[i] = stream.get(i);
        }
        return intArray;
    }

}
