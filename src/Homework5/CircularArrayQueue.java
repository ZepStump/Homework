package Homework5;

import java.awt.IllegalComponentStateException;
import java.util.*;

public class CircularArrayQueue<E> extends AbstractQueue<E>{
	
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private E[] theData;
	
	public CircularArrayQueue(){
		this(10);
	}
	
	public CircularArrayQueue(int i)
	{
		capacity=i;
		theData = (E[]) new Object[capacity];
		front=0;
		rear=capacity-1;
		size=0;
	}
	
	public boolean offer(E item)
	{
		if (size==capacity)
		{
			reallocate();
		}
		size++;
		rear=(rear+1)%capacity;
		theData[rear]=item;
		return true;
	}
	
	public boolean add(E item)
	{
		if (size==capacity)
		{
		throw new IllegalStateException();
		}
		else
		{
		size++;
		rear=(rear+1)%capacity;
		theData[rear]=item;
		return true;
		}
	}
	
	public E peek()
	{
		if (size==0)
			return null;
		else
			return theData[front];
	}
	
	public E element()
	{
		if (size==0)
			throw new NoSuchElementException();
		else
			return theData[front];
	}
	
	public E poll()
	{
		if (size==0)
			return null;
		else
		{
			E result = theData[front];
			front=(front+1)%capacity;
			size--;
			return result;
		}
	}
	
	public E remove()
	{
		if (size==0)
			throw new NoSuchElementException();
		else
		{
			E result = theData[front];
			front=(front+1)%capacity;
			size--;
			return result;
		}
	}
	
	private void reallocate()
	{
		int newCapacity = 2*capacity;
		E[] newData =(E[]) new Object[newCapacity];
		int j=front;
		for (int i=0;i<size;i++)
		{
			newData[i]=theData[j];
			j=(j+1)%capacity;
		}
		front=0;
		rear=size-1;
		capacity=newCapacity;
		theData=newData;
	}
	
	public int size()
	{
		return size;
	}
	
	public Iterator<E> iterator()
	{
		return new Iter();
	}
	
	private class Iter implements Iterator<E>
	{
		private int index;
		private int count=0;
		
		public Iter()
		{
			index=front;
		}
		
		public boolean hasNext()
		{
			return count<size;
		}
		
		public E next()
		{
			if (!hasNext())
			{
				throw new IllegalStateException();
			}
			E returnValue = theData[index];
			index=(index+1)%capacity;
			count++;
			return returnValue;
		}
		
	}

}
