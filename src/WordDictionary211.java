public class WordDictionary211 {

        public int R=26;
        public int special =256;
        public Node root;

        class Node{
            public boolean val;
            public Node [] next = new Node[R];
            private boolean isEnd;
        }
        /** Initialize your data structure here. */
        public WordDictionary211() {
            root = new Node();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            root = put(root,word,true,0);
        }
        public Node put(Node x, String word,boolean val, int d){
            if(x==null) x = new Node();
            if(d==word.length()) {x.val = val; return x;}
            char c = word.charAt(d);
            x.next[c-'a'] = put(x.next[c-'a'],word,val,d+1);
            return x;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
//            StringBuilder s= new StringBuilder(word);
//            while (s.charAt(s.length()-1)=='.'){
//                s.deleteCharAt(s.length()-1);
//            }

            Node x = get(root,word,0);
            if(x==null) return false;
            return x.val;
        }
        public Node get(Node x, String word ,int d){
            if(x == null ) return null;
            //if(x.val==true) return x;
            if(d == word.length()) return x;
            char c = word.charAt(d);

            if(c=='.'||x.next[c-'a']==null ){
                if(c=='.'){
                    for(char cc='a';cc-'a'<R;cc++){
                        if(get(x.next[cc-'a'],word,d+1)!=null)
                            return get(x.next[cc-'a'],word,d+1);

                    }
//                if(d==word.length()-1) {
//                    return x;
//                }

                }
                return null;
            }


            else{
               // if(d==word.length()) return x;
                return get(x.next[c-'a'],word,d+1);
            }


        }

    public static void main(String[] args) {
        WordDictionary211 w = new WordDictionary211();
        w.addWord("ran");
        w.addWord("rune");
        w.addWord("runner");
        w.addWord("runs");
        w.addWord("add");
        w.addWord("adds");
        w.addWord("adder");
        w.addWord("addee");

       boolean x= w.search("add.");
       System.out.print(x);
    }
}
