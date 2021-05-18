package Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BrokenCalculator {
    int min = Integer.MAX_VALUE;
    Map<Integer,Integer> map = new HashMap();
    Set<Integer> set = new HashSet();
    public int brokenCalc(int X, int Y) {
        dfs(X,Y,0);
        return min;
    }
    public void dfs(int X,int Y,int cnt){
//        System.out.println("X:Y:"+X+" "+Y+" ");
        if(X==Y){
            min = Math.min(min,cnt);
            //return;
        }
        if(X==0) return;
        if(set.contains(X)) return;
        set.add(X);
        if(X>Y){
            int x = X-Y;
            dfs(X-x,Y,cnt+x);
        }else{
            dfs(X-1,Y,cnt+1);
            dfs(X*2,Y,cnt+1);
        }




    }

    public static void main(String[] args) {
        BrokenCalculator bc = new BrokenCalculator();
        bc.brokenCalc(3,10);
    }
}
