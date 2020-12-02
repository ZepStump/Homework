package Homework7;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MorseCodeTree extends BinaryTree<Character>{
	
	public MorseCodeTree()
	{
		createTreeFromFile();
	}
	
	public void createTreeFromFile()
	{
		//making a tree
		root = new Node<Character>('?');
		
		//adding the letters
		String[] list = new String[26];
		
		try {
		File file = new File("src/Homework7/MorseCode.txt");
		Scanner scan = new Scanner(file);
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
		
		for (int i=0;i<26;i++)
		{
			insertNodeIntoTree(list[i]);
		}
 }
    
	//inserting the character in right place
	public void insertNodeIntoTree(String temp)
	{
		Node<Character> initialRoot = root;
		Node<Character> emptyNode = new Node<Character>('?');
		char current = temp.charAt(0);
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
	
	public char decodeCharacter(String temp)
	{
		Node<Character> initialRoot = root;
		char current = ' ';
		for (int j=0; j<temp.length(); j++) 
		{
			if (temp.charAt(j)=='-')
			{
				if (j==temp.length()-1)
				{
					current=initialRoot.right.getData();
				}
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
        		code = code + decodeCharacter(morseCode.substring(0,i));
        		code = code + translateFromMorseCode(morseCode.substring(i+1));
        	}
        }
    	
    	System.out.println("Final " + code);
    	return code;
    }

} 
