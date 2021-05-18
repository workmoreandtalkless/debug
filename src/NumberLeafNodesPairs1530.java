public class NumberLeafNodesPairs1530 {
    int result=0;
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
    public int countPairs(TreeNode root, int distance) {
        dfs(root,distance);
        return result;
    }

    int[] dfs(TreeNode root, int distance){
        if(root == null) return new int[distance+1];
        if(isLeaf(root)){
            int res[] = new int[distance+1];
            res[1]++;
            return res;
        }
        int [] left = dfs(root.left,distance);
        int [] right = dfs(root.right,distance);

        for(int l=1;l<left.length;l++){
            for(int r = distance-1;r>=0;r--){
                if(l+r <= distance) result+= left[l]*right[r];
            }
        }
        int res[] = new int[distance+1];
        //shift by 1
        for(int i=res.length-2;i>=1;i--){
            res[i+1]=left[i] + right[i];
        }

        return res;
    }
    public boolean isLeaf(TreeNode x){
        if(x==null) return false;
        if(x.left==null && x.right ==null){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NumberLeafNodesPairs1530 numberLeafNodesPairs1530=new NumberLeafNodesPairs1530();
        /**
         *  TreeNode lr=new TreeNode(4);
         *         TreeNode left = new TreeNode(2,null,lr);
         *         TreeNode right = new TreeNode(3);
         *         TreeNode root = new TreeNode(1,left,right);
         */
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode left = new TreeNode(2,ll,lr);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        TreeNode right = new TreeNode(3,rl,rr);
        TreeNode root = new TreeNode(1,left,right);

        int x=numberLeafNodesPairs1530.countPairs(root,3);
        System.out.println(x);
    }


}
