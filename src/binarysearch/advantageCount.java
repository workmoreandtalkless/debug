package binarysearch;

import java.util.*;

public class advantageCount {

    public int[] advantageCount(int[] A, int[] B) {

        int [] sortedA = A.clone();
        int [] sortedB = B.clone();

        Arrays.sort(sortedA);
        Arrays.sort(sortedB);

        Map<Integer, Deque<Integer>> assigned = new HashMap();
        for(int b:B) assigned.put(b,new LinkedList());
        Deque<Integer> remaining = new LinkedList();

        int j=0;
        for(int a : sortedA){
            if(a>sortedB[j]){
                assigned.get(sortedB[j++]).add(a);
            }else{
                remaining.add(a);
            }
        }

        int [] ans = new int[B.length];
        for(int i=0;i<B.length;i++){
            if(assigned.get(B[i]).size()>0){
                ans[i] = assigned.get(B[i]).pop();
            }else{
                ans[i] = remaining.pop();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int []A = {12,24,8,32};
        int []B = {13,25,32,11};
        advantageCount ac = new advantageCount();
        int C[]= ac.advantageCount(A,B);
        for (int c: C) {
            System.out.println(c);
        }


    }
}
