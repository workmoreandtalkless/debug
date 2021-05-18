package Challenge;

public class BST {

      public static class Tree {

       int val;
        Tree left;
        Tree right;
          public Tree(int val){
              this.val = val;
          }
          public Tree(int val, Tree left, Tree right){
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    public int solve(Tree root, int lo, int hi) {
        int count = 0;
        if(root==null) return 0;
        int val = root.val;
        if(val<lo) {
            count += solve(root.right,lo,hi);
        }else if(val > hi){
            count += solve(root.left,lo,hi);
        }
        else{
            count += solve(root.left,lo,hi) + solve(root.right,lo,hi);
        }
        return count;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Tree rll = new Tree(4);
        Tree rlr = new Tree(8);
        Tree rl = new Tree(7,rll,rlr);
        Tree rr = new Tree(12);
        Tree left = new Tree(2);
        Tree right = new Tree(9,rl,rr);
        Tree root = new Tree(3,left,right);

        bst.solve(root,5,10);
    }
}
