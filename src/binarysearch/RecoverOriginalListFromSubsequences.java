package binarysearch;

import java.util.*;

public class RecoverOriginalListFromSubsequences {
    Map<Integer, Set<Integer>> f = new HashMap<>();
    Map<Integer,Integer> in = new HashMap<>();
    public int[] solve(int[][] A) {
        List<Integer> res = new ArrayList();
        for(int []p:A){
            for(int i=p.length-2;i>=0;i--){
                int cur = p[i];
                int next = p[i+1];
                if(!f.containsKey(cur)){
                    f.put(cur,new HashSet());
                    in.put(cur,0);
                }
                if(!f.containsKey(next)){
                    f.put(next,new HashSet());
                    in.put(next,0);
                }
                if(!f.get(cur).contains(next)){
                    f.get(cur).add(next);
                    in.put(next,in.get(next)+1);
                }
            }
        }
        Queue<Integer> q = new LinkedList();
        for(Integer k: in.keySet()){
            if(in.get(k)==0) q.add(k);
        }

        while(q.size()!=0){
            int top = q.poll();
            res.add(top);
            for(Integer next: f.get(top)){
                in.put(next,in.get(next)-1);
                if(in.get(next)==0){
                    q.add(next);
                }
            }
        }

        return to(res);
    }

    public int[] to(List<Integer>list){
        int res[]= new int[list.size()];
        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int [][] A = {
                {1,3},
                {2,3},
                {1,2}
        };
        RecoverOriginalListFromSubsequences rofs = new RecoverOriginalListFromSubsequences();
        int [] ans = rofs.solve(A);
        for (Integer a:ans
             ) {
            System.out.println("ans: " + a);
        }
    }
}
