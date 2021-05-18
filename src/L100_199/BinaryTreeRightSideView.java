package L100_199;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
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
    List<Integer> lst = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return lst;
        dfs(root,0);
        return lst;
    }
    public void dfs(TreeNode root,int level){
        if (level == lst.size()){
            lst.add(root.val);
        }
        if(root.right!=null){
            dfs(root.right,level+1);
        }
        if(root.left!=null){
            dfs(root.left,level+1);
        }
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView btrs = new BinaryTreeRightSideView();
        TreeNode lr = new TreeNode(5);
        TreeNode left = new TreeNode(2,null,lr);
        TreeNode rr = new TreeNode(4);
        TreeNode right = new TreeNode(3,null,rr);
        TreeNode root = new TreeNode(1,left,right);
        btrs.rightSideView(root);
    }
}
