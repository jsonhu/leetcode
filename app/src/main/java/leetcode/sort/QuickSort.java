package leetcode.sort;

public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int low = left + 1;
        int high = right;
        while (true) {
            while (low <= high && array[low] < pivot) {
                low++;
            }

            while (low <= high && array[high] > pivot) {
                high--;
            }

            if (low >= high) {
                break;
            }

            swap(array, low, high);
            low++;
            high--;
        }
        swap(array, left, high);
        return high;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 10, 7, 8, 9, 1, 5 };
        quickSort(array);
        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
