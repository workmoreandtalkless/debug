package L1600_1699;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindtheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        //1.Build a double-ended queue, named queue that holds the chosen subsequence at any given point.
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int additionalCount = nums.length - k;
        //2. Iterate over array nums, choose the most competitive elements and add it to the queue.
        for(int i=0;i<nums.length;i++){

            while(!queue.isEmpty()&& queue.peekLast()>nums[i] && additionalCount > 0){
                queue.pollLast();
                additionalCount--;
            }
            queue.addLast(nums[i]);
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = queue.pollFirst();
        }

        return result;
    }

    public static void main(String[] args) {
        FindtheMostCompetitiveSubsequence fm = new FindtheMostCompetitiveSubsequence();
        int []nums = {3,6,4,2,1};
        int k=3;
        int arr [] = fm.mostCompetitive(nums,k);
    }
}
