public class InsertIntoBinarySearchTree701 {
     public class TreeNode {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        int cmp = val-root.val;
        if(cmp<0) {
            root.left = insertIntoBST(root.left,val);
        }
        else if(cmp>0){
            root.right = insertIntoBST(root.right,val);
        }

        return root;
    }
}
