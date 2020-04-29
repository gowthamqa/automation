package interview;

import java.util.LinkedList;
import java.util.Stack;

public class StackImplementationUsingLinkedList {
	
	LinkedList<Integer> stack = new LinkedList<Integer>();
	
	Stack<Integer> s = new Stack<Integer>();
	
	
	int size() {
		return stack.size();
	}
	
	int peek() {
		return stack.getLast();
	}
	
	int pop() {
		return stack.removeLast();
	}
	
	void push(int a) {
		stack.addLast(a);
	}
	
	public static void main(String[] args) {
		StackImplementationUsingLinkedList stack = new StackImplementationUsingLinkedList();
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
		
	}

}
