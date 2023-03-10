package model;

import java.util.Arrays;

public class Saraksts<T> {
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Saraksts (int length) {
		if (length > 0) {
			array = (T[]) new Object[length];	//atradu stackoverflow
		}
		else {
			array = (T[]) new Object[1];
		}
		this.size = 0;
	}
	
	public boolean isFull() {
		if (size == array.length) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		return (size == 0)? true:false;
	}
	public int getSize() {return size;}
	public int getLength() {return array.length;}
	@SuppressWarnings("unchecked")
	private void increaseLength() {
		int newlength = array.length>100 ? (int)(array.length * 1.5): array.length*2; //zem 100 dubulto, citādi *1.5
		T[] newarray = (T[]) new Object[newlength];
		for (int i = 0; i < array.length; i++) {newarray[i] = array[i];}
		array = newarray;
	}
	public void addLast(T i) {
		if (size<array.length) { 
			array[size] = i; //varētu arī [size++]
			size++;
		}
		else {
			increaseLength();
			array[size] = i; //varētu arī [size++]
			size++;
		}
	}
	public void addByIndex(T val, int index) {
		if (index >= 0 && index < size) {
			T temp = array[index];
			array[index] = val;
			size++;
			if (size >= array.length) {increaseLength();}
			for (int i = index+1; i < size; i++ ) {
				T temp2 = array[i]; //šis šķiet nesmuki
				array[i] = temp;
				temp = temp2;
			}	
		}
		else {
			throw new IndexOutOfBoundsException("addByIndex index out of bounds");
		}
	}
	public T removeByIndex(int index) {
		if (index >= 0 && index < size) {
			T retVal = array[index];
			for (int i = index; i < size-1; i++) {
				array[i] = array[i+1];
			}
			size--;
			return retVal;
		}
		throw new IndexOutOfBoundsException("removeByIndex index out of bounds");
	}
	public T getByIndex(int index) {
		if (index >= 0 && index < size) {
			return array[index];
		}
		throw new IndexOutOfBoundsException("getByIndex index out of bounds");
	}
	public int getIndexByValue(T query) {
		for (int i = 0; i<size; i++) {
			if (array[i].equals(query)) {
				return i;
			}
		}
		return -1;
	}
	public T getNext(T query) {
		int foundIndex = getIndexByValue(query);
		if (foundIndex >= 0) {
			if ((foundIndex+1) < size) {
				return array[foundIndex+1];
			}
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public void sort() {
		T[] sortablearray = (T[]) new Object[size]; //nepieciešams jo Arrays.sort nepieņem null vērtības
		for (int i = 0; i < size; i++) {sortablearray[i] = array[i];}
		Arrays.sort(sortablearray);
		for (int i = 0; i < size; i++) {array[i] = sortablearray[i];}
	}
	
	@Override
	public String toString() {
		String retStr = "array = [";
		if (size > 0) {retStr += array[0].toString();}
		for (int i = 1; i < size; i++) {retStr += ", "+ array[i].toString() ;}
		retStr += "]";
		return retStr;
	}
	public void print() {
		System.out.println(this);
	}
	@SuppressWarnings("unchecked")
	public void clear() {
		array = (T[]) new Object[1];
		size = 0;
	}
}
