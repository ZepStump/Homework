package Homework7;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MorseCodeTree extends BinaryTree<Character>{
	
	//file for creating a tree, with alphabet
	File file = new File("src/Homework7/MorseCode.txt");
	
	public MorseCodeTree()
	{
		//making a Morse tree
		createTreeFromFile(file);
	}
	
	//actually making a Morse tree
	public void createTreeFromFile(File fileName)
	{
		//making a tree
		root = new Node<Character>('?');
		
		//adding the letters
		String[] list = new String[26];
		
		try {
	    //reading a file
		Scanner scan = new Scanner(fileName);
		for (int i=0; i<26; i++)
		{
		list[i] = scan.nextLine();
		}
		scan.close();
		}
		catch(Exception e)
		{
			System.out.println("File not found");
		}
		
		//inserting nodes
		for (int i=0;i<26;i++)
		{
			insertNodeIntoTree(list[i]);
		}
 }
    
	//inserting the character in right place
	public void insertNodeIntoTree(String temp)
	{
		Node<Character> initialRoot = root;
		// actual character
		char current = temp.charAt(0);
		//start with two because first is a character and then an empty space
		for (int j=2; j<temp.length(); j++) 
		{
			if (temp.charAt(j)=='-')
			{
				//checking if next node exists, if not add it
				if (initialRoot.right==null)
				{
					initialRoot.right = new Node<Character>('?');
				}
				
				//checking if it is last turn
				if (j==temp.length()-1)
				{
					initialRoot.right.setData(current);
				}
				else 
				initialRoot=initialRoot.right;
			}
			if (temp.charAt(j)=='*')
			{
				if (initialRoot.left==null)
				{
					initialRoot.left = new Node<Character>('?');
				}
				
				//checking if it is last turn
				if (j==temp.length()-1)
				{
					initialRoot.left.setData(current);
				}
				else 
				initialRoot=initialRoot.left;
			}
		}
	}
	
	//decoding a character
	public char decodeCharacter(String temp)
	{
		Node<Character> initialRoot = root;
		char current = ' ';
		for (int j=0; j<temp.length(); j++) 
		{
			if (temp.charAt(j)=='-')
			{
				//if it is a last turn then we get Character
				if (j==temp.length()-1)
				{
					current=initialRoot.right.getData();
				}
				//if it is not a last turn then we turn
				else {
				initialRoot=initialRoot.right;}
			}
			if (temp.charAt(j)=='*')
			{				
				if (j==temp.length()-1)
				{
					current=initialRoot.left.getData();
				}
				else {
				initialRoot=initialRoot.left;}
			}
		}
		
		return current;
	}
	
	//for menu purposes, just reading am alphabet
	public void readMorseTree()
	{
		String[] list = new String[26];
		try {
			//File file = new File("src/Homework7/MorseCode.txt");
			Scanner scan = new Scanner(file);
			for (int i=0; i<26; i++)
			{
			list[i] = scan.nextLine();
			System.out.println(list[i]);
			}
			scan.close();
			}
			catch(Exception e)
			{
				System.out.println("File not found");
			}
	}
	
    public String translateFromMorseCode(String morseCode) 
    {
        String code = "";
        int count=0;
        //checking for single character(base case)
        for (int i=0; i<morseCode.length(); i++)
        {
        	if (morseCode.charAt(i)==' ')
        	{
        		count++;
        	}
        	// checking for exception
        	if (morseCode.charAt(i)!=' ' && morseCode.charAt(i)!='-' 
        			&& morseCode.charAt(i)!='*')
        		throw new InputMismatchException();
        }
        if (count==0)
    	{
    		code = code + decodeCharacter(morseCode);
    	}
        
        //we need count here otherwise it would do multiple recursions
        int count2 = 0;
        //Translating all character using recursion
    	for (int i=0; i<morseCode.length(); i++)
        {
        	if (morseCode.charAt(i)==' ' && count2 == 0)
        	{
        		count2++;
        		//decoding first character
        		code = code + decodeCharacter(morseCode.substring(0,i));
        		code = code + translateFromMorseCode(morseCode.substring(i+1));
        	}
        }
    	
    	return code;
    }

} 
