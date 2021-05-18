package L1400_1499;

import Contest.MaximumProfitOfOperation;

public class MaximumProductOfSplittedBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int maxProduct(TreeNode root) {
        int sum=Sum(root);
        return sum;
    }

    public int Sum(TreeNode root){

        if(root == null) return 0;
        int sum = 0;
        sum+= Sum(root.left);
        sum+=root.val;
        sum+=Sum(root.right);

        return sum ;
    }

    public static void main(String[] args) {
        MaximumProductOfSplittedBinaryTree mpsb = new MaximumProductOfSplittedBinaryTree();
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode left = new TreeNode(2,ll,lr);
        TreeNode rl = new TreeNode(6);
        TreeNode right = new TreeNode(3,rl,null);
        TreeNode root = new TreeNode(1,left,right);
        int sum = mpsb.Sum(root);
        System.out.print(sum);
    }
}

