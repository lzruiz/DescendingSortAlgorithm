
/**
 * 
 * @author menor,
 *  palgan,
 *  rom,
 *  sajota, 
 *  sarangaya,
 *  somera,
 *  teves,
 *  tolentino
 *  villacortes,
 *  ybardaloza,
 *
 * Submission must have the following
 * 
 * a. Program using command prompt
 * b. Program using dialog box
 * c. Program using GUI
 * d. Program using Files
 * e. Program using Methods (I/O can be done using any chosen)
 *
 *	https://www.youtube.com/watch?v=ZRPoEKHXTJg
 */
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.Arrays;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/*
 *  Uses merge sort as it is widely used as they have a time complexity of O(n log n), 
 *  which is efficient and practical for most use cases. However, 
 *  the best algorithm to use depends on the specific requirements of the problem, 
 *  such as the size of the dataset, the range of values, and the available memory.
 */

public class DescendingSortAlgorithm {

	public static void main(String[] args) throws IOException {

		programA();
		// programB();
		// programD();

	}

	public static void programA() {
		Scanner in = new Scanner(System.in);
		System.out.println(
				"Input digits to be sorted descendingly,\nWrite the numbers in one line with a SPACE after EACH number.");
		String nums = in.nextLine();

		// Split each digit after each space into individual digits
		String[] line = nums.split(" ");

		// Parse String array into Integer array
		int[] digits = Stream.of(line).mapToInt(Integer::parseInt).toArray();

		intSort(digits);
		System.out.println(Arrays.toString(digits));
	}

	public static void programB() {
		System.out.println("Opening JDialog");
		String nums;
		nums = JOptionPane.showInputDialog(
				"Input digits to be sorted descendingly,\nWrite the numbers in the TEXT BOX with a SPACE after EACH number.");
		String[] line = nums.split(" ");

		// Parse String array into Integer array
		int[] digits = Stream.of(line).mapToInt(Integer::parseInt).toArray();

		intSort(digits);

		JOptionPane.showMessageDialog(null, "The numbers in descending order\n " + Arrays.toString(digits));

	}

	public static void programD() {
		try {

			// Change file directory (if necessary) for testing
			Scanner in = new Scanner(new FileReader(
					"C:\\Users\\menor\\Desktop\\College Work\\BIT13\\S-ITCS123\\S-ITCS123Workspace\\DescendingSortAlgorithm\\src\\input"));

			String nums = in.nextLine();

			String[] line = nums.split(" ");

			// Parse String array into Integer array
			int[] digits = Stream.of(line).mapToInt(Integer::parseInt).toArray();

			intSort(digits);

			FileWriter out = new FileWriter("output.txt");
			out.write(Arrays.toString(digits));
			in.close();
			out.close();

			System.out.println("Successfully written");

		} catch (Exception ex) {
			System.out.println("Fatal Error");
			ex.printStackTrace();
		}
	}

	// Recursive method
	public static void intSort(int[] array) {
		if (array.length <= 1) {
			return;
		}

		int mid = array.length / 2;

		// Split the array into two halves
		int[] left = Arrays.copyOfRange(array, 0, mid);
		int[] right = Arrays.copyOfRange(array, mid, array.length);

		// Recursively sort the two halves
		intSort(left);
		intSort(right);

		// Merge the sorted halves in descending order
		mergeArr(array, left, right);
	}

	public static void mergeArr(int[] array, int[] left, int[] right) {
		int i = 0, j = 0, k = 0;

		// Merge the two halves in descending order
		while (i < left.length && j < right.length) {
			if (left[i] >= right[j]) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}

		// Copy the remaining elements from the left half, if any
		while (i < left.length) {
			array[k++] = left[i++];
		}

		// Copy the remaining elements from the right half, if any
		while (j < right.length) {
			array[k++] = right[j++];
		}
	}
}
