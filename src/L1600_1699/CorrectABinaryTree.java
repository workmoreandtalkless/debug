package L1600_1699;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.*;

// Definition for a binary tree node.
class TreeNode {
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

public class CorrectABinaryTree {

    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        Map<Integer, TreeNode> parent = new HashMap<>();
        while (!q.isEmpty()) {
            Map<Integer, TreeNode> curParent = new HashMap<>();
            Map<Integer, TreeNode> map = new HashMap<>();
            for (int k = q.size(); k > 0; --k) {
                TreeNode node = q.poll();
                if (map.containsKey(node.val)) {
                    TreeNode removeNode = map.get(node.val);
                    TreeNode f = parent.get(removeNode.val);
                    if (f.left == removeNode) {
                        f.left = null;
                    } else {
                        f.right = null;
                    }
                    return root;
                }
                if (node.left != null) {
                    curParent.put(node.left.val, node);
                    q.offer(node.left);
                }
                if (node.right != null) {
                    curParent.put(node.right.val, node);
                    q.offer(node.right);
                    map.put(node.right.val, node);
                }
            }
            parent = curParent;
        }
        return root;}

    public static void main(String[] args) {
        CorrectABinaryTree cbt = new CorrectABinaryTree();
        TreeNode rrl = new TreeNode(5);
        TreeNode rrr = new TreeNode(6);
        TreeNode rl = new TreeNode(9,null,null);
        TreeNode rr = new TreeNode(4,rrl,rrr);
        TreeNode right = new TreeNode(1,rl,rr);

        TreeNode lll = new TreeNode(2);
        TreeNode ll = new TreeNode(7,lll,rr);
        TreeNode left = new TreeNode(3,ll,null);

        TreeNode root = new TreeNode(8,left,right);

        cbt.correctBinaryTree(root);
    }

}
