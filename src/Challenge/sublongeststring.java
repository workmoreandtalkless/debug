package Challenge;

public class sublongeststring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;
        if(n==1) return 1;
        int [] res = new int[256];
        int ans = 0;
        int lo = 0 ;
        //res[s.charAt(lo)]=1;
        for(int i=0;i<s.length();i++){
            if(res[s.charAt(i)]>0){
                lo = res[s.charAt(i)];
                //ans = Math.max(ans,i+1-lo);
            }
            res[s.charAt(i)] = i+1;
            ans = Math.max(ans,i+1 - lo);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 =  "pwwkew";
        String s3 = "bbbbbb";
        String s4 = "au";
        String s5 = "abba";

        sublongeststring sls = new sublongeststring();
        sls.lengthOfLongestSubstring(s5);

    }

}
