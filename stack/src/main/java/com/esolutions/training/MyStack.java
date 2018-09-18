package com.esolutions.training;

/**
 * 
 * @author Emanuel_Ocampo
 *
 * @param <T>
 */
public class MyStack <T>{
	private int size;
	private Object[] element; 
	
	public MyStack(int capacity){
		if (capacity < 0){
			throw new NegativeCapacityException("The capacity has to be >= 0, and is " + capacity + ".");
		}
		element = new Object[capacity];
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size;
	}

	public void push(T elem) {
		if(size >= element.length){
			throw new StackOverFlowException();
		}
		element[size++] = elem;
	}

	public T pop() {
		if (isEmpty()){
			throw new StackUnderFlowException();
		}
		return castValue(--size);
	}
	
	public T top() {
		if (isEmpty()){
			throw new StackEmptyException();
		}
		return castValue(size - 1);
	}
	
	/**
	 * Cast an element from Object type to T type.
	 * 
	 * @param index
	 * @return An element T's type
	 */
    @SuppressWarnings("unchecked")
    private T castValue(int index) {
		return (T)element[index];
    }
    
    public static final class NegativeCapacityException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public NegativeCapacityException(String message) {
            super(message);
    	}
    }
    
    public static final class StackOverFlowException extends RuntimeException {
		private static final long serialVersionUID = 1L;
    }
    
    public static final class StackUnderFlowException extends RuntimeException {
		private static final long serialVersionUID = 1L;
    }
    
    public static final class StackEmptyException extends RuntimeException {
		private static final long serialVersionUID = 1L;
    }
}
