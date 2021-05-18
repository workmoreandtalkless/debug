package Challenge;

import java.util.ArrayList;
import java.util.List;

public class letterCasePermuatation {
//    public List<String> letterCasePermutation(String S) {
//        List<StringBuilder> ans = new ArrayList();
//        ans.add(new StringBuilder());
//
//        for (char c: S.toCharArray()) {
//            int n = ans.size();
//            if (Character.isLetter(c)) {
//                for (int i = 0; i < n; ++i) {
//                    ans.add(new StringBuilder(ans.get(i)));
//                    ans.get(i).append(Character.toLowerCase(c));
//                    ans.get(n+i).append(Character.toUpperCase(c));
//                }
//            } else {
//                for (int i = 0; i < n; ++i)
//                    ans.get(i).append(c);
//            }
//        }
//
//        List<String> finalans = new ArrayList();
//        for (StringBuilder sb: ans)
//            finalans.add(sb.toString());
//        return finalans;
//
//
//    }
        List<String> list = new ArrayList();
            public List<String> letterCasePermutation(String S) {
                StringBuilder str = new StringBuilder(S);
                //backtracking
                dfs(str,0);
                return list;
            }
            public void dfs(StringBuilder s,int index){
                if(index>=s.length()) return;
                if(!Character.isDigit(s.charAt(index))){
                    s.setCharAt(index,Character.toLowerCase(s.charAt(index)));
                    list.add(s.toString());
                    s.setCharAt(index,Character.toUpperCase(s.charAt(index)));
                    list.add(s.toString());
                }else{
                    dfs(s,index+1);
                }
            }
    public static void main(String[] args) {
        letterCasePermuatation lcp = new letterCasePermuatation();
        lcp.letterCasePermutation("a1b2");
    }
}
