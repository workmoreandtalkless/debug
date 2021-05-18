package binarysearch;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i] = true;

        }
        for(int i=0;i<n-1;i++){
            dp[i][i+1] = s.charAt(i)==s.charAt(i+1);
        }

        for(int j=0;j<n;j++){
            for(int i=j;i<=j;j++){
                if(s.charAt(i)==s.charAt(j) && (j-i<3||dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        int start = 0;
        int end = 0;
        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(dp[i][j]==true && max<j-i){
                    max = j-i;
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start,end+1);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "aaaaa";
        String x = lps.longestPalindrome(s);
        System.out.println(x);
    }
}
