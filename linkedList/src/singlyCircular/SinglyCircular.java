package singlyCircular;

import java.util.Scanner;

class LinkedList {

	static class Node {
		private int data;
		private Node next;

		public Node() {
			data = 0;
			next = null;
		}

		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;

	LinkedList() {
		head = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int val) {
		// make a new node
		Node newNode = new Node(val);
		// check if list is empty
		if (isEmpty()) {
			head = newNode;
			newNode.next = head;
		}
		// else add at first pos
		else {
			Node trav = head;
			// traverse till last node
			while (trav.next != head)
				trav = trav.next;

			newNode.next = head;
			trav.next = newNode;
			head = newNode;
		}
	}

	public void addLast(int val) {
		Node newNode = new Node(val);

		if (isEmpty())
			addFirst(val);
		else {
			Node trav = head;
			// traverse till last node

			while (trav.next != head)
				trav = trav.next;

			trav.next = newNode;
			// make new node pointing to head;
			newNode.next = head;
		}
	}

	// add at position
	public void addPos(int val, int pos) {

		if (isEmpty() || pos <= 1) {
			addFirst(val);
		}

		else {
			Node newNode = new Node(val);
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {

				if (trav.next == head)
					break;
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
	}

	// display method
	public void display() {

		if (isEmpty())
			throw new RuntimeException("list is empty");
		else {
			// make a trav node and traverse till trav.next==head
			Node trav = head;
			do {
				System.out.println(trav.data);
				trav = trav.next;
			} while (trav != head);
		}
	}

	// del first method
	public void delFirst() {
		// check for empty
		if (isEmpty())
			throw new RuntimeException("Cannot delete:list is empty");
		// if list contains one element
		else if (head.next == head)
			head = null;

		else {
			Node trav = head;
			// traverse till last
			while (trav.next != head) {
				trav = trav.next;
			}
			head = head.next;
			trav.next = head;
		}
	}

	public void delLast() {
		// check for empty
		if (isEmpty())
			throw new RuntimeException("Cannot delete:list is empty");
		// if list contains only one element
		else if (head.next == head)
			head = null;
		else {
			Node trav = head, temp = null;
			while (trav.next != head) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = head;
		}
	}
	
	//method to del at position
	public void delPos(int pos) {
		Node trav=head,temp=null;
		if(isEmpty() || pos < 1)
			throw new RuntimeException("Cannot delete:list is empty");
		else if(pos == 1)
			delFirst();
		else {
			for(int i=1; i<pos; i++) {
				temp = trav;
				trav = trav.next;
				if(trav.next == head)
					break;
			}
			temp.next = trav.next; 
		}		
	}
	public void delAll() {
		head.next=null;
		head=null;
	}
	
}

public class SinglyCircular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean quit = false;
		while (!quit) {

			System.out.println("1:addFirst 2:addLast 3:addPos 4:display 5:delFirst 6:delLast 7:delPos 8:delAll 9:Quit");

			switch (sc.nextInt()) {
			case 1:

				System.out.println("Enter the value to add");
				list.addFirst(sc.nextInt());
				break;

			case 2:
				System.out.println("Enter the value to add");
				list.addLast(sc.nextInt());
				break;

			case 3:

				try {
					System.out.println("Enter the value, position");
					list.addPos(sc.nextInt(), sc.nextInt());
				} catch (Exception e) {

					System.out.println(e.getMessage());
					;
				}
				break;

			case 4:
				try {
					list.display();
				} catch (Exception e) {

					System.out.println(e.getMessage());
					;
				}

				break;

			case 5:
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:

				try {
					 list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 7:
				try {
					System.out.println("Enter position to del");
					 list.delPos(sc.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 8:
				list.delAll();
				break;
				
			case 9:
				quit = true;
				break;

			default:
				System.out.println("Plese enter a valid choice");
				break;
			}

		}
		sc.close();

	}

}
