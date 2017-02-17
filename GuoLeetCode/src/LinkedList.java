public class LinkedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode head;

	public LinkedList() {
		this.head = null;
	}

	public void addNode(int data) {

		if (head == null) {
			ListNode node = new ListNode(data);
			node.next = head;
			head = node;
		} else {
			ListNode node = new ListNode(data);
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	public void display(ListNode newhead) {
		while (newhead != null) {
			System.out.println(newhead.val);
			newhead = newhead.next;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode newhead=null;
		while(head!=null){
		ListNode next=head.next;
		head.next=newhead;
		newhead=head;
		head=next;
		}
		return newhead;
	}
	public ListNode reverseList(ListNode head,ListNode newhead) {
		if (head==null) {
			return newhead;
		}
		
		ListNode next=head.next;
		head.next=newhead;
		return reverseList(next,head);
	}

	public static void main(String[] args) {
		LinkedList ls = new LinkedList();
		ls.addNode(1);
		ls.addNode(2);
		ls.addNode(3);
		ls.addNode(4);
		ls.addNode(5);
		ls.addNode(6);
		ls.display(ls.head);
//		ls.reverseList(ls.head);
		ls.display(ls.reverseList(ls.head));
	}

}
