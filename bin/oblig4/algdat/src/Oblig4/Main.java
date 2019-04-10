package Oblig4;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		File file = new File("C:/Users/kamisiuu/Desktop/text.txt");

		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer input = new StreamTokenizer(r);

		Scanner scanner = new Scanner(file);

		BinarySearchTree b = new BinarySearchTree();
		System.out.println("Before:");
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			String words[] = line.split("[^\\w']+");
			for (int i = 0; i < words.length; i++) {
				//Node nodes = new Node(words[i]);
				System.out.println(words[i]);
				b.insert(words[i]);

			}

		}
		System.out.println("\nAfter:");
		b.print(b.root);
	}
}

