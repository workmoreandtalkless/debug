package L1700_1799;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumEatenApple {
    public int eatenApples(int[] apples, int[] days) {
        Map<Integer,Integer> applesExpiry = new HashMap();
        PriorityQueue<Integer> queue = new PriorityQueue();

        int count = 0;
        for(int currentDay = 0; currentDay< apples.length||!queue.isEmpty();currentDay++){
            if(currentDay<apples.length){
                int currentExpiry = currentDay + days[currentDay];
                if(!applesExpiry.containsKey(currentExpiry)){
                    queue.offer(currentExpiry);
                }
                applesExpiry.put(currentExpiry,applesExpiry.getOrDefault(currentExpiry,0) + apples[currentDay]);
            }

            while(!queue.isEmpty() && queue.peek()<=currentDay){
                queue.poll();
            }
            if(!queue.isEmpty()){
                int latestExpiryDay = queue.peek();
                count++;
                applesExpiry.put(latestExpiryDay,applesExpiry.get(latestExpiryDay) - 1);
                if(applesExpiry.get(latestExpiryDay) == 0){
                    queue.poll();
                    applesExpiry.remove(latestExpiryDay);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int []apples ={1,2,3,5,2};
        int []days = {3,2,1,4,2};
        MaximumEatenApple me = new MaximumEatenApple();
        me.eatenApples(apples,days);
    }
}
