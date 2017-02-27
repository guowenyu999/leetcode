public class DeleteNodeInLList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public void add(ListNode node) { // 增加节点
			if (this.next == null) { // 如果下一个节点为空，则把新节点加入到next的位置上
				this.next = node;
			} else { // 如果下一个节点不为空，则继续找next
				this.next.add(node);
			}
		}
//		public void delete(ListNode node){        //内部删除节点的方法
//			if (node.next==null) {
//				root=null;
//			}
////			node.next = node.next.next ;
//			
//			}
	}

	public ListNode root=null;

	public void addNode(int data) { // 根据内容添加节点
		ListNode newNode = new ListNode(data); // 要插入的节点
		if (root == null) { // 没有头节点，则要插入的节点为头节点
			root = newNode;
		} else { // 如果有头节点，则调用节点类的方法自动增加
			root.add(newNode);
		}
	}
	 
	public void deleteNode(DeleteNodeInLList DeleteNodeInLList) {
		ListNode node=DeleteNodeInLList.root;
		if (node == null) {
			return;
		} else if (node.next == null) {
//			ListNode xListNode=node;
//			node=xListNode.next;
//			root.delete(node);
			DeleteNodeInLList.root=null;
//			node.next = node.next.next;
			return;
		} else if (node.next.next == null) {
			node.next =node.next.next;
			return;
		} else if (node.next.next.next == null) {
			ListNode tempnodeListNode = node.next.next;
			node.next = tempnodeListNode;
			return;
		} else {
			while (node.next.next.next != null) {
				node = node.next;
			}
			ListNode tempnodeListNode = node.next.next;
			node.next = tempnodeListNode;
			return;
		}

	}

	public static void main(String[] args) {
		DeleteNodeInLList list = new DeleteNodeInLList();
		list.addNode(1);
//		list.addNode(2);
//		list.addNode(3);
//		list.addNode(4);
//		list.addNode(2);
//		list.addNode(3);
//		list.addNode(4);
//		ListNode node = list.root;
//		while (node != null) {
//			System.out.println(node.val);
//			node = node.next;
//		}
////		ListNode node1 = list.root;
		list.deleteNode(list);
		ListNode node = list.root;
//		node=null;
//		ListNode node2 = list.root;
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}
}
