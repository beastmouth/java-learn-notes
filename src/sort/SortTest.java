package sort;

public class SortTest {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 44, 32, 6, 12, 456, 2};
//        int[] array = new int[]{30, 40, 60, 10, 20, 50};
//        int[] result = sort.BubbleSort.bubbleSort(array);
//        int[] result = sort.BubbleSort.bubbleSortBetter1(array);
//        int[] result = BubbleSort.cocktailSort(array);
//        int[] result = QuickSort.quickSort(array, 0, array.length - 1);
        int[] result = InsertionSort.insertionSort(array);
        for (int temp : result) {
            System.out.print(temp + "  ");
        }

//        int[] test = new int[]{10, 20, 30, 40};
//        int i = 0;
//        test[i++] = test[3];
//        for (int temp : test) {
//            System.out.println(temp + "  ");
//        }
    }
}
