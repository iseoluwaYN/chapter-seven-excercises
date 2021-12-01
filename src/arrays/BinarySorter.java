package arrays;

import com.sages.exception.ArraySorterException;

public class BinarySorter implements ArraySorter{

    @Override
    public int[] sort(int[] arraySorter) throws ArraySorterException {
        validateArray(arraySorter);
        int midPoint = arraySorter.length / 2;


        return new int[0];
    }

    @Override
    public int[] sortDescending(int[] arraySorter) throws ArraySorterException {
        validateArray(arraySorter);
        return new int[0];
    }
}
