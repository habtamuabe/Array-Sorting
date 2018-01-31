import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		
		int[] array = { 4, 9, 7, 1, 3, 6, 5 };

		System.out.println("Unsorted array: " + Arrays.toString(array));

		Arrays.sort(array);

		System.out.println("Sorted array: " + Arrays.toString(array));
		
		int[] array1 = { 4, 6, 56, 23, 4, 1, 30, 15, 67, 89, 22 };
		
		System.out.println("Unsorted array: " + Arrays.toString(array1));
		selectionSort(array1);

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

}
