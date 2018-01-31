import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {

		// Arrays.sort
		int[] array = { 4, 9, 7, 1, 3, 6, 5 };
		System.out.println("Unsorted array: " + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted array: " + Arrays.toString(array));

		// Selection Sort
		int[] array1 = { 4, 6, 56, 23, 4, 1, 30, 15, 67, 89, 22 };
		System.out.println("Unsorted array: " + Arrays.toString(array1));
		selectionSort(array1);

		// Linear Search
		int[] array2 = { 4, 6, 56, 23, 4, 1, 30, 15, 67, 89, 22 };
		linearSearch(array2, 23);
		linearSearch(array2, 20);

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

}
