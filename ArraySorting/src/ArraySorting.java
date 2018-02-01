import java.util.Arrays;

// EDX - Microsoft: DEV285x

public class ArraySorting {

	public static void main(String[] args) {

		// Arrays.sort
		int[] array = createArray(8);
		System.out.println("Unsorted array: " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));

		// Selection Sort
		int[] array1 = createArray(10);
		System.out.println("Unsorted array: " + Arrays.toString(array1));
		selectionSort(array1);

		// Linear Search
		int[] array2 = { 4, 6, 56, 23, 4, 1, 30, 15, 67, 89 };
		linearSearch(array2, 23);
		linearSearch(array2, 20);

		// Bubble Sort
		int[] array3 = createArray(10);
		System.out.println("Unsorted array: " + Arrays.toString(array3));
		bubbleSort(array3);

		// Merge Sort
		int[] array4 = createArray(10);
		System.out.println("Unsorted array: " + Arrays.toString(array4));
		int[] array5 = mergeSort(array4);
		System.out.println("Array after Merge Sort: " + Arrays.toString(array5));
		System.out.println(isSorted(array5));

		// Binary Search
		int[] array6 = { 1, 2, 4, 6, 8, 11, 12, 13, 14, 17 };
		binarySearch(6, array6, 1, 17);
		binarySearch(10, array6, 1, 17);
		

	}

	public static void selectionSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i++) {

			int index = i;
			int smallest = array[i];
			for (int j = i; j < n; j++) {
				if (array[j] < smallest) {
					smallest = array[j];
					index = j;
				}
			}
			int temp = array[i];
			array[i] = smallest;
			array[index] = temp;
		}

		System.out.println("Array after Selection Sort: " + Arrays.toString(array));
	}

	public static void linearSearch(int[] array, int value) {

		int n = array.length;
		for (int i = 0; i < n; i++) {
			if (array[i] == value) {
				System.out.println("Found! It is at: " + i);
				return;
			}
		}

		System.out.println("The element is not in the array");
	}

	public static void bubbleSort(int[] array) {
		int n = array.length;
		boolean swapped;

		do {
			swapped = false;
			for (int i = 0; i < n - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					swapped = true;
				}
			}
		} while (swapped == true);

		System.out.println("Array after Bubble Sort: " + Arrays.toString(array));
	}

	public static int[] mergeSort(int[] array) {
		int n = array.length;
		int[] left;
		int[] right;

		if (n <= 1) {
			return array;
		}

		// create space for left and right arrays
		if (n % 2 == 0) {
			left = new int[n / 2];
			right = new int[n / 2];
		} else {
			left = new int[n / 2];
			right = new int[n / 2 + 1];
		}

		// fill up left and right arrays
		for (int i = 0; i < n; i++) {
			if (i < n / 2) {
				left[i] = array[i];
			} else {
				right[i - n / 2] = array[i];
			}
		}
		// recursively split and merge
		left = mergeSort(left);
		right = mergeSort(right);

		// merge
		return merge(left, right);

	}

	// method for merging two sorted arrays
	public static int[] merge(int[] left, int[] right) {

		int[] result = new int[left.length + right.length];

		int i = 0;
		int j = 0;
		int index = 0;

		// add until one sub array is deplete
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				result[index++] = left[i++];
			} else {
				result[index++] = right[j++];
			}
		}

		// add every leftover element from the sub array
		// only one of the two while loops will be executed
		while (i < left.length) {
			result[index++] = left[i++];
		}

		while (j < right.length) {
			result[index++] = right[j++];
		}

		return result;
	}

	public static boolean binarySearch(int value, int[] array, int low, int high) {

		if (low > high) {
			System.out.println("not found");
			return false;
		}

		int middle = (low + high) / 2;

		if (value == array[middle]) {
			System.out.println("found! It is at " + middle);
			return true;
		}

		else if (value > array[middle]) {
			return binarySearch(value, array, middle + 1, high);
		} else {
			return binarySearch(value, array, low, middle - 1);
		}
	}
	
	public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i] < array[i-1]) return false;
        return true;
    }

	public static int[] createArray(int n) {

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 25);
		}

		return array;
	}

}
