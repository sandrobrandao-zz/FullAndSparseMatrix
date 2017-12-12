package math;

import java.util.Arrays;

public class Vector<E> {

    private static final int START_CAPACITY = 1;
    private Object elementData[];
    private int size = 0;

    Vector(){
        this.elementData = new Object[START_CAPACITY];
    }

    Vector(int size){
        this.elementData = new Object[size];
    }

    public synchronized void add(E e) {
        if (size == elementData.length) {
            ensureCapacity(); //increase current capacity of list, make it double.
        }
        elementData[size++] = e;
    }

    public synchronized E get(int index) {
        //if index is negative or greater than size of size, we throw Exception.
        if ( index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        return (E) elementData[index]; //return value on index.
    }

    public synchronized Object remove(int index)
    {
        if ( index <0 || index>= size) {  //if index is negative or greater than size of size, we throw Exception.
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }

        Object removedElement=elementData[index];
        for(int i = index; i < size - 1; i++){
            elementData[i]=elementData[i+1];
        }
        size--;   //reduce size of VectorCustom after removal of element.
        return removedElement;
    }

    public synchronized void set(int index, E e) {
        //if index is negative or greater than size of size, we throw Exception.
        if ( index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index);
        }
        elementData[index] = e;
    }

    private void ensureCapacity() {
        int newIncreasedCapacity = elementData.length * 2;
        elementData = Arrays.copyOf(elementData, newIncreasedCapacity);
    }

    public void printElements() {
        for(int i = 0;i < size; i++){
            System.out.print(elementData[i] + " ");
        }
    }

    public int size(){
        return size;
    }

} // Vector