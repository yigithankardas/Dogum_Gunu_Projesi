/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package arrayList;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Realization of a list by means of a dynamic array. This is a simplified
 * version of the java.util.ArrayList class.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ArrayList<E> implements List<E> {
	// instance variables
	/** Default array capacity. */
	public static final int CAPACITY = 16; // default array capacity

	/** Generic array used for storage of list elements. */
	protected E[] data; // generic array used for storage

	/** Current number of elements in the list. */
	private int size = 0; // current number of elements

	// constructors
	/** Creates an array list with default initial capacity. */
	public ArrayList() {
		this(CAPACITY);
	} // constructs list with default capacity

	/** Creates an array list with given initial capacity. */
	@SuppressWarnings({ "unchecked" })
	public ArrayList(int capacity) { // constructs list with given capacity
		data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
	}

	// public methods
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return number of elements in the list
	 */
	public int size() {
		return size;
	}

	/**
	 * Tests whether the array list is empty.
	 * 
	 * @return true if the array list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns (but does not remove) the element at index i.
	 * 
	 * @param i the index of the element to return
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()-1
	 */
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		return data[i];
	}

	/**
	 * Replaces the element at the specified index, and returns the element
	 * previously stored.
	 * 
	 * @param i the index of the element to replace
	 * @param e the new element to be stored
	 * @return the previously stored element
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()-1
	 */
	public E set(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		data[i] = e;
		return temp;
	}

	/**
	 * Inserts the given element at the specified index of the list, shifting all
	 * subsequent elements in the list one position further to make room.
	 * 
	 * @param i the index at which the new element should be stored
	 * @param e the new element to be stored
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()
	 */
	public void add(int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size + 1);
		if (size == data.length) // not enough capacity
			resize(2 * data.length); // so double the current capacity
		for (int k = size - 1; k >= i; k--) // start by shifting rightmost
			data[k + 1] = data[k];
		data[i] = e; // ready to place the new element
		size++;
	}
	
	public void add(E e) throws IndexOutOfBoundsException {
		add(this.size, e);
	}

	/**
	 * Removes and returns the element at the given index, shifting all subsequent
	 * elements in the list one position closer to the front.
	 * 
	 * @param i the index of the element to be removed
	 * @return the element that had be stored at the given index
	 * @throws IndexOutOfBoundsException if the index is negative or greater than
	 *                                   size()
	 */
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size);
		E temp = data[i];
		for (int k = i; k < size - 1; k++) // shift elements to fill hole
			data[k] = data[k + 1];
		data[size - 1] = null; // help garbage collection
		size--;
		return temp;
	}

	// utility methods
	/** Checks whether the given index is in the range [0, n-1]. */
	protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
		if (i < 0 || i >= n)
			throw new IndexOutOfBoundsException("Illegal index: " + i);
	}

	/** Resizes internal array to have given capacity >= size. */
	@SuppressWarnings({ "unchecked" })
	protected void resize(int capacity) {
		E[] temp = (E[]) new Object[capacity]; // safe cast; compiler may give warning
		for (int k = 0; k < size; k++)
			temp[k] = data[k];
		data = temp; // start using the new array
	}
	
	
	
	
	public boolean contains(E e) {
		for (E e2 : this) {
			if (e2.equals(e))
				return true;
		}
		return false;
	}
	
	
	
	

	// ---------------- nested ArrayIterator class ----------------
	/**
	 * A (nonstatic) inner class. Note well that each instance contains an implicit
	 * reference to the containing list, allowing it to access the list's members.
	 */
	private class ArrayIterator implements Iterator<E> {
		/** Index of the next element to report. */
		private int j = 0; // index of the next element to report
		private boolean removable = false; // can remove be called at this time?

		/**
		 * Tests whether the iterator has a next object.
		 * 
		 * @return true if there are further objects, false otherwise
		 */
		public boolean hasNext() {
			return j < size;
		} // size is field of outer instance

		/**
		 * Returns the next object in the iterator.
		 *
		 * @return next object
		 * @throws NoSuchElementException if there are no further elements
		 */
		public E next() throws NoSuchElementException {
			if (j == size)
				throw new NoSuchElementException("No next element");
			removable = true; // this element can subsequently be removed
			return data[j++]; // post-increment j, so it is ready for future call to next
		}

		/**
		 * Removes the element returned by most recent call to next.
		 * 
		 * @throws IllegalStateException if next has not yet been called
		 * @throws IllegalStateException if remove was already called since recent next
		 */
		public void remove() throws IllegalStateException {
			if (!removable)
				throw new IllegalStateException("nothing to remove");
			ArrayList.this.remove(j - 1); // that was the last one returned
			j--; // next element has shifted one cell to the left
			removable = false; // do not allow remove again until next is called
		}
	} // ------------ end of nested ArrayIterator class ------------

	/**
	 * Returns an iterator of the elements stored in the list.
	 * 
	 * @return iterator of the list's elements
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayIterator(); // create a new instance of the inner class
	}

	/**
	 * Produces a string representation of the contents of the indexed list. This
	 * exists for debugging purposes only.
	 *
	 * @return textual representation of the array list
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		for (int j = 0; j < size; j++) {
			if (j > 0)
				sb.append(", ");
			sb.append(data[j]);
		}
		sb.append(")");
		return sb.toString();
	}
	
	
	
	
	
	/*
	 *  Private class ArrayListIterator
	 *  Author: Yigithan Kardas			Number: 201101003
	 *  
	 *  This is a private ArrayListIterator class.
	 *  It has similar methods, method implementations and variables compared to default ArrayIterator class.
	 */
	private class ArrayListIterator implements ListIterator<E> {
		/*
		 * - 'j' will hold the index and 'removable' will be a flag for "remove" method.
		 */
		private int j;
		private boolean removable;
		
		/*
		 * 	- Since we have been informed that there will be seperate constructors, it is important to define class variables in the constructors. 
		 */
		public ArrayListIterator() {
			this.removable = false;
			this.j = 0;
		}
		
		/*
		 * 	- This is an overloaded version of the default constructor method.
		 * 	- Method accepts an integer ant sets it to the class variable 'j'.
		 */
		public ArrayListIterator(int j) {
			this.removable = false;
			this.j = j;
		}
		
		/*
		 * 	- The methods that defined below are came from ListIterator interface.
		 */
		
		/*
		 * 	- "add" method accepts an element and adds it to the ArrayList.
		 * 	- Then default index is incremented and flag is set to false.
		 */
		@Override
		public void add(E e) {
			ArrayList.this.add(j++, e);
			removable = false;
		}
		
		/*
		 * - "hasNext" method returns true if the default index is smaller than ArrayLists (size - 1) because indexes start from 0 to (size - 1).
		 * - Otherwise, returns false.
		 */	
		@Override
		public boolean hasNext() {
			return j < size - 1;
		}
		
		/*
		 * - "hasPrevious" method returns true if the default index is larger than 0. Otherwise, returns false.
		 */
		@Override
		public boolean hasPrevious() {
			return j > 0;
		}
		
		/*
		 * - "next" method throws an Exception if the default index is equal to (size - 1) which means there is not any next elemenet/index.
		 * - If not, flag is set to true and returns the elemenet at the current index in the ArrayList also increments the index so the index will be ready for future operations.
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (j == size - 1)
				throw new NoSuchElementException("There is not any next element");
			removable = true;
			return ArrayList.this.get(j++);	
		}
		
		/*
		 * - "nextIndex" method throws an Exception if default index is equal to (size - 1) which means there is not next element/index.
		 * - If not, returns the next index.
		 */
		@Override
		public int nextIndex() throws NoSuchElementException {
			if (j == size - 1)
				throw new NoSuchElementException("There is not any next index");
			return j + 1;
		}
		
		/*
		 * - "previous" method throws an Exception if default index is equal to 0 because it means there is not previous element/index.
		 * - If not, flag is set to true and the program returns the element at the current index in the ArrayList. Also the index is decremented for future operations.
		 */
		@Override
		public E previous() throws NoSuchElementException {
			if (j == 0)
				throw new NoSuchElementException("There is not any previous element");
			removable = true;
			return ArrayList.this.get(j--);
		}
		
		/*
		 * - "previousIndex" method throws an Exception if default index is equal to 0 because it means there is not previous element/index.
		 * - If not, returns the previous index.
		 */
		@Override
		public int previousIndex() throws NoSuchElementException {
			if (j == 0)
				throw new NoSuchElementException("There is not any previous element");
			return j - 1;
		}
		
		/*
		 * - "remove"method throws an Exception if the flag is false because the flag determines whether this method will work or not.
		 * - If not, the element at the current index in the ArrayList will be removed and flag will be set to false. Because the program do not allow the user for multiple remove operations.
		 */
		@Override
		public void remove() throws IllegalStateException {
			if (! removable)
				throw new IllegalAccessError("There is nothing to remove");
			ArrayList.this.remove(j--);
			removable = false;
		}
		
		/*
		 * - "set" method accepts an element and updates the element at the current index in the ArrayList.
		 */
		@Override
		public void set(E e) {
			ArrayList.this.set(j, e);
		}
	} // This is the end of the ArrayListIterator class.
	
	
	/*
	 * - "listIterator" method returns an instance of ArrayListIterator.
	 * - Also this method has one of its overloaded version below.
	 */
	public ListIterator<E> listIterator() {
		return new ArrayListIterator();
	}
	
	/*
	 * - "listIterator" method returns an instance of ArrayListIterator.
	 * - Also this method has one of its overloaded version above.
	 */
	public ListIterator<E> listIterator(int j) {
		return new ArrayListIterator(j);
	}
}
