import java.util.Arrays;

public class qsort {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int[] testArray1 = {4, 5, 8, 9, 0, 5, 9, 1};
        testArray(testArray1);
    }

    private static void testArray(int[] arr) {
        printArr(testArray1, qsort(testArray1, 0, testArray1.length-1));
    }

    private static void printArr(int[] unsortedArr, int[] sortedArr) {
        if (!verifyArrayOrder(sortedArr)) {
            throw new IllegalArgumentException(Arrays.toString(sortedArr));
        }
        System.out.println("Unsorted: "+ Arrays.toString(unsortedArr) + " Sorted: "+Arrays.toString(sortedArr));
    }

    private static boolean verifyArrayOrder(int[] testArray) {
        if (testArray.length < 2) {
            return true;
        }

        for (int i=1; i<testArray.length; i++) {
            if (testArray[i-1] > testArray[i]) {
                return false;
            }
        }
        return true;
    }




    public static int[] qsort(int[] array, int left, int right) {

        if (left >= right) {
            return array;
        }

        //System.out.println();
        //System.out.println("Qsort("+Arrays.toString(array)+","+left+","+right+")");
        int pivot = array[right];
        //System.out.println("Pivot: "+pivot);
        int index = partition(array, left, right, pivot);
        //System.out.println("Index: "+index);
        qsort(array, left, index-1);
        qsort(array, index, right);

        return array;
    }

    public static int partition(int[] array, int left, int right, int pivot) {

        while (left <= right) {
            //System.out.println("Left: "+left+ "  Right: "+right+"  Pivot:"+pivot+"  Array:"+Arrays.toString(array));
            while (array[left] < pivot) {left++;}
            while (array[right] > pivot) {right--;}

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        //System.out.println("Partition: "+left);
        return left;
    }

    public static void swap(int[] arr, int leftIdx, int rightIdx) {
        int tmp = arr[leftIdx];
        arr[leftIdx] = arr[rightIdx];
        arr[rightIdx] = tmp;
    }


}
