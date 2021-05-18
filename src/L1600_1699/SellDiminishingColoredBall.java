package L1600_1699;

import java.util.Arrays;

public class SellDiminishingColoredBall {

    int Mod = 100000007;
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        long ans = 0;
        int n = inventory.length-1;
        long count = 1;
        while(orders > 0){
            if(n > 0 && inventory[n] - inventory[n-1] > 0 && orders >= count * (inventory[n] - inventory[n-1])){
                ans += count * sumFromNtoX(inventory[n], inventory[n-1]);
                orders -= count * (inventory[n] - inventory[n-1]);
            }else if(n == 0 || inventory[n] - inventory[n-1] > 0){
                long a = orders / count;
                ans += count * sumFromNtoX(inventory[n], inventory[n]-a);
                long b = orders % count;
                ans += b * (inventory[n]-a);
                orders = 0;
            }
            ans %= 1000000007;
            n --;
            count ++;
        }
        return (int)ans;
    }
    private long sumFromNtoX(long n, long x){
        return (n*(n+1))/2 - (x*(x+1))/2;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,6,6,9,10};
        SellDiminishingColoredBall sdc = new SellDiminishingColoredBall();
       int x = sdc.maxProfit(arr,23);
       System.out.println(x);
    }
}
