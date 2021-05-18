package L1500_1599;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisiblebyP {
    public int minSubarray(int[] A, int p) {
        int n= A.length, res = n,need = 0, cur =0;
        for(int a: A)
            need = (need + a)%p;
        Map<Integer,Integer> last = new HashMap();
        last.put(0,-1);
        for(int i=0;i<n;++i){
            cur = (cur + A[i])%p;
            last.put(cur,i);
            int want = (cur - need + p) % p;
            res = Math.min(res, i - last.getOrDefault(want, -n));
        }
        return res<n? res:-1;
    }

    public static void main(String[] args) {
        int [] A ={3,1,4,2};
        int p = 6;

        int [] A1 ={6,3,5,2};
        int p1 = 9;

        MakeSumDivisiblebyP msd = new MakeSumDivisiblebyP();
        int x= msd.minSubarray(A1,p1);
        System.out.print(x);
    }
}
