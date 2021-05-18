package binarysearch;

import java.util.HashMap;
import java.util.Map;

public class SolveQuestion {
    public int solve(String s, String t) {
        int length = s.length();
        int count = length;
        Map<Character, Character> map1 = new HashMap();
        Map<Character, Character> map2 = new HashMap();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count--;
                continue;
            } else {
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }
        }
        if (map1.size() == 0)
            return 0;
        int two = 0;
        for (Map.Entry<Character, Character> entry : map1.entrySet()) {
            Character c1 = entry.getKey();
            Character c2 = entry.getValue();
            if (map2.containsKey(c1)) {
                two = 1;
            }
            if (map2.get(c1) == c2) {
                two = 2;
                break;
            }
        }

        return count - two;
    }

    public static void main(String[] args) {
        String s = s = "gfcfc";
        String  t = "dcfbg";

        SolveQuestion sq = new SolveQuestion();
        sq.solve(s,t);
    }
}
