public class SumNodeswithEvenGrand1315 {
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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null ) return 0;
        int sum =0;
        if(root.val%2==0){
            if(root.left!=null){
                sum+= sumEvenGrandparent(root.left);
                if(root.left.left!=null)
                    sum+= root.left.left.val;
                if(root.left.right!=null)
                    sum+=root.left.right.val;
            }
            if(root.right!=null){
                sum+= sumEvenGrandparent(root.right);
                if(root.right.left!=null)
                    sum+= root.right.left.val;
                if(root.right.right!=null)
                    sum += root.right.right.val;
            }
        }
        else{
            if(root.left!=null)
                sum+=sumEvenGrandparent(root.left);
            if(root.right!=null)
                sum+=sumEvenGrandparent(root.right);
        }
        return  sum;
    }


    public static void main(String[] args) {
        /**
         * TreeNode lll = new TreeNode(9);
         *         TreeNode lrl = new TreeNode(1);
         *         TreeNode lrr = new TreeNode(4);
         *         TreeNode ll = new TreeNode(2,lll,null);
         *         TreeNode lr = new TreeNode(7,lrl,lrr);
         *         TreeNode left = new TreeNode(7,ll,lr);
         *         TreeNode rrr = new TreeNode(5);
         *         TreeNode rl = new TreeNode(1);
         *         TreeNode rr = new TreeNode(3,null,rrr);
         *         TreeNode right = new TreeNode(8,rl,rr);
         *         TreeNode root = new TreeNode(6,left,right);
         */


        TreeNode left = new TreeNode(13,null,null);
        TreeNode rrl = new TreeNode(72);
        TreeNode rr  = new TreeNode(56,rrl,null);
        TreeNode right = new TreeNode(46,null,rr);
        TreeNode root = new TreeNode(61,left,right);

        SumNodeswithEvenGrand1315 s= new SumNodeswithEvenGrand1315();
        int x = s.sumEvenGrandparent(root);
        System.out.println(x);
    }
}
