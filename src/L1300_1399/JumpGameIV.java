package L1300_1399;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        Queue<Integer> q = new LinkedList();
        Map<Integer, List<Integer>> map = new HashMap();
        Set<Integer> set = new HashSet();
        for(int i=0;i<arr.length;i++){
            int number = arr[i];
            if(map.containsKey(number)){
                map.get(number).add(i);
            }else{
                LinkedList<Integer> list = new LinkedList();
                list.add(i);
                map.put(number,list);

            }
        }
        int [] isVisit = new int[arr.length];
        int [] minSteps = new int[arr.length];
        int minStep = 0;
        q.add(0);

        while(!q.isEmpty()){
            int index = q.poll();
            int arrnumber = arr[index];
            isVisit[index]=1;

            if(index==arr.length-1) return minSteps[index];
            if(map.containsKey(arrnumber)&&map.get(arrnumber).size()>1&&!set.contains(arrnumber)){
                int jump;
                for(int i=0;i<map.get(arrnumber).size();i++){
                    jump = map.get(arrnumber).get(i);
                    if(isVisit[jump]!=1 && jump!=index){
                        q.add(jump);
                        minSteps[jump]=minSteps[index]+1;
                        isVisit[jump]=1;
                    }
                }
            }
            set.add(arrnumber);
            int nextp = index+1;
            if(nextp<arr.length && isVisit[nextp]!=1 &&!set.contains(arr[nextp])){
                q.add(nextp);
                minSteps[nextp]=minSteps[index]+1;
                isVisit[nextp]=1;


            }
            int nextn = index-1;
            if(nextn>0 && isVisit[nextn]!=1&&!set.contains(arr[nextn])){
                q.add(nextn);
                minSteps[nextn]=minSteps[index]+1;
                isVisit[nextn]=1;

            }


        }
        return minSteps[arr.length-1];
    }

    public static void main(String[] args) {
        int []arr = {100,-23,-23,404,100,23,23,23,3,404};
        JumpGameIV jiv = new JumpGameIV();
        int x = jiv.minJumps(arr);
        System.out.print(x);
    }
}

