package interview;



public class StackImplementationUsingArray {
	
	private int[] array;
	private int top;
	private int capacity;
	
	public StackImplementationUsingArray(int capacity) {
		this.array = new int[capacity];
		this.capacity = capacity;
		this.top = -1;
	}
	
	public StackImplementationUsingArray() {
		this.array = new int[10];
		this.capacity = 10;
		this.top = -1;
	}
	
	public void push(int number) {
		if(isFull()) {
			throw new RuntimeException("Stack is Full");
		}
		array[++top] = number;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return array[top--];
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return array[top];
	}
	
	public int size() {
		//return top+1;
		return capacity;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == capacity-1;
	}
	
	public static void main(String[] args) {
		StackImplementationUsingArray stack = new StackImplementationUsingArray(25);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(5);
		stack.push(6);
		stack.push(7);
		System.out.println(stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.peek());
		StackImplementationUsingArray stack2 = new StackImplementationUsingArray();
		stack2.push(23);
		System.out.println(stack2.peek());
		StackImplementationUsingArray stack1 = new StackImplementationUsingArray(0);
		stack1.push(23);		
	}

}
