package L600_699;

import java.util.*;

public class ImplementMagicDictionary {
    Set<String> words;
    Map<String, Integer> count;

    public ImplementMagicDictionary() {
        words = new HashSet();
        count = new HashMap();
    }

    private ArrayList<String> generalizedNeighbors(String word) {

        ArrayList<String> ans = new ArrayList();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    public void buildDict(String[] words) {
        for (String word: words) {
            this.words.add(word);
            for (String nei: generalizedNeighbors(word)) {
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    public boolean search(String word) {
        for (String nei: generalizedNeighbors(word)) {
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(word)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementMagicDictionary i = new ImplementMagicDictionary();
        String []buildDict={"hello"};
        i.buildDict(buildDict);
//        boolean x= i.search("hello");
        boolean y= i.search("hhllo");
//        boolean z= i.search("hell");
//        boolean h= i.search("leetcoded");
        System.out.println(y);
//        System.out.println(x+" "+y+" "+z+" "+h+" ");

    }
}
