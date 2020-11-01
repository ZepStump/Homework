package Homework5;

import java.util.List;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {

    private List<E> theData;

    public ArrayListStack() {
        theData = new ArrayList<E>();
    }

    @Override
    public E push(E obj) {
        theData.add(obj);
        return obj;
    }

    @Override
    public E peek() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return theData.get(theData.size() - 1);
    }

    @Override
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return theData.remove(theData.size() - 1);
    }

    @Override
    public boolean empty() {
        return theData.size() == 0;
    }
}

