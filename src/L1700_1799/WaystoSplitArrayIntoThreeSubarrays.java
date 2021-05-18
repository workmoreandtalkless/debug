package L1700_1799;

import java.util.Comparator;
import java.util.TreeMap;

public class WaystoSplitArrayIntoThreeSubarrays {
    public int waysToSplit(int[] nums) {
        int MOD = 1000000007;
        int len = nums.length;
        int []presum = new int[len + 1];
        for(int i=0;i<len;i++){
            presum[i+1] += presum[i] + nums[i];
        }
        TreeMap<Integer[], Integer> tree = new TreeMap<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if (o1[0].compareTo(o2[0]) != 0) {
                    return o1[0].compareTo(o2[0]);
                } else {
                    return o1[1].compareTo(o2[1]);
                }
            }
        });

        for(int i=0;i<len+1;i++){
            tree.put(new Integer[]{presum[i],i},i);
        }

        long result = 0;
        for(int i =0;i<len-2;i++){//2 is the mid and right part
            int leftSum = presum[i+1];
            int remain = presum[len] - leftSum;
            if(remain<leftSum*2){
                break;
            }
            int first = Math.max(i+2,tree.ceilingEntry(new Integer[]{leftSum*2,i+2}).getValue());
            int last = Math.min(len-1,tree.floorEntry(new Integer[]{
                    leftSum + remain/2, len-1
            }).getValue());

            result += Math.max(last-first + 1,0);
        }

        return (int)(result%MOD);

    }

    public static void main(String[] args) {
        int [] arr = {1,2,2,2,5,0};
        WaystoSplitArrayIntoThreeSubarrays wts = new WaystoSplitArrayIntoThreeSubarrays();
        int x = wts.waysToSplit(arr);
        System.out.println(x);
    }
}
