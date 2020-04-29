package interview;

public class LinkedListI {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			this.data = d;
			this.next = null;
		}
	}

	static LinkedListI insert(LinkedListI list, int data) {
		Node new_node = new Node(data);
		// new_node.next = null;
		if (list.head == null) {
			list.head = new_node;
		} else {
			Node temp = list.head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new_node;
		}
		return list;
	}

	public static void main(String[] args) {
		LinkedListI list = new LinkedListI(); 
		  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3);
	}

}
