package stack;

import java.util.*;

//make a class of array and top
	class Stack{
		private int []arr;
		private int top;
		
		
		//define a parametrized constructor
		
		public Stack(int size) {
			arr= new int[size];
			top=-1;
		}
		
		//method to push element
		
		public void push(int val) {
			if(isFull())
				throw new RuntimeException("Stack is full");
			arr[++top]=val;
		}
		
		//decrement top
		public void pop() {
			if(isEmpty())
				throw new RuntimeException("Stack is empty");
		top--;
		}
		
		//print current top value element
		public void peek() {
			if(isEmpty())
				throw new RuntimeException("Stack is empty");
			System.out.println(arr[top]);
		}
		
		//check is top==-1
		public boolean isEmpty() {
		return top==-1;
		}
		
		//check is top==arr.length-1
		public boolean isFull() {
			return top==(arr.length-1);
			}
			
	}
	
	
	public class StackMain {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack(3);
		boolean quit = false;
		while(!quit) {
			
			System.out.println("1:Push , 2:Pop ,3:Peek ,4:Exit");
			
			switch (sc.nextInt()) {
			case 1:
				try {
				System.out.println("Enter element to push");
				st.push(sc.nextInt());
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 2:
				try {
				st.pop();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				try {
				st.peek();
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
			quit=true;
				break;

			default:
				System.out.println("Plese enter a valid choice");
				break;
			}
			
		
			
		}
		sc.close();
	
	}
	

}
