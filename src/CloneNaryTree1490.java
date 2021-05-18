import java.lang.reflect.Array;
import java.util.*;

public class CloneNaryTree1490 {
    static class Node {
        public int val;
        public ArrayList<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public Node cloneTree(Node root) {


        if (root == null) return null;
        Node copy = new Node(root.val);
        for (Node child : root.children)
            copy.children.add(cloneTree(child));
        return copy;

    }

    public static void main(String[] args) {
        CloneNaryTree1490 clone = new CloneNaryTree1490();
        Node root = new Node(2,new ArrayList<Node>());
        clone.cloneTree(root);
    }
}
