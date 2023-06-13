package LinkedList;

import java.util.Random;



public class SingleLinkedList {

	private static class Node{
		private int value;
		private Node nextNode;
		public Node(int v, Node n) {
			value = v;
			nextNode= n;
		} 
	}
	private Node headNode;
	private int size = 0;
	public void addHead(int value) {
		headNode = new Node(value, headNode);
		size++;
	}
	public void addTail(int value) {
		Node currNode = headNode;
		Node newNode = new Node(value, null);
		if(headNode == null) {
			headNode = newNode;
			size++;
		}
		while(currNode.nextNode!= null) {
			currNode = currNode.nextNode;
		}
		currNode.nextNode = newNode;
		size++;
	}
	
	public boolean isEmpty() {
		if(headNode == null) {
			return true;
		}
		return false;
	}
	public void sortedInsert(int value) {
		Node newNode = new Node(value, null);
		Node currNode = headNode;
		if(currNode==null || currNode.value> value) {
			newNode.nextNode = headNode;
			headNode = newNode;
			return;
		}
		while(currNode.nextNode!=null && currNode.nextNode.value<value) {
			currNode = currNode.nextNode;
		}
		newNode.nextNode = currNode.nextNode;
		currNode.nextNode= newNode;
		
	}
	public boolean search(int data) {
		Node currNode = headNode;
		while(currNode!= null) {
			if(currNode.value == data) {
				return true;
			}
			currNode = currNode.nextNode;
		}
		return false;
		
	}
	public int removeHead() throws IllegalStateException{
		if(isEmpty()) {
			throw new IllegalStateException("List is Empty");
		} 
		int value = headNode.value;
		headNode = headNode.nextNode;
		size--;
		return value;
	}
	public boolean deleteNode(int deleteValue) throws IllegalStateException {
		Node currNode=headNode;
		if(isEmpty()) {
			throw new IllegalStateException("List is empty");
		}
		if(deleteValue == headNode.value) {
			headNode = headNode.nextNode;
			size--;
			return true;
		}
		while(currNode.nextNode!= null) {
			if(currNode.nextNode.value == deleteValue) {
				currNode.nextNode = currNode.nextNode.nextNode;
				size--;
				return true;
			}
			currNode = currNode.nextNode;
		}
		return false;
		
	}
	public boolean DeleteDuplicateNodes(int delvalue) {
		Node currNode = headNode;
		Node temp;
		boolean found = false;
		while(currNode!= null && currNode.value == delvalue) {
			headNode = currNode.nextNode;
			currNode = headNode;
			found= true;
		}
		while(currNode != null) {
			temp = currNode.nextNode;
			if(temp!= null && temp.value== delvalue) {
				currNode.nextNode =temp.nextNode;
				found = true;
				
			}else {
				currNode = temp;
			}
			
		}
		return found;
	}
	public void reverse(){
		Node curr = headNode;
		Node next = null;
		Node prev = null;
		while(curr != null){
			next = curr.nextNode;
			curr.nextNode = prev;
			prev = curr;
			curr = next;
		}
		headNode = prev;
	}
	private Node reverseRecurse(Node curr, Node next){
		
		Node ret;
		if(curr == null){
			return null;
		}
		if(curr.nextNode == null){
			curr.nextNode = next;
			return curr;
		}
		ret = reverseRecurse(curr.nextNode,curr);
		curr.nextNode = next;
		return ret;
	}
	public void reverseRecurse(){
		headNode = reverseRecurse(headNode, null);
	}
	public void removeAllDuplicates(){
		Node curr = headNode;
		if(curr == null){
			return;
		}
		while(curr!=null){
			if(curr.nextNode!= null && curr.value == curr.nextNode.value){
				curr.nextNode = curr.nextNode.nextNode;
			}else{
				curr  = curr.nextNode;
			}
		}
	}
	public SingleLinkedList copyListReverse(){
		Node tempNode = null;
		Node tempNode2 = null;
		Node curr = headNode;
		while(curr!=null){
			tempNode2 = new Node(curr.value,tempNode);
			curr = curr.nextNode;
			tempNode = tempNode2;
		}
		SingleLinkedList ll= new SingleLinkedList();
		
		ll.headNode = tempNode;
		return ll;
	}
	public boolean loopDetect(){
		Node slow ;
		Node fast;
		slow = fast = headNode;
		while(fast.nextNode != null && fast.nextNode.nextNode!= null ){
			slow = slow.nextNode ;
			fast = fast.nextNode.nextNode;
			if(slow == fast ){
				System.out.println("Loop is found");
				return true;
			}
		}
		System.out.println("Loop is not found");
		return false;
	}
	public boolean reverseLoopDetect(){
		Node tempNode = headNode;
		reverse();
		if(tempNode == headNode){
			reverse();
			System.out.println("Loop is found");
			return true;
		}
		else{
			reverse();
			System.out.println("Loop is not found");
			return false;
		}
	}
	public int loopTypeDetect(){
		Node slow, fast;
		slow = fast = headNode;
		while(fast.nextNode!= null && fast.nextNode.nextNode!= null){
			if(headNode == fast.nextNode|| headNode == fast.nextNode.nextNode){
				System.out.println("circurlar list loop detected");
				return 2;
			}
			slow = slow.nextNode;
			fast = fast.nextNode;
			if(slow == fast){
				System.out.println("Loop Found");
				return 1;
			}
		}
		System.out.println("Loop not found");
		return 0;
	}
	public Node loopPointDetect(){
		Node slow;
		Node fast;
		slow = fast = headNode;
		while(fast.nextNode!= null && fast.nextNode.nextNode!= null){
			slow = slow.nextNode;
			fast = fast.nextNode;
			if(slow == fast){
				return slow;
			}
		}
		return null;
	}
	public void removeLoop(){
		Node loopPoint = loopPointDetect();
		if(loopPoint == null){
			return ;
		}
		Node firstNode = headNode;
		if(loopPoint == headNode){
			while(firstNode != headNode){
				firstNode = firstNode.nextNode;
			}
			firstNode.nextNode = null;
		}
		Node secondNode = loopPoint;
		while(firstNode.nextNode != secondNode.nextNode){
			firstNode = firstNode.nextNode;
			secondNode = secondNode.nextNode;
		}
		secondNode.nextNode = null;
	}
	public void printList() {
		Node currNode = headNode;
		while(currNode != null) {
			System.out.print(currNode.value+" ");
			currNode = currNode.nextNode;
		}
		System.out.println();
	}


	
	
	public static void main(String[] args) {
		System.out.println("Single Linked List");
		SingleLinkedList sll = new SingleLinkedList();
		int arr[] = new int[10];
		Random random =new Random();
		
		for(int i = 0 ; i<10; i++) {
			arr[i] = random.nextInt(50);
			sll.sortedInsert(arr[i]);
		}
		
		sll.printList();
		sll.addTail(10);
		// sll.reverse();
		sll.reverseRecurse();
		sll.printList();
		SingleLinkedList ll2 = sll.copyListReverse();
		ll2.printList();

		System.out.println("isEmpty: "+sll.isEmpty());
		

	}

}
