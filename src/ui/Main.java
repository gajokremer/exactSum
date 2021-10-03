package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static Integer [] books;

	public static void main(String[] args) throws IOException {
		
//		typeManually();
		
		testScenario();
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
			
			System.out.println(i + ": " + number);

			if(a.contains(number)) {

				i--;

			} else {

				a.add(number);
			}
		}

		Collections.shuffle(a);
//		insertionSort(books);
		return a.toArray(new Integer[0]);
	}
	
	public static void insertionSort() {

		int aux, j;

		for(int i = 1; i < books.length; i++) {

			aux = books[i];
			j = i - 1;

			while(j >= 0 && aux < books[j]) {

				books[j+1] = books[j];
				j--;
			}

			books [j+1] = aux;
		}
	}
	
	public static void printArray() {

		for(int i = 0; i < books.length; i++) {

			System.out.print(books[i] + " ");
		}

		System.out.println("\n");
	}
	
	public static boolean binarySearch(int element) {

		int i, j, m;
		boolean find = false;
		i = 0;
		j = books.length - 1;

		while(i <= j && find == false) {

			m = (int)((i + j)/2);

			System.out.println(books[m]);

			if(element == books[m]) {

				find = true;

			} else if(element <= books[m]) {

				j = m - 1;

			} else {

				i = m + 1;
			}
		}

		return find;
	}
	
	public static void typeManually() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Available books: ");
		int availableBooks = sc.nextInt();
		System.out.println();
		
		System.out.println("Book prices: ");
		
		books = new Integer[availableBooks];
		
		for(int i = 0; i < books.length; i++) {
			
			int b = sc.nextInt();
			books[i] = b;
		}
		
		insertionSort();
		System.out.println();
		printArray();
		
		System.out.print("Money recieved this week: ");
		int money = sc.nextInt();
		
		System.out.print("Item to find: ");
		int item = sc.nextInt();
		
		System.out.println(binarySearch(item));
		
		br.close();
	}
	
	public static void testScenario() {

		Scanner sc = new Scanner(System.in);
		
		int n = (int) (Math.random() * (10000 - 2)) + 2; //Number of iterations
		
		System.out.println("n: " + n + "\n");
		
		books = createRandomArray(n, 1, 1000000); //book prices
		
		insertionSort();
		
		System.out.println();
		printArray();
		
		System.out.print("Money: ");
		int money = sc.nextInt();
		
//		int money = (int) (Math.random() * 1000);
//		System.out.println("MONEY: " + money);
		
		itemSearch(money);
		
//		System.out.print("Write a number to find: ");
//		int value = sc.nextInt();
//		
//		System.out.println("\n" + binarySearch(value));
		
		sc.close();
	}
	
	public static void itemSearch(int money) {
		
		boolean bothExist = false;
		boolean firstExists = false;
		boolean secondExists = false;
		
		int counter = 0;
		
		int i = 0;
		int j = 0;
		
		//
		while(bothExist == false) {
			
			counter++;
			
			firstExists = false;
			secondExists = false;
			
			System.out.println("\n\n---ENTER WHILE 1");
			
			while(firstExists == false) {
				
				System.out.println("\nENTER WHILE 2");
				
				int n = (int) (Math.random() * 10000);
				
				System.out.println("Random number: " + n);
				
				if(binarySearch(n) == true) {
				
					i = n;
					firstExists = true;
				}
				
				System.out.println("First: " + firstExists);
			}
			
			while(secondExists == false) {
				
				System.out.println("\nENTER WHILE 3");
				
				int n = (int) (Math.random() * 10000);
				System.out.println("Random number: " + n);

				if(binarySearch(n) == true) {

					j = n;
					secondExists = true;
				}
				
				System.out.println("Second: " + secondExists);
			}
			
//			bothExist = true;
//			
//			System.out.println("\n" + i + " + " + j + " = " + money);
//			
//			System.out.println(equalValues(money, i, j));
//			
//			if(equalValues(money, i, j)) {
//				
//				bothExist = true;
//			}
			
			if(firstExists == true && secondExists == true) {
				
				System.out.println("\n" + i + " + " + j + " = " + money);
				
				System.out.println(equalValues(money, i, j));
				
				if(equalValues(money, i, j) == true) {
					
					bothExist = true;
				}
			}
			
			System.out.println("\nRESULT: " + bothExist);
			System.out.println("ATTEMPTS: " + counter);
		}
		//
		
	}


	public static boolean equalValues(int money, int i, int j) {
		
		int sum = i + j;
		
		if(sum == money) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	public static void randomNumbers() {
		
		int a = (int) (Math.random() * (10 - 1)) + 1; //1 - 10
		System.out.println(a);
		
		System.out.println();
		
		int b = (int) (Math.random() * 10000);
		System.out.println(b);
	}
}
