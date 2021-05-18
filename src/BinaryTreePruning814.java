public class BinaryTreePruning814 {

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


        public TreeNode pruneTree(TreeNode root) {
            if(root==null) return root;

            if(root.val==0){
                root.left= pruneTree(root.left);
                root.right = pruneTree(root.right);
                if(root.left==null && root.right==null) return null;
                else return root;

            }
            else {
                root.left= pruneTree(root.left);
                root.right = pruneTree(root.right);
            }

            return root;

        }

    public static void main(String[] args) {
             TreeNode rr = new TreeNode(1);
             TreeNode rl = new TreeNode(0);
             TreeNode right = new TreeNode(0,rl,rr);
            TreeNode root = new TreeNode(1,null,right);

            BinaryTreePruning814 b = new BinaryTreePruning814();
            TreeNode x = b.pruneTree(root);

            System.out.print(x);
    }
}
