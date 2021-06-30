package singly;

import java.util.Scanner;

//make singlylist class
class LinkedList {

	// make a static node class

	static class Node {
		private int data;
		private Node next;

		// write one parameterless const
		public Node() {
			data = 0;
			next = null;
		}

		// parameterized const
		public Node(int val) {
			data = val;
			next = null;
		}
	}// static class close

	// head pointer
	private Node head;

	public LinkedList() {
		head = null;
	}

	// check for isempty
	public boolean isEmpty() {
		return head == null;

	}

	// method to addFirst

	public void addFirst(int val) {
		// make newnode
		Node newNode = new Node(val);
		// if list is empty make head = newnode
		if (isEmpty())
			head = newNode;

		// else add
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	// method to add last
	public void addLast(int val) {
		Node newNode = new Node(val);
		if (isEmpty())
			head = newNode;
		else {
			Node trav = head;
			// traverse till last node
			while (trav.next != null)
				trav = trav.next;
			// make last node equal to newNode
			trav.next = newNode;
		}
	}

	public void addPos(int val, int pos) {

		// if list is empty or it is first node
		if (head == null || pos <= 1) {
			addFirst(val);
		} else {
			// creat a newnode
			Node newNode = new Node(val);
			// traverse till position
			Node trav = head;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)
					break;
				trav = trav.next;
			}
			// newnodes next should point to trav's next
			newNode.next = trav.next;
			// trav's next should point to new node
			trav.next = newNode;
		}
	}

	// method to display
	public void display() {
		// make pointer
		Node trav = head;
		// check if list is empty
		if (isEmpty())
			throw new RuntimeException("List is empty");
		while (trav != null) {
			System.out.println(trav.data);
			// increament trav
			trav = trav.next;
		}
	}

	// method to del last
	public void delLast() {
		// if list is empty
		if (isEmpty())
			throw new RuntimeException("Cannot delete:List is empty");
		// spcl case if node to be deleted is first
		if (head.next == null)
			head = null;
		else {
			Node trav = head;
			// make slow pointer temp
			Node temp = null;

			// traverse till last while temp is at last second
			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			// make temp.next is equal to null
			temp.next = null;
		}
	}

	// public void delFirst
	public void delFirst() {
		// check if list is empty
		if (isEmpty())
			throw new RuntimeException("Cannot delete:List is empty");
		else {
			head = head.next;
		}
	}

	public void delPos(int pos) {
		// check if list is empty
		if (isEmpty() || pos < 1)
			throw new RuntimeException("Cannot delete:list is empty");
		else if (pos == 1) // if pos is 1 or less than 1
			delFirst();
		else {
			Node trav = head;
			Node temp = null;
			for (int i = 1; i < pos; i++) {
				if (trav == null)
					throw new RuntimeException("Invalid positon");
				temp = trav;
				trav = trav.next;
			}

			temp.next = trav.next;
		}
	}
	public void delAll(){
		head = null;
	}
}

public class SinglyList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean quit = false;
		while (!quit) {

			System.out.println("1:addFirst, 2:addLast 3:addPos 4:display 5:delFirst 6:delLast 7:delPos 8:delAll 9:Quit");

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
