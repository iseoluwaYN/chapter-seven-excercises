package arrays;

import com.sages.exception.ArraySorterException;

public class ArraySorterImpl implements ArraySorter{

    @Override
    public int[] sort(int[] arrayToSort) throws ArraySorterException {
        validateArray(arrayToSort);

        int temp = -1;
        for(int i = 0; i < arrayToSort.length -1; i++){
            for(int j = i+1; j < arrayToSort.length; j++) {
                if (arrayToSort[i] > arrayToSort[j]) {
                    temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return arrayToSort;
    }

    @Override
    public int[] sortDescending(int[] arrayToSort) throws ArraySorterException {
        if(arrayToSort == null){
            throw new ArraySorterException("Array Sorter cannot be null");
        }
        int temp = -1;
        for(int i = 0; i < arrayToSort.length -1; i++){
            for(int j = i+1; j < arrayToSort.length; j++) {
                if (arrayToSort[i] < arrayToSort[j]) {
                    temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
        return arrayToSort;
    }


}
