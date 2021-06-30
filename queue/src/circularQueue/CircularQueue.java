package circularQueue;

import java.util.Scanner;

class Queue {
	private int[] arr;
	private int front, rear;

	Queue(int size) {
		arr = new int[size];
		front = -1;
		rear = -1;
	}

	public boolean isEmpty() {
		return (front == rear) && front ==-1;
	}
	
	public boolean isFull() {
		return (front == rear && front !=-1) || (front == -1 && rear == arr.length-1);
	}
	
	public void push(int val) {
		if(isFull())
			throw new RuntimeException("Queue is full");
		else {
			rear= (rear+1) % arr.length;
			arr[rear] = val;	
		}
	}	
	
		public void pop() {
			
			if(isEmpty())
				throw new RuntimeException("Queue is empty");
			else {
			front = (front+1) % arr.length;
			}if(front == rear) {
				front = -1;
				rear = -1;
			}
		}
		
		
		public void peek() {
			
			if(isEmpty())
				throw new RuntimeException("Queue is empty");
			else {
				int index = (front+1) % arr.length;
				System.out.print(arr[index]);
			}
				System.out.println("");
		}
			
				
		
		
		public void delAll() {
		
			if(isEmpty())
				throw new RuntimeException("Queue is empty");
			else {
				front = -1;
				rear = -1;
			}		
		}
	
	}
public class CircularQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue list = new Queue(3);
		boolean quit = false;
		while (!quit) {

			System.out.println("1:push, 2:pop 3:peek 4:delAll 5:Quit");

			switch (sc.nextInt()) {
			case 1:

				try {
					System.out.println("Enter the value to add");
					list.push(sc.nextInt());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 2:
				try {
					list.pop();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:

				try {
					list.peek();
				} catch (Exception e) {

					System.out.println(e.getMessage());
				}
				break;

			case 4:
				try {
					list.delAll();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
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