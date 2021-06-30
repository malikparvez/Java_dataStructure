package doubly;

import java.util.Scanner;

class DoublyList {

	static class Node {
		private Node previous;
		private int data;
		private Node next;

		public Node() {

			previous = null;
			data = 0;
			next = null;
		}

		public Node(int data) {

			previous = null;
			this.data = data;
			next = null;
		}

	}

	private Node head;

	public DoublyList() {
		head = null;
	}

	// check for empty
	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int val) {

		// first creat a new node
		Node newNode = new Node(val);
		// check for empty
		if (isEmpty())
			head = newNode;

		else {
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
	}

	public void addLast(int val) {
		// first creat a new node
		Node newNode = new Node(val);
		// check for empty
		if (isEmpty())
			head = newNode;

		else {
			Node trav = head;
			while (trav.next != null) {
				trav = trav.next;
			}
			newNode.previous = trav;
			trav.next = newNode;

		}
	}

	public void addPos(int val, int pos) {
		if (isEmpty() || pos == 1)
			addFirst(val);
		else if (pos < 1)
			throw new RuntimeException("Not a valid position");
		else {
			Node newNode = new Node(val);
			Node trav = head, temp = null;
			for (int i = 1; i < pos - 1; i++) {
				if (trav.next == null)
					break;
				temp = trav;
				trav = trav.next;
			}
			temp = trav.next;
			newNode.previous = trav;
			newNode.next = temp;
			trav.next = newNode;
			if (temp != null)
				temp.previous = newNode;
		}
	}

	public void displayFor() {
		if (isEmpty())
			throw new RuntimeException("list is empty");
		else {
			Node trav = head;
			do {
				System.out.print(trav.data+" ");
				trav = trav.next;
			} while (trav != null);
		}
		System.out.println("");
	}

	public void displayRev() {

		if (isEmpty())
			throw new RuntimeException("list is empty");
		else {

			Node trav = head;
			while (trav.next != null)
				trav = trav.next;

			while (trav != null) {
				System.out.print(trav.data+" ");
				trav = trav.previous;
			}
		}
		System.out.println("");
	}

	public void delFirst() {

		// check if list is empty
		if (isEmpty())
			throw new RuntimeException("Cannot delete: list is empty");
		else if (head.next == null)
			head = null;

		else {
			head = head.next;
			head.previous = null;

		}
	}

	public void delLast() {

		// check if list is empty
		if (isEmpty())
			throw new RuntimeException("Cannot delete: list is empty");
		else if (head.next == null)
			head = null;

		else {
			Node trav = head, temp = null;

			while (trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
			trav.previous = null;
		}
	}

	public void delPos(int pos) {
		if(isEmpty())
			throw new RuntimeException("Cannot delete: list is empty");
		else if(pos < 1)
			throw new RuntimeException("Invalid position");
		else if(pos==1)
			delFirst();
		else {
			Node trav = head,temp = null;
			for (int i =1; i<pos; i++) {
				if(trav.next == null)
					break;
				temp = trav;
				trav = trav.next;
			}
			
			if(trav.next == null) 
				delLast();
			else {
				temp.next = trav.next;
				trav = trav.next;
				trav.previous = temp;
			
			}	
		}	
	}

	public void delAll() {
		
		head = null;	
	}
		
}

public class DoublyLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoublyList list = new DoublyList();
		boolean quit = false;
		while (!quit) {

			System.out.println("1:addFirst, 2:addLast 3:addPos 4:displayFor 5:displayRev 6:delFirst "
					+ "7:delLast 8:delPos 9:delAll 10:Quit");

			switch (sc.nextInt()) {
			case 1:

				System.out.println("Enter the value to add");
				list.addFirst(sc.nextInt());
				System.out.println("Added sucessfully");
				break;

			case 2:
				System.out.println("Enter the value to add");
				list.addLast(sc.nextInt());
				System.out.println("Added sucessfully");
				break;

			case 3:

				try {
					System.out.println("Enter the value, position");
					list.addPos(sc.nextInt(), sc.nextInt());
					System.out.println("Added sucessfully");
				} catch (Exception e) {

					System.out.println(e.getMessage());
					;
				}
				break;

			case 4:
				try {
					System.out.print("List: ");
					list.displayFor();
				} catch (Exception e) {

					System.out.println(e.getMessage());
					;
				}

				break;

			case 5:
				try {
					System.out.print("List: ");
					list.displayRev();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 6:
				try {
					list.delFirst();
					System.out.println("Deleted sucessfully");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;

			case 7:

				try {
					list.delLast();
					System.out.println("Deleted sucessfully");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 8:
				try {
					System.out.println("Enter position to del");
					list.delPos(sc.nextInt());
					System.out.println("Deleted sucessfully");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 9:
				list.delAll();
				System.out.println("Deleted all elements");
				break;

			case 10:
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
