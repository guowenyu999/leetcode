package BinaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 功能：把一个数组的值存入二叉树中，然后进行3种方式的遍历
 * 
 * 参考资料0:数据结构(C语言版)严蔚敏
 * 
 * 参考资料1：http://zhidao.baidu.com/question/81938912.html
 * 
 * 参考资料2：http://cslibrary.stanford.edu/110/BinaryTrees.html#java
 * 
 * @author ocaicai@yeah.net @date: 2011-5-17
 * 
 */
// 将二叉树转化为双向链表
public class BinTreeToTwoWayList {

	private int[] array = { 1, 2, 3,4,5 };
	private static List<Node> nodeList = null;

	/**
	 * 内部类：节点
	 * 
	 * @author ocaicai@yeah.net @date: 2011-5-17
	 * 
	 */
	private static class Node {
		Node leftChild;
		Node rightChild;
		int data;

		Node(int newData) {
			leftChild = null;
			rightChild = null;
			data = newData;
		}
	}

	public void createBinTree() {
		nodeList = new LinkedList<Node>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).leftChild = nodeList
					.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).rightChild = nodeList
					.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).leftChild = nodeList
				.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).rightChild = nodeList
					.get(lastParentIndex * 2 + 2);
		}
	}

	/**
	 * 先序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void preOrderTraverse(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}

	/**
	 * 中序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void inOrderTraverse(Node node) {
		if (node == null)
			return;
		inOrderTraverse(node.leftChild);
		System.out.print(node.data + " ");
		inOrderTraverse(node.rightChild);
	}

	/**
	 * 后序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void postOrderTraverse(Node node) {
		if (node == null)
			return;
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.print(node.data + " ");
	}

	public static Node toTwoWayList1(Node root) {
		if (root == null) {
			return root;
		}

		if (root.leftChild == null&&root.rightChild == null) {
			return root;
		}
		Node templeft = toTwoWayList1(root.leftChild);
		Node tempright = toTwoWayList1(root.rightChild);
		Node lastrightNode = templeft;
		if (lastrightNode != null) {
			while (lastrightNode.rightChild != null) {
				lastrightNode = lastrightNode.rightChild;
			}
			root.leftChild = lastrightNode;
			lastrightNode.rightChild = root;
		}
		Node lastleftNode = tempright;
		if (lastleftNode != null) {
			while (lastleftNode.leftChild != null) {
				lastleftNode = lastleftNode.leftChild;
			}
			root.rightChild = lastleftNode;
			lastleftNode.leftChild = root;
		}

		return root;

	}

	public static void toTwoWayList(Node root, Node nodeleft, Node noderight) {
		if (root == null) {
			return;
		}
		if (root.leftChild == null) {
			nodeleft = root;
		} else {
			Node temprootl = root.leftChild;
			if (temprootl.rightChild != null) {
				while (temprootl != null) {
					noderight = temprootl.rightChild;
				}
			} else {
				noderight = temprootl;
			}

			toTwoWayList(root.leftChild, nodeleft, noderight);
			noderight.rightChild = root;
			root.leftChild = noderight;
		}
		if (root.rightChild == null) {
			noderight = root;
		} else {
			Node temprootr = root.rightChild;
			if (temprootr.leftChild != null) {
				while (temprootr != null) {
					nodeleft = temprootr.leftChild;
				}
			} else {
				nodeleft = temprootr;
			}
			toTwoWayList(root.rightChild, nodeleft, noderight);
			nodeleft.leftChild = root;
			root.rightChild = nodeleft;
		}
		return;

	}

	public static void main(String[] args) {
		BinTreeToTwoWayList binTree = new BinTreeToTwoWayList();
		binTree.createBinTree();
		// nodeList中第0个索引处的值即为根节点
		Node root = nodeList.get(0);
		// Node leftNode = nodeList.get(1);
		// Node rightNode = nodeList.get(2);
		// System.out.println(root.data + " " + leftNode.data + " "
		// + rightNode.data);
//		toTwoWayList1(root);
		 System.out.println("先序遍历：");
		 preOrderTraverse(root);
		 System.out.println();
		//
		// System.out.println("中序遍历：");
		// inOrderTraverse(root);
		// System.out.println();
		//
		// System.out.println("后序遍历：");
		// postOrderTraverse(root);
	}

}
