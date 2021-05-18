package L1500_1599;

import java.util.HashSet;
import java.util.Set;

public class SpliteAStringIntotheMaxNumberOfUniqueSubstrings {
    public int maxUniqueSplit(String s) {
        Set<String> set = new HashSet<>();
        return dfs(set, 0, s);
    }
    private int dfs(Set<String> set, int idx, String s){
        if(idx >= s.length()) return 0;
        int res = -1; // did not find method to split;
        for(int i = idx + 1;i<=s.length();i++){
            String sub = s.substring(idx,i);
            if(set.contains(sub)) continue;
            set.add(sub);
            int next = dfs(set,i,s);
            if(next>=0) res = Math.max(res,next+1);
            set.remove(sub);
        }
        return res;
    }

    public static void main(String[] args) {
        String s="ababccc";
        SpliteAStringIntotheMaxNumberOfUniqueSubstrings Sas = new SpliteAStringIntotheMaxNumberOfUniqueSubstrings();

        int x = Sas.maxUniqueSplit(s);
        System.out.print(x);
    }
}
