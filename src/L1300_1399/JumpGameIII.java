package L1300_1399;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
    Queue<Integer> q = new LinkedList();

    Set<Integer> set = new HashSet();
        q.add(start);
        set.add(start);
        while(!q.isEmpty()){
        int pos = q.poll();
        if(arr[pos]==0) return true;

        int nextp = Math.min(pos+arr[pos],arr.length-1);
        int nextn = Math.max(pos-arr[pos],0);
        if(!set.contains(nextp))
            q.add(nextp);
        if(!set.contains(nextp))
            q.add(nextn);
        set.add(nextp);
        set.add(nextn);
    }
        return false;}

    public static void main(String[] args) {
        int []arr = {4,2,3,0,3,1,2};
        int start = 5;

        int []arr1 ={5,11,18,16,21,3,19,0,16,4,9,20,2,13,0,2,23,8,19,22,16,19,19,25,25,15,7};
        int start1 = 18;

        JumpGameIII jg3 = new JumpGameIII();
       boolean x =  jg3.canReach(arr1,start1);
        System.out.print(x);
    }
}
