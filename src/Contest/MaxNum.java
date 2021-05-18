package Contest;

import L1400_1499.MaximumProductOfSplittedBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxNum {
    // this is the result when I doing contest, but there is a case which its result is 102, but I print out 103.
    public int eatenApples(int[] apples, int[] days) {
        int []rots = new int[days.length];
        int []date = new int[20000+days.length];
        Map<Integer,ArrayList<Integer>> map = new HashMap();
        for(int i=0;i<days.length;i++){
            rots[i]=i+days[i];
        }
        for(int i=0;i<days.length;i++){
            int rd = rots[i];
            date[rd] +=apples[i];
            if(map.containsKey(rd)&&days[i]!=0){
                map.get(rd).add(i);
            }if(!map.containsKey(rd)&&days[i]!=0){
                ArrayList<Integer> l = new ArrayList();
                l.add(i);
                map.put(rd,l);

            }

        }
        int res=0;
        int index = 0;
        for(int i=0;i<date.length;i++){

            if(date[i]>0){

                ArrayList<Integer> list = map.get(i);

                for(int j=0;j<list.size();j++){
                    int growdate = list.get(j);
                    if(growdate<=index){
                        res += Math.min(i-index,apples[growdate]);
                        index = Math.min(i,res);
                        if(i-index<apples[growdate]) break;
                    }else{
                        index = growdate;
                        res += Math.min(i-index,apples[growdate]);
                        index = Math.min(i,res);
                        if(i-index<apples[growdate]) break;
                    }
                }


            }
        }
        return res;


    }
//    public int eatenApples(int[] apples, int[] days) {
//        int n = days.length;
//        int [] applesExpiry = new int[n + 20001];
//        int count = 0;
//        int lastDay = n;
//        int latestExpiryPointer = 0;
//
//        for(int currentDay = 0; currentDay < lastDay; currentDay++){
//
//            if(currentDay < n){
//                int currentExpiry = days[currentDay] + currentDay;
//                applesExpiry[currentExpiry] += apples[currentDay];
//                if(currentExpiry<latestExpiryPointer)
//                    latestExpiryPointer = currentExpiry;
//                if(currentExpiry > lastDay) lastDay = currentExpiry;
//            }
//            while((latestExpiryPointer<=currentDay||applesExpiry[latestExpiryPointer]==0)&&latestExpiryPointer<lastDay){
//                latestExpiryPointer++;
//            }
//            if(applesExpiry[latestExpiryPointer]!=0){
//                applesExpiry[latestExpiryPointer]--;
//                count++;
//            }
//        }
//
//        return count;
//
//    }

    public static void main(String[] args) {
        int []apples = {0,19,19,19,11,14,33,0,28,7,0,28,7,0,21,16,0,22,0,13,8,0,19,0,0,2,26,2,22,0,8,0,0,27,19,16,24,0,20,26,20,7,0,0,29,0,0,16,19,0,0,0,29,30,17,0,23,0,0,26,24,13,3,0,21,0,18,0};
        int []days = {0,5,1,16,7,10,54,0,40,2,0,23,4,0,20,18,0,40,0,22,8,0,35,0,0,3,24,1,8,0,10,0,0,2,38,8,4,0,36,33,14,9,0,0,56,0,0,21,27,0,0,0,14,20,18,0,42,0,0,44,3,8,3,0,10,0,27,0};
        int []ap = {3,0,0,0,0,2};
        int []d = {3,0,0,0,0,2};

        int []a = {1,2,3,5,2};
        int []da = {3,2,1,4,2};
        MaxNum mn = new MaxNum();
          System.out.println(mn.eatenApples(apples,days));
        }
}
