package L1300_1399;

import BST.DeleteNodeInABST;

public class DeepestLeavesSum {
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
    int res;
    int depth;
    public int deepestLeavesSum(TreeNode root) {
        helper(root, 0);
        return res;
    }
    void helper(TreeNode root, int level) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(level == depth) res += root.val;
            else if(level > depth) {
                res = root.val;
                depth = level;
            }
            return;
        }
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode lll = new TreeNode(7);
        TreeNode rrr = new TreeNode(8);
        TreeNode ll = new TreeNode(4,lll,null);
        TreeNode lr = new TreeNode(5);
        TreeNode rr = new TreeNode(6,null,rrr);
        TreeNode left = new TreeNode(2,ll,lr);
        TreeNode right = new TreeNode(3,null,rr);
        TreeNode root = new TreeNode(1,left,right);

        DeepestLeavesSum dls = new DeepestLeavesSum();
        dls.deepestLeavesSum(root);
    }
}
