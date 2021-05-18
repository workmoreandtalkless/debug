package Week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDupSubTree {
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
        Map<String,Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            count = new HashMap<>();
            ans = new ArrayList();
            collect(root);
            return ans;
        }
        public String collect(TreeNode node){
            if(node == null) return "#";
            String serial = node.val + "," + collect(node.left) + ","+ collect(node.right);
            count.put(serial, count.getOrDefault(serial,0)+1);
            if(count.get(serial) == 2){
                ans.add(node);
            }
            return serial;
        }

    public static void main(String[] args) {
        FindDupSubTree findDupSubTree = new FindDupSubTree();
        TreeNode rll = new TreeNode(4);
        TreeNode ll = new TreeNode(4,null,null);
        TreeNode rl = new TreeNode(2,rll,null);
        TreeNode rr = new TreeNode(4);
        TreeNode right = new TreeNode(3,rl,rr);
        TreeNode left = new TreeNode(2,ll,null);

        TreeNode root = new TreeNode(1,left,right);
        List<TreeNode> list= findDupSubTree.findDuplicateSubtrees(root);

        for (TreeNode node:
             list) {
            System.out.println(node.val);
        }

    }

}
