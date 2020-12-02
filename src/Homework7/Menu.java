package Homework7;

import java.io.File;
import java.util.Scanner;

public class Menu 
{
	public static void main(String[] args)
	{
		MorseCodeTree morseTree = new MorseCodeTree();
		System.out.println("Hello, Choose one of the three options:");
		System.out.println("1: See the alphabet for morse code");
		System.out.println("2: Read code from file");
		System.out.println("3: Translate code");
		
		Scanner key = new Scanner(System.in);
		int choice = key.nextInt();
		key.nextLine();
		
		switch (choice) {
			
			case 1: 
				morseTree.readMorseTree();
				System.exit(0);
				break;
			case 2:
				String fileName = key.nextLine();
				File file = new File(fileName);
				try {
					Scanner scan = new Scanner(file);
					while (scan.hasNext())
					{
						morseTree.translateFromMorseCode(scan.nextLine());
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception was trown");
				}
				System.exit(0);
				break;
				
			case 3:
				//String s = key.nextLine();
				System.out.println(morseTree.translateFromMorseCode(key.nextLine()));
				System.exit(0);
				break;		
		}		
	}
}
