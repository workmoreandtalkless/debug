package Contest;

public class MinimumLengthOfString {
    public int minimumLength(String s) {
        int l = 0;
        int r = s.length()-1;
        StringBuilder str = new StringBuilder(s);
        while(l<r){
            char left = str.charAt(l);
            char right = str.charAt(r);
            if(left!=right){
               return r-l+1;
            }
            if(l==r) return 1;
            while(l<r && str.charAt(l)==left) l++;
            while(l<r && str.charAt(r)==right) r--;

        }
        return r-l==0? 0:r-l+1;
    }

    public static void main(String[] args) {
        MinimumLengthOfString mls = new MinimumLengthOfString();
        mls.minimumLength("cabaabac");
    }
}
