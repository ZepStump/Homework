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
		exponent=0;
		coefficient=0;
	
		
		int a=0,b=0,c=0,e=0;
		// "a" is coordinate of "x", "b" is just if there is a sign in the beginning, for looping purposes
		// "c" is for coefficient 1, when we have coefficient 1
		// "e" is for exponent 1;
		
		char signC='+',signE='+';
		//sign of coefficient
		
		//checking for signs
		if (t.charAt(0)=='+')
		{
			b=1;
			c=1;
		}	
		if(t.charAt(0)=='-')
		{
			b=1;
			c=1;
			signC='-';
		}
		
		//finding 'x' coordinate
		for (int i=0;i<t.length();i++)
		{
			if (t.charAt(i)=='x')
			{
				a=i;
				e=1;
			}
		}
		//if exponent not zero
		if (a!=0)
		{
			//setting coefficient
			for (int i=b;i<a;i++)
			{
				int d=(int)t.charAt(i)-'0';
				coefficient=10*coefficient+d;
			}
			//cecking for sign of the exponent
			for (int i=b;i<t.length();i++)
			{
				if (t.charAt(i)=='^')
					a=i;
				if (t.charAt(i)=='-')
				{	
					signE='-';
					a=i;
				}	
			}
			//setting exponent
			for (int i=a+1;i<t.length();i++)
			{
				int d=(int)t.charAt(i)-'0';
				exponent=exponent*10+d;
			}
		}
		
		if (a==0)
		{
			for (int i=b;i<t.length();i++)
			{
				int d=(int)t.charAt(i)-'0';
				coefficient=(10*coefficient)+d;	
			}
		}
		
		
		// if exponent or coefficient is zero
		if((coefficient==0)&&(c==1))
			coefficient=1;
		if((exponent==0)&&(e==1))
			exponent=1;
		
		if (signE=='-')
		{
			exponent=-exponent;
		}
		if(signC=='-')
		{
			coefficient=-coefficient;
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
