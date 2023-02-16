package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Saraksts;
import model.Student;

public class Main {

	public static void main(String[] args) {
		Saraksts<Integer> sar = new Saraksts<>(6);
		File loadedFile;
		Scanner scan;
		loadedFile = new File(Main.class.getResource("/resources/numbers.txt").getFile());
		try {
			scan = new Scanner(loadedFile);
			scan.useDelimiter("\n");
			while (scan.hasNextInt()) {
				int temp = scan.nextInt();
				//System.out.println("adding "+ temp);
				sar.addLast(temp);
				//sar.print();
				//System.out.println("Sarakstā ir "+sar.getSize()+" elementi");
				//System.out.println("Sarakstā ir "+sar.getLength()+" vietas");
			}
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sar.print();
		System.out.println("Saraksts ir tukšs:"+ sar.isEmpty());
		System.out.println("Saraksts ir pilns:"+ sar.isFull());
		System.out.println("Sarakstā ir "+sar.getSize()+" elementi");
		System.out.println("Sarakstā ir "+sar.getLength()+" vietas");
		sar.addByIndex(8, 3);
		System.out.println("4. vietā ievietoja 8: "+ sar);
		System.out.println("Sarakstā ir "+sar.getSize()+" elementi");
		System.out.println("Sarakstā ir "+sar.getLength()+" vietas");
		sar.removeByIndex(3);
		System.out.println("4. vietu izņēma: "+ sar);
		System.out.println("Sarakstā ir "+sar.getSize()+" elementi");
		System.out.println("Sarakstā ir "+sar.getLength()+" vietas");
		System.out.println("vietā 1 ir "+sar.getByIndex(1)+", 3 ir vietā ar indeksu "+ sar.getIndexByValue(3)+", aiz tā seko "+sar.getNext(3));
		sar.addLast(1);
		sar.addLast(7);
		sar.addLast(3);
		System.out.println("Beigās pievieno 1, 7, 3: "+ sar);
		sar.sort();
		System.out.println("Sakārto: "+ sar);
		
		Saraksts<Student> studenti = new Saraksts<>(3);
		studenti.addLast(new Student("Arija", "Gultne",  new int[]{5,4,2}));
		studenti.addLast(new Student("Boriss", "Straume", new int[] {6,2,3}));
		studenti.addLast(new Student("Volvo", "Brenss", new int[] {8,7,9}));
		studenti.addLast(new Student("Jana", "Hello", new int[] {2,2,2}));
		studenti.print();
		studenti.sort();
		studenti.print();
		
	}
	

}
