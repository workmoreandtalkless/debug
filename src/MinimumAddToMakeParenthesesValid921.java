public class MinimumAddToMakeParenthesesValid921 {
    public int minAddToMakeValid(String S) {
        int bal=0,ans=0;
        for(int i=0;i<S.length();i++){
            bal += S.charAt(i)== '(' ? 1:-1;
            if(bal==-1){
                ans++;
                bal=0;
            }
        }
        return ans+bal;
    }
    public static void main(String[] args) {
        String s= "((()))))";
        MinimumAddToMakeParenthesesValid921 m = new MinimumAddToMakeParenthesesValid921();
        int x=m.minAddToMakeValid(s);
        System.out.print(x);
    }
}
