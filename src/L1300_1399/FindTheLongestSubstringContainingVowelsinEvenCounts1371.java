package L1300_1399;

import java.util.HashMap;

public class FindTheLongestSubstringContainingVowelsinEvenCounts1371 {
    public int findTheLongestSubstring(String s) {
        int res = 0 , cur = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            int abs="aeiou".indexOf(s.charAt(i));
            cur ^= 1 << (abs + 1 ) >> 1;
            /**
             * The putIfAbsent(Key, value) method of Hashtable class
             * which allows to map a value to a given key
             * if given key is not associated with a value or mapped to null.
             * A null value is returned
             * if such key-value set is already present in the HashMap
             */
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        String s1= "leetcodeisgreat";
        FindTheLongestSubstringContainingVowelsinEvenCounts1371 f= new FindTheLongestSubstringContainingVowelsinEvenCounts1371();

        int x = f.findTheLongestSubstring(s1);
        System.out.println(x);
    }
}
