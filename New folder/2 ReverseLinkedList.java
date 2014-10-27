package LinkedList.Ques2_7;
/* �Ҽ�������������ݶ������������Ӧ�ú����Թ�ȷ��һ�£�������char ����longʲô��
 * We assume the elements in the linked list are integers. Before programming, we should check the primaries of the data, 
 * such as int, char, long and so on.
 * 
 * Solution: reverse and compare
 * reverse the linked list and compare the reversed linked list with the original one.
 * we only actually need to compare the first half of the list.
 * 
 * ���⣺boolean b = slow1.equals(slow2); //�����ֱȷ������ԣ�������Ϊif���ж���������Ϊʲô�أ� 
//		 slow1 != slow2;    // ����
 *       slow1.data != slow2.data; //������ǶԵġ�
 * 
 */
// this method reverse the linked list in anther linked list, thus it is not operate in place.		
	public LinkedListNode reverseLinkedList1(LinkedListNode head){
		LinkedListNode l2 = new LinkedListNode(head.data);
		LinkedListNode current = head.next;
		while(current.next != null){
			LinkedListNode temp = new LinkedListNode(current.data); //!!!! "new" each node, thus, the reversed operations will not be operated on the original linked list.
												// That is, the reversed linked list occupied different space from original one in the rom.
			temp.next = l2;
			l2 = temp;
			current = current.next;
		}
		LinkedListNode temp = new LinkedListNode(current.data);
		temp.next = l2;
		l2 = temp;
		
		return l2;
	}
/* this is another method of reversing the linked list. The method revserses the linked list in place */
  		public Node reverseLinkedList1(Node head){
		Node next = head.next;
		Node current = next.next;
		head.next = null;
		while(current.next != null){
			next.next = head;
			head = next;
			next = current;
			current = current.next;
		}
		next.next = head;
		head = next;
		current.next = head;
		head = current;
		return head;  // this head is the reversed linked list's head
	}
