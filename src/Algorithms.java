import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Algorithms {

    public static void main(String[] args) {

        int numberOfElements;
        int[] data;
        int[] dataBackup;
        boolean exit = false;

        Algorithms sortingAlgorithms = new Algorithms();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter number of elements: ");
        numberOfElements = scanner.nextInt();

        data = new int[numberOfElements];

        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Generate " + numberOfElements + " random numbers for sorting");
        System.out.println("2. Enter " + numberOfElements + " numbers for sorting");

        int choiceOfInput = scanner.nextInt();

        switch (choiceOfInput) {

            case 1:
                if (numberOfElements != 0)
                    for (int i = 0; i < numberOfElements; i++)
                        data[i] = random.nextInt(5000) + 1;
                break;
            case 2:
                if (numberOfElements != 0)
                    System.out.println("\nEnter the elements:");
                for (int i = 0; i < numberOfElements; i++)
                    data[i] = scanner.nextInt();
                break;
        }

        dataBackup = data.clone();

        do {

            data = dataBackup.clone();

            System.out.println("\nThe data is: " + Arrays.toString(data));
            System.out.println("Select a sorting algorithm to use: ");
            System.out.println("1. Merge Sort");
            System.out.println("2. Heap Sort");
            System.out.println("3. Quick Sort (Median of 3 method)");
            System.out.println("4. Insertion Sort");
            System.out.println("5. Bubble Sort");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nSorting using Merge Sort:");
                    System.out.println("Original Array: " + Arrays.toString(data));
                    long startTimeForMergeSort = System.nanoTime();
                    sortingAlgorithms.mergeSort(data, 0, data.length - 1);
                    long endTimeForMergeSort = System.nanoTime();
                    System.out.println("Sorted Array: " + Arrays.toString(data));
                    System.out.println("Execution time: "+ (endTimeForMergeSort - startTimeForMergeSort) + "ns.");
                    break;
                case 2:
                    System.out.println("\nSorting using Heap Sort:");
                    System.out.println("Original Array: " + Arrays.toString(data));
                    long startTimeForHeapSort = System.nanoTime();
                    sortingAlgorithms.heapSort(data);
                    long endTimeForHeapSort = System.nanoTime();
                    System.out.println("Sorted Array: " + Arrays.toString(data));
                    System.out.println("Execution time: "+ (endTimeForHeapSort - startTimeForHeapSort) + "ns.");
                    break;
                case 3:
                    System.out.println("\nSorting using Quick Sort (Median of 3 Method):");
                    System.out.println("Original Array: " + Arrays.toString(data));
                    long startTimeForQuickSort = System.nanoTime();
                    sortingAlgorithms.quickSort(data, 0, data.length - 1);
                    long endTimeForQuickSort = System.nanoTime();
                    System.out.println("Sorted Array: " + Arrays.toString(data));
                    System.out.println("Execution time: "+ (endTimeForQuickSort - startTimeForQuickSort) + "ns.");
                    break;
                case 4:
                    sortingAlgorithms.insertionSort(data);
                    break;
                case 5:
                    sortingAlgorithms.bubbleSort(data);
                    break;
                case 6:
                    exit = true;
                    break;
            }
        } while (!exit);
    }




    /* -----------------------------------------------Swap Method---------------------------------------------------- */

    private void swap(int[] a, int i, int j) {

        //We simply swap two elements in the array.
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /* -----------------------------------------------Swap Method Ends----------------------------------------------- */




    /* ------------------------------------------Insertion Sort Method----------------------------------------------- */

    private void insertionSort(int[] data) {

        int[] originalArray = data.clone();

        long start = System.nanoTime();

        if (data.length == 0) {

            System.out.println("Array is empty.");

            return;
        }

        int key;

        for (int i = 0; i < data.length; i++) {

            //We assign the current element from the array as they key element for comparison.
            key = data[i];

            //We move elements which are greater than key a position ahead of their current position.
            int j = i - 1;

            while (j >= 0 && key < data[j]) {

                data[j + 1] = data[j];
                j--;
            }

            //After moving the elements we assign the next element as the key and we continue the loop.
            data[j + 1] = key;
        }

        long end = System.nanoTime();

        System.out.println("\nSorting using Insertion Sort:");
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Sorted Array: " + Arrays.toString(data));
        System.out.println("Execution time: " + (end - start) + "ns.");
    }

    /* -----------------------------------------Insertion Sort Method Ends------------------------------------------- */




    /* ----------------------------------------------Bubble Sort Method---------------------------------------------- */

    private void bubbleSort(int[] data) {

        int[] originalArray = data.clone();

        //We declare a isSwapped variable to break out of the inner for loop if no swapping is performed, meaning our array has been sorted.
        boolean isSwapped = true;

        long start = System.nanoTime();

        //We continue this loop till isSwapped is true, at the moment it becomes false we break out of the loop and we can conclude that the array has been sorted.
        while (isSwapped) {

            isSwapped = false;

            //This loop behaves in the same way as the inner for loop of the conventional bubble sort.
            for (int i = 0; i < data.length - 1; i++) {

                if (data[i] > data[i + 1]) {

                    swap(data, i, i + 1);

                    //We set isSwapped to true, meaning sorting has been performed in the loop, and we continue with the sorting.
                    isSwapped = true;
                }
            }
        }

        long end = System.nanoTime();

        System.out.println("\nSorting using Bubble Sort:");
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Sorted Array: " + Arrays.toString(data));
        System.out.println("Execution time: " + (end - start) + "ns.");
    }

    /* -----------------------------------------------Bubble Sort Method Ends---------------------------------------- */




    /* ------------------------------------------Merge Sort Methods-------------------------------------------------- */

    private void mergeSort(int[] data, int l, int r) {

        //We check if the array only has one element, if yes we simply return.
        if (data.length == 1)
            return;

        //We check if right is greater than left. If it is, we get the midpoint and call the mergeSort function recursively till we can't split the Arrays into two halves anymore.
        if (r > l) {

            int mid = (l + r) / 2;
            mergeSort(data, l, mid);
            mergeSort(data, mid + 1, r);

            //We compare the elements and then merge the arrays.
            merge(data, l, mid, r);
        }
    }

    private void merge(int[] data, int l, int mid, int r) {

        //We create right and left halves of the original array using the leftmost index, rightmost index and the midpoint.
        int[] leftArray = new int[mid - l + 2];
        int[] rightArray = new int[r - mid + 1];

        //We populate those arrays, using the original array.
        for (int i = 0; i <= mid - l; i++) {

            //We populate the left array with elements from the start till the midpoint from the original array.
            leftArray[i] = data[l + i];
        }

        for (int j = 0; j < r - mid; j++) {

            //We populate the right array with elements from the midpoint + 1 till the end from the original array.
            rightArray[j] = data[mid + 1 + j];
        }

        //Here we set the last element of each halves as a sentinel value, using which we can determine that we've reached at the end of the array.
        leftArray[mid - l + 1] = Integer.MAX_VALUE;
        rightArray[r - mid] = Integer.MAX_VALUE;

        //We initialize pointers for iterating through the left and right half.
        int i = 0, j = 0;

        //We compare the values from the two halves, and accordingly add each element to the original array and then return the same after sorting is complete.
        for (int k = l; k <= r; k++) {

            //We compare the elements and then add them to the original array accordingly, after which we increment the respective pointers.
            if (leftArray[i] < rightArray[j]) {

                data[k] = leftArray[i];
                i++;
            }
            else {

                data[k] = rightArray[j];
                j++;
            }
        }
    }

    /* ------------------------------------------Merge Sort Methods End---------------------------------------------- */




    /* -------------------------------------------Heap Sort Methods-------------------------------------------------- */

    private void heapSort(int[] data) {

        //We get the length of the array.
        int n = data.length;

        //We build a max heap.
        buildHeap(data);

        //We swap the largest item with item at the end of the array.
        for (int i = n - 1; i >= 0; i--) {

            swap(data, 0, i);

            //We call heapify on the reduced array
            heapify(data, 0, i);
        }
    }

    //We build a max heap.
    private void buildHeap(int[] data) {

        //We get the length of the array.
        int n = data.length;

        //We build a heap from the given array.
        for (int i = (n / 2) - 1; i >= 0; i--) {

            heapify(data, i, n);
        }
    }

    private void heapify(int[] data, int i, int n) {

        //We initialize the largest element as the root.
        int max = i;

        //We initialize the left as 2*i, and right as 2*i + 1, we added 1 to each of the pointers as we're starting the index from 0.
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if (left < n && data[left] > data[i]) {

            //If the left child is larger than the root, we set the left element as the largest element.
            max = left;
        }
        if (right < n && data[right] > data[max]) {

            //Similarly, if the right child is larger than the root, we set the right element as the largest element.
            max = right;
        }

        //If the largest element is not the root, we swap the two elements.
        if (max != i) {

            swap(data, i, max);

            //We heapify the array recursively.
            heapify(data, max, n);
        }
    }

    /* -------------------------------------------Heap Sort Methods End---------------------------------------------- */




    /* -------------------------------------------Quick Sort Methods------------------------------------------------- */

    private void quickSort(int[] data, int start, int end) {

        //We check if start index is greater than ending index.
        if (start < end) {

            //We select pivot by using the median of 3 method, i.e median of start, end and the midpoint.
            int pivot = medianOf3(data, start, end);

            //We then partition the array by using start, end and pivot indices.
            int partition = partition(data, start, end, pivot);

            //We call quickSort recursively for each half of the array.
            quickSort(data, start, partition - 1);
            quickSort(data, partition + 1, end);
        }
    }

    //Here we get the Pivot by using the median of 3 or Lomuto partition.
    private int medianOf3(int[] data, int low, int high) {

        //We find the midpoint of the array.
        int mid = (low + high) / 2;

        if (data[mid] < data[low])
            swap(data, low, mid);
        if (data[high] < data[low])
            swap(data, low, high);
        if (data[mid] > data[high])
            swap(data, mid, high);
        swap(data, mid, high);

        //We return the pivot/median.
        return data[high];
    }

    private int partition(int[] data, int start, int end, int pivot) {

        //Let i be the pointer for swapping.
        int i = start - 1;

        //We start the loop from the start position and loop till the end of the partition
        for (int j = start; j <= end; j++) {

            //If the current element is smaller than the pivot we swap ith element and jth element.
            //We place all the element smaller than the pivot to the left and all greater elements to the right of it.
            if (data[j] <= pivot) {

                //We increment the pointer. As the current element is smaller than the pivot.
                i++;

                //We swap ith element with the jth element.
                swap(data, i, j);
            }
        }

        //i returns the index before which values are smaller than the pivot, and starting at which the values are bigger than the pivot.
        return i;
    }
}