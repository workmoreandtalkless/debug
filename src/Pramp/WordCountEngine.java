package Pramp;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class WordCountEngine {
    final class MyEntry implements Map.Entry<String, Integer> {
        private final String key;
        private Integer value;

        public MyEntry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public Integer setValue(Integer value) {
            Integer old = this.value;
            this.value = value;
            return old;
        }
    }
    static String[][] wordCountEngine(String document) {
        // your code goes here
        // split the string to string arr
        String []  str = document.split(" ");
        for(String s:str){
            System.out.print(s+" ");
        }
        // go through the string arr
        Map<String,Integer> map = new HashMap();
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>();
        for(String s: str){
            if(s.equals(".")){continue;}
            String string = s.toLowerCase();

            map.put(string,map.getOrDefault(string,0)+1);
        }
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            pq.add(entry);
        }

        String [][] strarr = new String[pq.size()][2];
        int index = 0;
        for(Map.Entry<String,Integer> m: pq){
            strarr[index][0] = m.getKey();
            strarr[index][1] = Integer.toString(m.getValue());
        }

        return strarr;




    }

    public static void main(String[] args) {

    }

}
