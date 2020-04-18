import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyVector<E> extends MyAbstractList<E>{

    E[] mylist;
    public int increment = 5;
    public int capacity;

    @SuppressWarnings("unchecked")
    public MyVector(){
        mylist = (E[]) new Object[10];
        capacity = 10;
        size = 0;

    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity){
        mylist = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public MyVector(int capacity, int increment){
        mylist = (E[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.increment = increment;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getIncrement(){
        return increment;
    }

    @Override
    public boolean add(E data) {

        for ( int i = 0 ; i < mylist.length ; i++ ){
            if ( mylist[i] == null ){
                mylist[i] = data;
                return true;
            }

        }

        Arrays.copyOf(mylist, mylist.length+increment);
        capacity += increment;

        for ( int i = 0 ; i < mylist.length ; i++ ){
            if ( mylist[i] == null ){
                mylist[i] = data;
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {

        for ( int i = capacity ; i > index ; i-- ){
            mylist[i] = mylist[i-1];

        }

        mylist[index] = data;

        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(mylist, null);
    }

    @Override
    public E get(int index) {
        return mylist[index];
    }

    @Override
    public E remove(int index) {

        E temp = mylist[index];

        for (int i = index; i < mylist.length - 1 ; i++ ){
            mylist[i] = mylist[i+1];

        }

        return temp;

    }

    @SuppressWarnings("unchecked")
    @Override
    public void trimToSize() {
        int numData = 0;

        for ( int i = 0 ; i < capacity ; i++ ) {
            if (mylist[i] != null) {
                numData++;
            }
        }

        E[] myTrimmedList = (E[]) new Object[numData];

        for ( int i = 0 ; i < numData ; i++ ){
            myTrimmedList[i] = mylist[i];

        }

        mylist = Arrays.copyOf(myTrimmedList, numData);
        

    }

    @Override
    public int size(){
        int numElements = 0;

        for ( int i = 0 ; i < capacity ; i++){
            if (mylist[i] != null ) {
                numElements++;

            }

        }

        size = numElements;
        return numElements;
    }

    @Override
    public String toString() {
        trimToSize();
        return Arrays.toString(mylist);
    }

    @Override
    public boolean isEmpty() {
        if ( mylist[0] == null ){
            return true;
        }else{
            return false;
        }

    }
}
