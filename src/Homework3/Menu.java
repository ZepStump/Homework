package Homework3;

import java.util.Scanner;

public class Menu 
{
	public static void main(String[] args)
	{
		int e=1;
		Polynomial pol1=new Polynomial();
		Polynomial pol2=new Polynomial();
		
		
		
		while(e!=0)
		{
			System.out.println("=========================");
			System.out.println("Polynomial 1: "+pol1.toString());
			System.out.println("Polynomial 2: "+pol2.toString());
			System.out.println("Choose one:");
			System.out.println("1.Change Polynomial 1");
			System.out.println("2.Change Polynomial 2");
			System.out.println("3.Dislay the result");
			System.out.println("4.Exit");
			System.out.println("=========================");
			
			Scanner key=new Scanner(System.in);
			String s=key.nextLine();
			switch (s)
			{
			case "1":
				System.out.println("Choose one:");
				System.out.println("1.Clear");
				System.out.println("2.New");
				System.out.println("3.Add terms");
				
				String t=key.nextLine();
				switch (t)
				{
				case "1":
					pol1.clear();
					break;
					
				case "2":
					pol1.clear();
					String p=key.nextLine();
					
					add(pol1, p);
					break;
					
				case "3":
					
				String l=key.nextLine();
					
				add(pol1, l);
					
				break;
				}
				break;
			case "2":
				System.out.println("Choose one:");
				System.out.println("1.Clear");
				System.out.println("2.New");
				System.out.println("3.Add terms");
				
				String y=key.nextLine();
				switch (y)
				{
				case "1":
					pol2.clear();
					break;
					
				case "2":
					pol2.clear();
					String p=key.nextLine();
					
					add(pol2, p);
				break;
				
				case "3":
					String r=key.nextLine();
					
					add(pol2, r);
				break;	
				}
				break;
			case "3":
				Polynomial temp = new Polynomial(pol1);
				Polynomial temp2 = new Polynomial(pol2);
				temp.add(temp2);
				System.out.println("The sum of two polynomials: "+temp.toString());
				break;
				
			case "4":
				key.close();
				System.exit(0);
			}
		}
	}
	
	public static void add(Polynomial pol1, String p)
	{
		//String p=key.nextLine();
		int a=0,sign=1;
		for (int i=0;i<p.length();i++)
		{
			if ((a==0)&&((p.charAt(i)=='-')||(p.charAt(i)=='+')))
					{
						String f=p.substring(0,i-1);
						if (sign==1)
							f="+"+f;
						if (sign==-1)
							f="-"+f;
						Term term1=new Term(f);
						pol1.addTerm(term1);
						if (p.charAt(i)=='-')
						{
							sign=-1;
						}
						a=i+2;									
					}
		}
		for (int i=a;i<p.length();i++)
		{
			if (((p.charAt(i)=='+')||(p.charAt(i)=='-'))&&(p.charAt(i+1)==' '))
			{
				String f=p.substring(a,i-1);
				if (sign==1)
					f="+"+f;
				if (sign==-1)
					f="-"+f;	
				Term term1=new Term(f);
				System.out.println(term1.toString());
				pol1.addTerm(term1);
				if (p.charAt(i)=='-')
					sign=-1;
				if(p.charAt(i)=='+')
					sign=1;
				a=i+2;
			}
		}
		if (a<p.length())
		{
			String f=p.substring(a);
			if (sign==1)
				f="+"+f;
			if (sign==-1)
				f="-"+f;
			Term term1=new Term(f);
			//System.out.println(term1.toString());
			pol1.addTerm(term1);
		}
		System.out.println(pol1.toString());
	}
}
