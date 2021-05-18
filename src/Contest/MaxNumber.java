package Contest;

import java.util.Arrays;

public class MaxNumber {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = bi(nums,k);
        int l = 0;
        int r = index;
        int op = 0;
        while(l<=r){
            long x = nums[l]+nums[r];
            long t = (long)k;
            if(x==t){
                op++;
                l++;
                r--;
            }
            else if(x<t){
                l++;
            }
            else{
                r--;
            }
        }
        return op;
    }
    public int bi(int[] nums, int k){
        int l=0;
        int r=nums.length-1;
        int mid = 0;
        while(l<=r){
            mid = l+ (r-l)/2;
            if(nums[mid]==k){
                return mid;
            }
            else if(nums[mid]>k){
                r=mid-1;
            }
            else if(nums[mid]<k){
                l=mid+1;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,5,5,5};
        int k=5;
        MaxNumber mn= new MaxNumber();
        int x =  mn.bi(nums,k);
        System.out.print(x);
    }
}
