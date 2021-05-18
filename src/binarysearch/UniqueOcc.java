package binarysearch;

import java.util.HashSet;
import java.util.Set;

public class UniqueOcc {
    public boolean solve(int[] nums) {
        int n = nums.length;
        int[] num = new int[200000];
        for(int i=0;i<n;i++){
            num[nums[i]]++;
        }

        Set<Integer> set = new HashSet();
        for(int i=0;i<n;i++){
            int val = nums[i];
            int occ = num[val];
            if(set.contains(occ)) return false;
            set.add(occ);
        }

        return true;

    }

    public static void main(String[] args) {
        int []nums = {1,1,2,2,1};
        UniqueOcc uo= new UniqueOcc();
        uo.solve(nums);
    }
}
