package Contest;

public class SmallestString {
    public String getSmallestString(int n, int k) {

        int []ans = new int[n];
        int right =0;
        for(int i= n-1;i>=0;i--){

            if(i>=n-1){
                right = 0;
            }
            else{
                right += ans[i+1];
            }
            int sum = i;
            int tmp = k - sum;
            if(tmp<0){
                break;
            }
            if(tmp<=26&&tmp>=1){
                ans[i]=tmp;
                k -=tmp;
                break;
            }
            if(tmp>26){
                ans[i]=26;
                k -=26;
                continue;
            }
        }
        for(int i=0;i<n;i++){
            if(ans[i]==0) ans[i]=1;
            else{
                break;
            }

        }
        String s ="";
        for(int i=0;i<n;i++){
            s += (char)(ans[i]+96);
        }
        return s;
    }

    public static void main(String[] args) {
        int n=96014;
        int k=2095650;
        SmallestString ss= new SmallestString();
        String x = ss.getSmallestString(n,k);
        System.out.println(x);
    }
}
