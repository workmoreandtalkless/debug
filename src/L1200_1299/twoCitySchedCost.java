package L1200_1299;

import java.util.Arrays;
import java.util.Comparator;

public class twoCitySchedCost {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) { // o2-o1 inverse  o1-o2 positive order
                return (o2[0]-o2[1])-(o1[0]-o1[1]);
            }
        });
        int total = 0;
        int n = costs.length/2;

        for(int i=0;i<n;++i) total += costs[i][0] + costs[i+n][1];
        return total;
    }

    public static void main(String[] args) {
        int[][] costs = {
                {10,20},
                {30,200},
                {400,50},
                {30,20}
        };
        twoCitySchedCost tcs=new twoCitySchedCost();
        int x = tcs.twoCitySchedCost(costs);
        System.out.println(x);
    }
}
