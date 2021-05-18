import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindLongestAwesomeSubstring1542 {
    public int longestAwesome(String s) {
        int res = 0, cur = 0, n = s.length(), seen[] = new int[1024];
        Arrays.fill(seen, n);
        seen[0] = -1;
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << (s.charAt(i) - '0');
            for (int a = 0; a < 10; ++a)
                res = Math.max(res, i - seen[cur ^ (1 << a)]);
            res = Math.max(res, i - seen[cur]);
            seen[cur] = Math.min(seen[cur], i);
        }
        return res;
    }
    // I do it myself , it's not the part of answer.
    public boolean isAwesome(String s, int b, int e){
        String str= s.substring(b,e);
        int length =str.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int x=0;

        if(length%2==0){
            for (Map.Entry<Character,Integer> entry:
                    map.entrySet()) {
                if(entry.getValue()%2!=0) return false;
            }
        }
        else{
            for (Map.Entry<Character,Integer> entry:
                    map.entrySet()) {
                if(entry.getValue()%2!=0) {
                    x++;
                }
                if(x>1) return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s ="213123";
        String s1="24241";
        String s2 ="3242415";
        FindLongestAwesomeSubstring1542 f = new FindLongestAwesomeSubstring1542();
        int a = f.longestAwesome(s2);
        //boolean x = f.isAwesome(s1,0,5);
        System.out.print(a);
    }
}
