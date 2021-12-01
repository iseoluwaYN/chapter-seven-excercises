package arrays;

import com.sages.exception.ArraySorterException;

public interface ArraySorter {
    public int[] sort(int[] arraySorter) throws ArraySorterException;
    public int[] sortDescending(int[] arraySorter) throws ArraySorterException;

    default void validateArray(int[] arrayToSort) throws ArraySorterException {
        if(arrayToSort == null)
            throw new ArraySorterException("Array Sorter cannot be null");
    }
}
