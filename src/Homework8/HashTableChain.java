package Homework8;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class HashTableChain<K, V> implements Map<K, V> {
	
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
		
		public String toString() {
            return  key + "=" + value  ;
        }
	}
	
	
	
	private LinkedList<Entry<K, V>> [] table;
	
	private int numKeys;
	
	private static final int CAPACITY = 101;
	
	private static final double LOAD_TRESHOLD = 3.0;
	
	
	
	
	  private class EntrySet extends AbstractSet<Map.Entry<K, V>> {


	        @Override
	        public Iterator<Map.Entry<K, V>> iterator() {
	            return new SetIterator();
	        }

	        @Override
	        public int size() {
	            return numKeys ;
	        }
	    }

	    ////////////// end EntrySet Class //////////////////////////////

	    //////////////   SetIterator Class ////////////////////////////

	    /**
	     * Class that iterates over the table. Index is table location
	     * and lastItemReturned is entry
	     */
	    private class SetIterator implements Iterator<Map.Entry<K, V>> {

	        private int index = 0 ;
	        private Entry<K,V> lastItemReturned = null;
	        private Iterator<Entry<K, V>> iter = null;

	        @Override
	        public boolean hasNext() {
	        	// FILL HERE
	        }

	        @Override
	        public Map.Entry<K, V> next() {
	        	// FILL HERE
	        }

	        @Override
	        public void remove() {
	        	// FILL HERE
	        }
	    }

	    ////////////// end SetIterator Class ////////////////////////////

	    /**
	     * Default constructor, sets the table to initial capacity size
	     */
	    public HashTableChain()
		{
			table = new LinkedList[CAPACITY];
		}

	    // returns number of keys
	    @Override
	    public int size() {
	        return numKeys;
	    }

	    // returns boolean if table has no keys
	    @Override
	    public boolean isEmpty() {
	    	return (numKeys==0);
	    }

	    // returns boolean if table has the searched for key
	    @Override
	    public boolean containsKey(Object key) {
	    	// Fill Here
	    }

	    // returns boolean if table has the searched for value
	    @Override
	    public boolean containsValue(Object value) {
	    	// FILL HERE
	    	
	    }

	    // returns Value if table has the searched for key
	    @Override
	    public V get(Object key) {
	    	
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

	    // adds the key and value pair to the table using hashing
	    @Override
	    public V put(K key, V value) {
	    	
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


	    /**
	     * Resizes the table to be 2X +1 bigger than previous
	     */
	    private void rehash() {
	    	// FILL HERE
	    }

	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder() ;
	        for (int i = 0 ; i < table.length ; i++ ) {
	            if (table[i] != null) {
	                for (Entry<K, V> nextItem : table[i]) {
	                    sb.append(nextItem.toString() + " ") ;
	                }
	                sb.append(" ");
	            }
	        }
	        return sb.toString() ;

	    }

	    // remove an entry at the key location
	    // return removed value
	    @Override
	    public V remove(Object key) {
	    	// FILL HERE
	    }

	    // throws UnsupportedOperationException
	    @Override
	    public void putAll(Map<? extends K, ? extends V> m) {
	        throw new UnsupportedOperationException() ;
	    }

	    // empties the table
	    @Override
	    public void clear() {
	    	// Fill HERE
	    }

	    // returns a view of the keys in set view
	    @Override
	    public Set<K> keySet() {
	    	// FILL HERE
	    }

	    // throws UnsupportedOperationException
	    @Override
	    public Collection<V> values() {
	        throw new UnsupportedOperationException() ;
	    }


	    // returns a set view of the hash table
	    @Override
	    public Set<Map.Entry<K, V>> entrySet() {
	    	// FILL HERE


	    }

	    @Override
	    public boolean equals(Object o) {
	    	// FILL HERE

	    }

	    @Override
	    public int hashCode() {
	    	//FILL HERE

	    }
}
