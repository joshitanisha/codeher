import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
static Random random = new Random();


static int partitionDeterministic(int[] arr, int low, int high) {

    int pivot = arr[high];

    int i = low - 1;

    for (int j = low; j < high; j++) {

        if (arr[j] <= pivot) {

            i++;

            int temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp;

        }

    }

    int temp = arr[i + 1];

    arr[i + 1] = arr[high];

    arr[high] = temp;

    return i + 1;

}

static void deterministicQuickSort(int[] arr, int low, int high){
if (low < high) {
            int pivotIndex = partitionDeterministic(arr, low, high);

        deterministicQuickSort(arr, low, pivotIndex - 1);

        deterministicQuickSort(arr, pivotIndex + 1, high);

    }

}

static int partitionRandomized(int[] arr, int low, int high){
        int randomIndex = low + random.nextInt(high - low + 1);

    int temp = arr[randomIndex];

    arr[randomIndex] = arr[high];

    arr[high] = temp;

    return partitionDeterministic(arr, low, high);

}

static void randomizedQuickSort(int[] arr, int low, int high) {

    if (low < high) {

        int pivotIndex = partitionRandomized(arr, low, high);

        randomizedQuickSort(arr, low, pivotIndex - 1);

        randomizedQuickSort(arr, pivotIndex + 1, high);

    }

}
public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of elements: ");

    int n = sc.nextInt();

    int[] arr = new int[n];

    System.out.println("Enter array elements:");

    for (int i = 0; i < n; i++) {

        arr[i] = sc.nextInt();

    }

    int[] arr1 = arr.clone();

    int[] arr2 = arr.clone();

    // Deterministic Quick Sort

    long start1 = System.nanoTime();

    deterministicQuickSort(arr1, 0, n - 1);

    long end1 = System.nanoTime();

    // Randomized Quick Sort

    long start2 = System.nanoTime();

    randomizedQuickSort(arr2, 0, n - 1);

    long end2 = System.nanoTime();

    System.out.println("\nDeterministic Quick Sort:");

    System.out.println(Arrays.toString(arr1));

    System.out.println("Execution Time: " + (end1 - start1) + " ns");

    System.out.println("\nRandomized Quick Sort:");

    System.out.println(Arrays.toString(arr2));

    System.out.println("Execution Time: " + (end2 - start2) + " ns");

    sc.close();

}
