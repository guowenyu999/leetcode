//public class SumOfLeftLeaves {
//
//}

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
public class SumOfLeftLeaves {

	private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	private static List<TreeNode> nodeList = null;

	/**
	 * 内部类：节点
	 * 
	 * @author ocaicai@yeah.net @date: 2011-5-17
	 * 
	 */
	private static class TreeNode {
		TreeNode left;
		TreeNode right;
		int data;

		TreeNode(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	public void createBinTree() {
		nodeList = new LinkedList<TreeNode>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new TreeNode(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList
				.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList
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
	public static void preOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrderTraverse(node.left);
		preOrderTraverse(node.right);
	}

	/**
	 * 中序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void inOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		inOrderTraverse(node.left);
		System.out.print(node.data + " ");
		inOrderTraverse(node.right);
	}

	/**
	 * 后序遍历
	 * 
	 * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
	 * 
	 * @param node
	 *            遍历的节点
	 */
	public static void postOrderTraverse(TreeNode node) {
		if (node == null)
			return;
		postOrderTraverse(node.left);
		postOrderTraverse(node.right);
		System.out.print(node.data + " ");
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum = sum + root.left.data;
			} else {
				sum+=sumOfLeftLeaves(root.left);
			}
		}

		sum = sum + sumOfLeftLeaves(root.right);
		return sum;
	}
	public static int sumOfLeftLeaves1(TreeNode root) {
	    if(root == null) return 0;
	    int ans = 0;
	    if(root.left != null) {
	        if(root.left.left == null && root.left.right == null) ans += root.left.data;
	        else ans += sumOfLeftLeaves(root.left);
	    }
	    ans += sumOfLeftLeaves(root.right);
	    
	    return ans;
	}
	public static void main(String[] args) {
		SumOfLeftLeaves binTree = new SumOfLeftLeaves();
		binTree.createBinTree();
		// nodeList中第0个索引处的值即为根节点
		TreeNode root = nodeList.get(0);
		System.out.println(sumOfLeftLeaves1(root));

		System.out.println("先序遍历：");
		preOrderTraverse(root);
		System.out.println();

		System.out.println("中序遍历：");
		inOrderTraverse(root);
		System.out.println();

		System.out.println("后序遍历：");
		postOrderTraverse(root);
	}

}
