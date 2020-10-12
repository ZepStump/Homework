package Homework3;

public class Term implements Comparable<Term> 
{
	private int exponent;
	private int coefficient;
	
	public Term(int coefficient, int exponent)
	{
		this.coefficient=coefficient;
		this.exponent=exponent;
	}
	
	public Term()
	{
		exponent=1;
		coefficient=1;
	}
	
	public Term(Term oldTerm)
	{
		exponent=oldTerm.exponent;
		coefficient=oldTerm.coefficient;
	}
	
	public Term(String t)
	{
		int a=0,b=0,c=0,e=0;
		char signC='+',signE='+';
		exponent=0;
		coefficient=0;

		//checking for coefficient sign
		if (t.charAt(0)=='+')
		b=1;
		if (t.charAt(0)=='-')
		{
			b=1;
			signC='-';
		}
		
		for (int i=0;i<t.length();i++)
		{
			if (t.charAt(i)=='^')
			{
				a=i;
				e=a;
			}	
		}
		if (a!=0) 
		{
		if(t.charAt(a+1)=='-')
		{
			e=a+1;
			signE='-';
		}
		for (int i=e+1;i<t.length();i++)
		{
			int d=(int)t.charAt(i);
			exponent=10*exponent+d;
		}
		for (int i=b;i<a-1;i++)
		{
			int d=(int)t.charAt(i);
			coefficient=10*coefficient+d;
		}
		}
		if (a==0)
		{
			for (int i=0;i<t.length();i++)
			{
				if (t.charAt(i)=='x')
				{
					exponent=1;
					c=i;
				}	
			}
			if (c==0)
				c=t.length();
			for (int i=b;i<c;i++)
			{
				int d=(int)t.charAt(i);
				coefficient=10*coefficient+d;
			}
		}
		
		if (signC=='-')
		{
			coefficient=-coefficient;		
		}
		if (signE=='-')
		{
			exponent=-exponent;
		}
		
	}
	
	@Override
	public int compareTo(Term oldTerm) 
	{
		int d = this.exponent-oldTerm.exponent;
		int c = this.coefficient-oldTerm.coefficient;
		
		if(d!=0)
		{
			return d;
		}
		else
			return c;
		
	}
	
	
	@Override
	public String toString()
	{
		
		String output="";
		if (coefficient>1)
			output=output+"+"+coefficient;
		if (coefficient==1)
			output=output+"+";
		if (coefficient==-1)
			output=output+"-";
		if (coefficient<-1)
			output=output+coefficient;
		if (coefficient==0)
			return "";
		
		if (exponent>1)
			output=output+"x^"+exponent;
		if (exponent==1)
			output=output+"x";
		if (exponent<0)
			output=output+"x^"+exponent;
		
		return output;
		 
	}
	
	public void setAll(int coefficient, int exponent)
	{
		this.coefficient = coefficient;
		this.exponent = exponent;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	
	@Override
	public Term clone()
	{
		Term newTerm=new Term();
		newTerm.coefficient=this.coefficient;
		newTerm.exponent=this.exponent;
		return newTerm;
	}

	@Override
	public boolean equals(Object term1)
	{
		Term term2 = (Term)term1;
		if((term2.exponent==this.exponent)&&(term2.coefficient==this.coefficient))
		return true;
		else
		return false;
		
	}

}
