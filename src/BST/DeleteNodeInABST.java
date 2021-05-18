package BST;

public class DeleteNodeInABST {

        TreeNode root;
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root==null) return null;
            this.root = root;
            delete(key);
            return this.root;
        }
        public void delete(int key){
            this.root = delete(this.root,key);
        }
        public TreeNode delete(TreeNode x,int key){
            if (x==null) return null;
            int cmp = key - x.val;
            if(cmp<0) x.left = delete(x.left,key);
            else if(cmp>0) x.right = delete(x.right ,key);
            else {
                if(x.right ==null) return x.left;
                if(x.left == null) return x.right;
                TreeNode t =x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }

            return x;
        }
        public TreeNode min(TreeNode x){
            if(x.left==null) return x;
            return min(x.left);
        }
        private TreeNode deleteMin(TreeNode x){
            if(x.left==null) return x.right;
            x.left = deleteMin(x.left);
            return x;
        }

    public static void main(String[] args) {
        DeleteNodeInABST dbst = new DeleteNodeInABST();
        dbst.root = new TreeNode(0,null,null);
        dbst.delete(0);
        System.out.println(dbst.root);
    }
}

