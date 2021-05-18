package L1000_1099;

public class ShortestCommonSupersequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        String [][] dp = new String[l2+1][l1+1];
        // for(int j=0;j<l2;j++){
        //     dp[0][j] = "";
        // }
        // for(int i=0;i<l1;i++){
        //     dp[i][0] = "";
        // }
        for(int i=0;i<l2+1;i++){
            for(int j=0;j<l1+1;j++){
                dp[i][j]="";
            }
        }
        for(int i=0;i<l2;i++){
            for(int j=0;j<l1;j++){
                if(str1.charAt(j)==str2.charAt(i)){
                    dp[i+1][j+1] = dp[i][j] + str1.charAt(j);
                }else{
                    dp[i+1][j+1] = dp[i][j+1].length()>dp[i+1][j].length() ? dp[i][j+1]:dp[i+1][j];
                }
            }
        }
        StringBuilder sb = new StringBuilder(dp[l2][l1]);
        System.out.println(sb);
        String res = "";
        int p2=0;
        int p1=0;

        for(char c: dp[l2][l1].toCharArray()){
            while(c!=str2.charAt(p2)){
                res = str2.charAt(p2)+res;
                p2++;
            }
            while(c!=str1.charAt(p1)){
                res = str1.charAt(p1)+res;
                p1++;
            }

            res += c;
            p1++;
            p2++;
        }

        while(p1<str1.length()){
            res += str1.substring(p1);
            break;
        }
        while(p2<str2.length()){
            res += str2.substring(p2);
            break;
        }
        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);



        return res;
    }

    public static void main(String[] args) {
        ShortestCommonSupersequence scs = new ShortestCommonSupersequence();
        String str1 = "bbbaaaba";
        String str2 = "bbababbb";
        scs.shortestCommonSupersequence(str1,str2);
    }
}
