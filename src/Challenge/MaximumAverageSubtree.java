package Challenge;

import Contest.MaximumUnitsOnaTrack;

public class MaximumAverageSubtree {
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
    class state{
        int nodeNumber;
        int Sum;
        double maxAverage;

        state(int nodeNumber,int Sum,double maxAverage){
            this.nodeNumber = nodeNumber;
            this.Sum = Sum;
            this.maxAverage = maxAverage;
        }
    }
    public double maximumAverageSubtree(TreeNode root) {
        return maxAve(root).maxAverage;
    }


    public state maxAve(TreeNode root){
        if(root == null) {
            return new state(0,0,0);
        }

        state left = maxAve(root.left);
        state right = maxAve(root.right);

        int nodeNumber = left.nodeNumber + right.nodeNumber + 1;
        int Sum = left.Sum + right.Sum + root.val;

        double maxAverage = Sum/nodeNumber;
        maxAverage = Math.max(maxAverage,Math.max(maxAve(root.left).maxAverage,maxAve(root.right).maxAverage));
        return new state(nodeNumber,Sum,maxAverage);

    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(1);
        TreeNode root = new TreeNode(2,null,right);

        MaximumAverageSubtree mas = new MaximumAverageSubtree();
       System.out.println(mas.maximumAverageSubtree(root));
    }
}
