package Contest;

import L1500_1599.MakeSumDivisiblebyP;

public class MaximumProfitOfOperation {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int Profit = 0;
        int Max = Integer.MIN_VALUE;
        int cur = 1;
        int res = cur;
        int waiting = 0;
        int sum=0;
        for(int i=0;i<customers.length;i++){
            int arrive = customers[i];
            waiting = arrive + waiting;
            int board = waiting >= 4 ? 4 : waiting;
            waiting = waiting - board;
            sum+=board;
            Profit = sum*boardingCost - cur*runningCost;
            if(Profit>Max){
                Max = Profit;
                res = cur;
            }
            cur++;
        }
        while(waiting>0){
            int board = waiting >= 4 ? 4 : waiting;
            waiting = waiting - board;
            sum+=board;
            Profit = sum*boardingCost - cur*runningCost;
            if(Profit>Max){
                Max = Profit;
                res = cur;
            }
            cur++;
        }
        return Profit>=0 ? res : -1;
    }

    public static void main(String[] args) {
        int[] customers = {3,4,0,5,1};
        int bc =1;
        int rc =92;
        MaximumProfitOfOperation mpo = new MaximumProfitOfOperation();
        int x = mpo.minOperationsMaxProfit(customers,bc,rc);
        System.out.print(x);
    }
}
