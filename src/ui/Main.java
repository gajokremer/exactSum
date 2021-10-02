package ui;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static Integer [] books;

	public static void main(String[] args) {
		
		books = createRandomArray(10, 1000, 1200);
		
		printArray();
		
		System.out.println(books);
	}

	
	/**
	 * Generates random array.
	 * @param n number of iterations inside array.
	 * @param start lowest possible value.
	 * @param end highest possible value.
	 * @return Random array.
	 */
	public static Integer [] createRandomArray(int n, int start, int end) {

		int number;
		ArrayList<Integer> a = new ArrayList<>();

		for(int i = 0; i < n; i++) {

			number = (int) (Math.random() * (start - end + 1) + end);

			if(a.contains(number)) {

				i--;

			} else {

				a.add(number);
			}
		}

		Collections.shuffle(a);
		return a.toArray(new Integer[0]);
	}
	
	public static void printArray() {

		for(int i = 0; i < books.length; i++) {

			System.out.print(books[i] + " ");
		}

		System.out.println("\n");
	}
}
