// implement a double linked list


public class DoubleLinkedList {
	DoubleLinkedList previous = null;
	DoubleLinkedList next = null;
	int item = 0;
	public DoubleLinkedList(int i){
		this.item = i;
	}
	
	
	public static void main(String[] args){
//		head.next = new DoubleLinkedList(4);
		DoubleLinkedList head = new DoubleLinkedList(99);
		DoubleLinkedList runner = head;
		for(int i = 1; i<10; i++){
			DoubleLinkedList node = new DoubleLinkedList(i);
			runner.next = node;
			node.previous = runner;
			runner = runner.next;
		}
		
		runner = head;
		while(runner != null){
			System.out.print(runner.item+" ");
			runner = runner.next;
		}
		
		
		
	}
	
	
	
}
