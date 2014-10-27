
public class SingleLinkedList {
	SingleLinkedList next = null;
	int item = 0;
	
	
	public void appendToTail(int n){
		SingleLinkedList end = new SingleLinkedList();
		end.item =n;
		SingleLinkedList current = this;
		while(current.next!=null){
			current = current.next;
		}
		current.next = end;
	}
	
	
// for test: appendToTail works well	
	public static void main(String[] args){
		SingleLinkedList ln = new SingleLinkedList();
		ln.item=4;
		ln.appendToTail(5);
		ln.appendToTail(6);
		ln.appendToTail(7);
		SingleLinkedList runner = ln;
		while(runner!=null){
			System.out.print("-->"+runner.item);
			runner = runner.next;
		}
		
		
		
	}
	

}
