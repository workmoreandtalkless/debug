package L600_699;

import Week2.FindDupSubTree;
import edu.princeton.cs.algs4.Queue;

import java.util.LinkedList;
import java.util.List;

class Trie{
    private int R=26;
    TrieNode root;

    class TrieNode{
        Boolean val;
        TrieNode [] next = new TrieNode[R];
    }
    //search
    public Boolean get(String key){
        TrieNode x = get(root,key,0);
        if(x == null) return null;
        return x.val;
    }
    public TrieNode get(TrieNode x, String key, int d){
        //Return value associated with key in the subtrie rooted at x
        if(x==null) return null;
        if(d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.

        return get(x.next[c],key,d+1);
    }
    public void put(String key, Boolean val){
        root = put(root,key,val,0);
    }
    public TrieNode put(TrieNode x,String key, Boolean val, int d){
        //Change value associated with key if in subtrie rooted at x.
        if(x == null) x=new TrieNode();
        if( d==key.length()) {x.val = val; return x;}
        char c = key.charAt(d);
        x.next[c-'a'] = put(x.next[c-'a'],key,val,d+1);

        return x;
    }
    // Collecting the keys in a trie
    public Iterable<String> keys(){
        return keysWithPrefix("");
    }
    public Iterable<String> keysWithPrefix(String pre){
        Queue<String> q = new Queue<String>();
        collect(get(root,pre,0),pre,q);
        return q;
    }
    private void collect(TrieNode x, String pre, Queue<String> q){
        if(x==null) return ;
        if(x.val != null) q.enqueue(pre);
        for(char c = 0; c<R;c++){
            collect(x.next[c],pre+c,q);
        }
    }

    public String longestPresfixOf(String s){
        int length = search(root,s,0,0);
        return s.substring(0,length);
    }
    public int search(TrieNode x,String s, int d, int length){
        if(x == null) return length;
        if(x.val!=null) length =d;
        if(d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c-'a'],s,d+1,length);
    }
    public String replaceWords(List<String> dict, String sentence,Trie trie) {
//        Trie trie = new Trie();
//        for (String s: dict
//        ) {
//            trie.put(s,true);
//        }

        String [] arr = sentence.split(" ");
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = trie.longestPresfixOf(arr[i]);
        }

        StringBuilder str = new StringBuilder();
        str.append(arr[0]);
        str.append(" ");
        for (int i = 1; i <arr.length ; i++) {
            if(i!=arr.length-1){
                str.append(arr[i]);
                str.append(" ");
            }else{
                str.append(arr[i]);
            }

        }
        return str.toString();
    }
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");

        String sentence = "the cattle was rattled by the battery";

        Trie t = new Trie();
        t.put("cat",true);
        t.put("bat",true);
        t.put("rat",true);
        Iterable<String> iterable=t.keys();
        for(String s: iterable){
            System.out.println(s);
        }
        String res= t.replaceWords(list,sentence,t);
        System.out.println(res);
    }
}

