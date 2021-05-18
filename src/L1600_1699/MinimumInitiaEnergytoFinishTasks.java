package L1600_1699;

import java.util.Arrays;

public class MinimumInitiaEnergytoFinishTasks {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks,(a,b)->{
            int x = a[1]-a[0];
            int y = b[1]-b[0];
            if(x==y){
                return b[1] - a[1];
            }
            else {
                return y-x;
            }
        });

        int a = 0;
        int res = a;
        for (int i = 0; i < tasks.length; i++) {

//            int tmp = tasks[i][1] - tasks[i][0];
            if(a<tasks[i][1]){
                int diff = tasks[i][1] - a;
                res += diff;
                    a +=diff;
                    a -=tasks[i][0];
            }
            else{
                a -= tasks[i][0];
            }


        }
        return res;

    }

    public static void main(String[] args) {
        int [][] t = {
                {1,2},
                {2,4},
                {4,8}
        };

        MinimumInitiaEnergytoFinishTasks meft = new MinimumInitiaEnergytoFinishTasks();
        int x = meft.minimumEffort(t);
        System.out.println(x);
    }
}
