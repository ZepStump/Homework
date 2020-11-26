package Homework7;

import java.util.Scanner;

public class MorseCodeTree extends BinaryTree<Character> {
	
	public MorseCodeTree()
	{
		createTreeFromFile();
	}
	
	public void createTreeFromFile()
	{
		//making full graph of length 4.
		BinaryTree<Character> MorseTree = new BinaryTree<Character>();
		BinaryTree<Character> RightTree = new BinaryTree<Character>();
		BinaryTree<Character> LeftTree = new BinaryTree<Character>();
		MorseTree.root = new Node<Character>('?');
		RightTree.root = new Node<Character>('?');
		LeftTree.root = new Node<Character>('?');
		for (int i=0;i<3;i++)
		{
		MorseTree = new BinaryTree('?', RightTree, LeftTree);
		RightTree = MorseTree;
		LeftTree = MorseTree;
		}
		this.root = MorseTree.root;
		
		
		//adding the letters
		Scanner scan = new Scanner("/Homework/src/Homework7/MorseCode.txt");
		for (int i=0; i<26; i++)
		{
		String temp = scan.nextLine();
		insertNodeIntoTree(temp);
		}
		scan.close();
	}
    
	//inserting the character in right place
	public void insertNodeIntoTree(String temp)
	{
		Node<Character> initialRoot = root;
		char current = temp.charAt(0);
		for (int j=2; j<temp.length(); j++) 
		{
			if (temp.charAt(j)=='-')
			{
				if (j==temp.length()-1)
				{
					root.right.setData(current);
					root=initialRoot;
				}
				else {
				root=root.right;}
			}
			if (temp.charAt(j)=='*')
			{
				if (j==temp.length()-1)
				{
					root.left.setData(current);
					root=initialRoot;
				}
				else {
				root=root.left;}
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
					current=root.right.getData();
					root=initialRoot;
				}
				else {
				root=root.right;}
			}
			if (temp.charAt(j)=='*')
			{
				if (j==temp.length()-1)
				{
					current=root.left.getData();
					root=initialRoot;
				}
				else {
				root=root.left;}
			}
		}
		
		return current;
	}
	
	public void readMorseCode()
	{
		
	}
	
    public String translateFromMorseCode(String morseCode) 
    {
        String code = "";
        int counter=0;
    	for (int i=0; i<morseCode.length(); i++)
        {
        	if (morseCode.charAt(i)==' ')
        	{
        		counter=1;
        		code = code + decodeCharacter(morseCode.substring(0,i));
        		translateFromMorseCode(morseCode.substring(i,morseCode.length()));
        	}
        }
    	if (counter==0)
    	{
    		code = code + decodeCharacter(morseCode);
    	}
    	return code;
    }

} 
