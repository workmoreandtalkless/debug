public class MinimumInsertionsToBalanceParentheseString1541 {
    public int minInsertions(String s) {
        int ans=0;
        int cnt=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') {
                cnt+=2;
                if(cnt%2!=0){
                    ans++;
                    cnt--;
                }
            }
            else{
                cnt-=1;
                if(cnt<0){
                    ans++;
                    cnt+=2;
                }
            }
        }

        return ans+cnt;
    }

    public static void main(String[] args) {
        MinimumInsertionsToBalanceParentheseString1541 m = new MinimumInsertionsToBalanceParentheseString1541();
        int x = m.minInsertions("))())(");
        System.out.print(x);
    }

}
