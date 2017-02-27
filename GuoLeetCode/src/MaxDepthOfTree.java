
 // Definition for a binary tree node.


public class MaxDepthOfTree {
	private static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 TreeNode root;

 public MaxDepthOfTree(int[] array){
     root=makeBinaryTreeByArray(array,1);
 }

 
 public static TreeNode makeBinaryTreeByArray(int[] array,int index){
     if(index<array.length){
         int value=array[index];
         if(value!=0){
             TreeNode t=new TreeNode(value);
             array[index]=0;
             t.left=makeBinaryTreeByArray(array,index*2);
             t.right=makeBinaryTreeByArray(array,index*2+1);
             return t;
         }
     }
     return null;
 }
     // 获取最大深度
     public static int getMaxDepth(TreeNode root) {
         if (root == null)
             return 0;
         else {
             int left = getMaxDepth(root.left);
              int right = getMaxDepth(root.right);
             return 1 + Math.max(left, right);
         }
     }
 public static void preOrderTraverse(TreeNode node) {  
     if (node == null)  
         return;  
     System.out.print(node.val + " ");  
     preOrderTraverse(node.left);  
     preOrderTraverse(node.right);  
 } 
 public static void main(String[] args) {
     int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
     MaxDepthOfTree tree=new MaxDepthOfTree(arr);
     tree.preOrderTraverse(tree.root);
     System.out.println(getMaxDepth(tree.root));
//     tree.depthOrderTraversal();
//     tree.levelOrderTraversal();
 }
}
