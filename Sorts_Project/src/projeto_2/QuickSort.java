package projeto_2;

import java.util.Stack;

public class QuickSort{

    public static void sort(int[] numbers) {

        // create empty stack
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        stack.push(numbers.length);

        // iterate until stack becomes empty
        while (!stack.isEmpty()) {

            int end = stack.pop();
            int start = stack.pop();

            if (end - start < 2) {
                continue;
            }

            int p = start + ((end - start) / 2);

            p = partition(numbers, p, start, end);

            stack.push(p + 1);
            stack.push(end);
            stack.push(start);
            stack.push(p);

        }

    }

    // method to make partition of arrays into smaller arrays
    private static int partition(int[] input, int position, int start, int end) {

        int low = start;
        int high = end - 2;
        int piv = input[position];

        swap(input, position, end - 1);

        while (low < high) {
            if (input[low] < piv) {
                low++;
            }
            else if (input[high] >= piv) {
                high--;
            }
            else {
                swap(input, low, high);
            }

        }
        int idx = high;

        if (input[high] < piv) {
            idx++;
        }

        swap(input, end - 1, idx);

        return idx;
    }

    // method to swap two numbers in an array
    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

}
