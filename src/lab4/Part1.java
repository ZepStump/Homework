package lab4;

import java.util.ArrayList;

public class Part1 {

	public static void remove(ArrayList<String> aList, String OldItem, String newItem)
	{
		for (int i=0;i<aList.size();i++)
		{
			if (aList.get(i)==OldItem)
			{
				aList.set(i, newItem);
			}
		}
	}
	
	public static void delete(ArrayList<String> aList, String target)
	{
		int index=0;
		for (int i=0;i<aList.size();i++)
		{
			if ((aList.get(i)==target)&&(index==0))
			{
				aList.remove(i);
				index++;
			}
		}
	}
	
}
