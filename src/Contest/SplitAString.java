package Contest;

import java.util.HashSet;
import java.util.Set;

public class SplitAString {
    public int maxUniqueSplit(String s) {
        char [] str = s.toCharArray();
        Set<String> set = new HashSet<>();
        int cnt =0;
        for (int i = 0; i < str.length; i++) {
            if(set.contains(Character.toString(str[i]))){
                        String s1="";
                        s1+= Character.toString(str[i-1]);
                        s1+=Character.toString(str[i]);
                        set.remove(Character.toString(str[i-1]));
                        set.add(s1);

            }else {
                set.add(Character.toString(str[i]));
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        SplitAString sas = new SplitAString();
        String s= "gahbag";
        sas.maxUniqueSplit(s);
    }
}
