package Homework3;

import java.util.LinkedList;

public class Polynomial 
{
	LinkedList<Term> list = new LinkedList<>();
	
	public Polynomial(Polynomial pol)
	{
		for (int i=0; i<pol.getNumTerms();i++)
		{
			Term term1=new Term();
			term1.setExponent(pol.getTerm(i).getExponent());
			term1.setCoefficient(pol.getTerm(i).getCoefficient());
			this.addTerm(term1);
		}
	}
	
	public Polynomial()
	{
		
	}
	
	public void addTerm(Term term1)
	{
		int a=0;
		if (list.size()!=0)
		{
		for (int i=0;i<list.size();i++)
		{
			if (term1.getExponent()==list.get(i).getExponent())
			{
				a=1;
				int b=term1.getCoefficient()+list.get(i).getCoefficient();
				term1.setCoefficient(b);
				list.set(i, term1);
				if (b==0)
					list.remove(i);
			}	
		}
		for (int i=0;i<list.size();i++)
		{
			if ((term1.getExponent()>list.get(i).getExponent())&&(a==0))
			{
				list.add(i, term1);
				a=1;
			}	
		}
		if (a==0)
			list.add(term1);
		}
		else
			list.add(term1);
	}
	
	public int getNumTerms()
	{
		return list.size();
	}
	
	public Term getTerm(int index)
	{
		return list.get(index);
	}
	
	public void clear()
	{
		list.clear();
	}
	
	public void add(Polynomial pol) 
	{
		for (int i=0;i<pol.list.size();i++)
		{
			this.addTerm(pol.list.get(i));
		}
	}
	
	public String toString()
	{
		String s = new String();
		LinkedList<Term> pol = new LinkedList<>();
		for (int i=0;i<list.size();i++)
		{
			Term term1=new Term();
			term1.setExponent(list.get(i).getExponent());
			term1.setCoefficient(list.get(i).getCoefficient());
			pol.add(term1);
		}
		
		for (int i=0;i<pol.size();i++)
		{
			String t;
			int a=0;
			t=pol.get(i).toString();
			if (t.charAt(0)=='-')
				a=1;
			if (t.length()!=0)
			{
				t=t.substring(1);
			}
			if (a==0)
				s=s+" + "+t;
			if (a==1)
				s=s+" - "+t;
			if (i==0)
			{
				if (a==0)
					s=t;
				else
					s="-"+t;
			}
		}
		if (pol.size()==0)
		{
			s="0";
		}
		return s;
	}
}
