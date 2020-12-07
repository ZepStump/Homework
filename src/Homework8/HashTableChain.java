package Homework8;

import java.util.LinkedList;

public class HashTableChain<K, V> implements KWHashMap<K, V> {
	
	private static class Entry<K, V>{
		
		private K key;
		private V value;
		
		public Entry(K key, V value)
		{
			this.key=key;
			this.value=value;
		}
		
		public K getKey()
		{
			return key;
		}
		
		public V getValue()
		{
			return value;
		}
		
		public V setValue(V val)
		{
			V oldVal = value;
			value = val;
			return oldVal;
		}
	}
	
	private LinkedList<Entry<K, V>> [] table;
	
	private int numKeys;
	
	private static final int CAPACITY = 101;
	
	private static final double LOAD_TRESHOLD = 3.0;
	
	public HashTableChain()
	{
		table = new LinkedList[CAPACITY];
	}
	
	public V get(Object key)
	{
		int index = key.hashCode() % table.length;
		if (index<0)
			index +=table.length;
		if (table[index]==null)
			return null;
	
		for (Entry<K, V> nextItem : table[index])
		{
			if(nextItem.key.equals(key))
				return nextItem.value;
		}
		
		return null;
	}
	
	public V put(K key, V value) 
	{
		int index = key.hashCode() % table.length;
		if (index<0)
			index +=table.length;
		if (table[index]==null)
			table[index] = new LinkedList<Entry<K, V>>();
		
		for (Entry<K, V> nextItem : table[index])
		{
			if (nextItem.key.equals(key))
			{
				V oldValue = nextItem.value;
				nextItem.setValue(value);
				return oldValue;
			}
		}
		
		table[index].addFirst(new Entry<K, V>(key, value)); 
		numKeys++;
		if (numKeys>(LOAD_TRESHOLD*table.length))
			rehash();
		return null;
	}
	
	
}
