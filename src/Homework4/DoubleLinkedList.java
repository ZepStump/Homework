package Homework4;

import java.util.*;
//import java.util.AbstractSequentialList;
//import java.util.Iterator;
//import java.util.ListIterator;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  public void add(int index, E obj)
  { 
	listIterator(index).add(obj);
  }
  public void addFirst(E obj) {
	 listIterator(0).add(obj);
  }
  public void addLast(E obj) { 
	  listIterator(size).add(obj);
  }
  
  public boolean add(E obj)
  {
	  addLast(obj);
	  return true;
  }

  public E get(int index) 
  { 	
	  if (size==0)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  if (index>=size)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  ListIterator<E> iter = listIterator(index); 
      return iter.next();
  }
  
  public E set(int index, E obj)
  {
	  if (size==0)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  if (index>=size)
	  {
		  throw new IndexOutOfBoundsException();
	  }
	  ListIterator<E> iter = listIterator(index); 
      iter.set(obj);
      return iter.next();
  }
  public E getFirst() { 
	  return head.data;  
	  }
  public E getLast() { 
	  return tail.data;  
	  }

  public int indexOf(Object o)
  {
	  ListIterator<E> iter = listIterator();
	  int a=-1;
	  int b=0;
	  for (int i=0;i<size;i++)
	  {
		  if((iter.next().equals(0))&&(b==0))
		  {
			  a=i;
			  b=1;
		  }  
	  }
	  return a;
  }
  public void clear()
  {
	  head=null;
	  tail=null;
	  size=0;
	  this.listIterator(0);
  }
  public int size() {  
	  return size;  
  }
  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { 
	  return new ListIter(0);  
	  }
  public ListIterator listIterator() {
	  return new ListIter(0);  
	  }
  public ListIterator listIterator(int index){
	  return new ListIter(index);
	  }
  public ListIterator listIterator(ListIterator iter)
  {     
	  return new ListIter( (ListIter) iter);  
  }
  
 
  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {  
        	data = dataItem; 
        }
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     
    		throw new IndexOutOfBoundsException("Invalid index " + i); 
        }
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {     
        	index = size;     
        	nextItem = null;
        }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    
    }

    public boolean hasNext() 
    {   
    	return (nextItem != null);    
    }
    public boolean hasPrevious()
    {  
    	if (size==0)
    		return false;
    	else
    	return (nextItem == null && size != 0) || nextItem.prev != null;
    }
    public int previousIndex() { 
    	int a = index;
    	a--;
    	return a;    
    	}
    public int nextIndex() {
    	int a = index;
    	a++;
    	return a;   
    	}
    public void set(E o)  {
    	nextItem = new Node<E>(o);
    } 
    public void remove(){
    	if (nextItem==null)
    	{
    		throw new IllegalStateException();
    	}
    	else if (nextItem==head)
    	{
    		nextItem.next.prev=null;
    		head=nextItem.next;
    		nextItem=head;
    	}
    	else if (nextItem==tail)
    	{
    		nextItem.prev.next=null;
    		tail=nextItem.prev;
    		index--;
    	}
    	else
    	{
    		nextItem.prev.next=nextItem.next;
    		nextItem.next.prev=nextItem.prev;
    		nextItem=nextItem.next;
    	}
    }

    public E next()
    {  
        if (!hasNext()) {
        	throw new NoSuchElementException();
        }
        lastItemReturned = nextItem;
        nextItem = nextItem.next;
        index++;
        return lastItemReturned.data;
    }

    public E previous() 
    {  
    	if (!hasPrevious()){
    		throw new NoSuchElementException();
    	}
    	if (nextItem==null)
    	{
    		nextItem = tail;
    	}
    	else 
    	{
    		nextItem = nextItem.prev;
    	}
    	lastItemReturned = nextItem;
    	index--;
    	return lastItemReturned.data;
    }

    public void add(E obj) {
    	if (head==null)
    	{
    		head = new Node<E>(obj);
    		tail=head;
    	}
    	else if(nextItem==head)
    	{
    		Node<E> newNode = new Node<E>(obj);
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    		head = newNode;
    	}
    	else if(nextItem==null)
    	{
    		Node<E> newNode = new Node<E>(obj);
    		tail.next = newNode;
    		newNode.prev = tail;
    		tail = newNode;
    	}
    	else
    	{
    		Node<E> newNode = new Node<E>(obj);
    		newNode.prev = newNode.prev;
    		nextItem.prev.next = newNode;
    		newNode.next = nextItem;
    		nextItem.prev = newNode;
    	}
    	size++;
    	index++;
    	lastItemReturned=null;
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList
