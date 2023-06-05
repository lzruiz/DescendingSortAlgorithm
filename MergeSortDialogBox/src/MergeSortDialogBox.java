import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

/**
 * a) DIALOG BOX MERGE SORT
 * Time Complexity O(n log n)
 * Space Complexity O(n)
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
 *	
 */


public class MergeSortDialogBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
