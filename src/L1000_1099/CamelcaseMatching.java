package L1000_1099;

import Week2.FindDupSubTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Character.*;

public class CamelcaseMatching {
    class  TrieNode{
        Character val;
        TrieNode child;
        TrieNode(Character val){
            this.val =val;
        }
    }
    private void constructTrie(String pattern, TrieNode root){
        TrieNode currNode = root;
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            currNode.child = new TrieNode(c);
            currNode = currNode.child;
        }
    }
    //Trie
    public List<Boolean> camelMathch2(String [] queries, String pattern){
        List<Boolean> res = new ArrayList<>();
        TrieNode root = new TrieNode('#');
        constructTrie(pattern, root);
        for (int j = 0; j < queries.length; j++) {
            String query = queries[j];
            TrieNode currNode = root.child;
            for (int i = 0; i < query.length(); i++) {
                char key = query.charAt(i);
                if (currNode == null) {
                    if (isUpperCase(key)) {
                        res.add(false);
                        break;
                    }
                } else {
                    if (isUpperCase(currNode.val) && isUpperCase(key)) { // upper, upper
                        if (currNode.val != key) {
                            res.add(false);
                            break;
                        } else {
                            currNode = currNode.child;
                        }
                    } else if (isLowerCase(currNode.val) && isUpperCase(key)) { // lower, upper
                        res.add(false);
                        break;
                    } else if (currNode.val == key) { // upper, lower or lower, lower
                        currNode = currNode.child;
                    }
                }
            }
            if (res.size() == j)
                res.add(currNode == null);
        }
        return res;
    }

    private boolean isLowerCase(Character val) {
        return val>='A'&&val<='Z' ? true:false;
    }

    private boolean isUpperCase(Character val) {
        return val>='a'&&val<='z' ? true:false;
    }


    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int pos1=0;
        int pos2=0;
        int n=queries[0].length();
        int m=pattern.length();
        List<Boolean> list = new LinkedList<>();
        for (String s :
                queries) {
            boolean isMatch = match(s,pattern);
            list.add(isMatch);
        }
        return list;
    }

    public boolean match(String s, String p){
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j<p.length()&&s.charAt(i)==p.charAt(j)){
                j++;
            }else if(s.charAt(i)>='A'&& s.charAt(i)<='Z'){
                return false;
            }
        }
        return j==p.length();
    }

    public static void main(String[] args) {
        String [] queries ={"FooBar"};
        String par="FB";
        CamelcaseMatching c = new CamelcaseMatching();
        List<Boolean> list = c.camelMathch2(queries,par);
        for (boolean a: list
             ) {
            System.out.println(a);
        }
    }
}
