package Contest;

import static java.lang.Long.toBinaryString;

public class Concatenation {

    long mod = 1000000007;
    public int concatenatedBinary(int n) {
        String s="";
        for(int i=1;i<=n;i++){
            s+=toBinaryString(i);
        }
        long x = 0;
        int index = 0;
        for(int i=s.length()-1;i>=0;i--){
            long numb = (s.charAt(i) - '0');
            int ti = index;
            long power = 1;
            while(ti>0){
                power = power*2;
                ti--;
            }

            long temp = numb * power;
            x = (temp+x)%mod;
            // x = x % mod;
            index++;
        }
        System.out.println(index);
        return (int)(x);
    }

    public static void main(String[] args) {
        int n = 42;
        Concatenation ct = new Concatenation();
       int res =   ct.concatenatedBinary(n);
       System.out.print(res);
    }
}
