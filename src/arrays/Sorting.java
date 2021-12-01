package arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] number = {2, 8, 5, 7, 9};

        for (int index = 0; index <= number.length - 1; index++) {
            for (int swap = index; swap < index; swap++) {
                int order;
                if (number[index] > number[swap]) {
                    order = number[index];
                    number[swap] = number[index];
                }
            }
        }
    }
}
