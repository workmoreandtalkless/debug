package L1000_1099;

public class LexicographicallySmallest {
    public String smallestEquivalentString(String A, String B, String S) {
        int []eq = new int[26];
        for (int i = 0; i < eq.length; i++) {
            eq[i]=i;
        }
        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            equal(eq,a,b);
        }
        String res="";
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int id = c-'a';
            res+=(char)(eq[id]+'a');
        }
        return res;
    }
    public void equal(int[] eq,char a,char b){
        int x = a-'a';
        int y = b-'a';

        if(eq[x]>eq[y]){
            int tmp = eq[x];
            eq[x]=eq[y];
            for (int i = 0; i < eq.length; i++) {
                if(eq[i]==tmp) eq[i]=eq[y];
            }
        }else {
            int tmp = eq[y];
            eq[y]=eq[x];
            for (int i = 0; i < eq.length; i++) {
                if(eq[i]==tmp) eq[i]=eq[x];
            }
        }
    }

    public static void main(String[] args) {
       String A= "dfeffdfafbbebbebacbbdfcfdbcacdcbeeffdfebbdebbdafff";
       String B= "adcdfabadbeeafeabbadcefcaabdecabfecffbabbfcdfcaaae";
       String S= "myickvflcpfyqievitqtwvfpsrxigauvlqdtqhpfugguwfcpqv";

        LexicographicallySmallest lgs = new LexicographicallySmallest();
        String s=lgs.smallestEquivalentString(A,B,S);
        System.out.print(s);
    }
}
