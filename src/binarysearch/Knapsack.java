package binarysearch;

import java.util.HashMap;

public class Knapsack {
    public int solve(int[] weights, int[] values, int capacity) {
        return dfs(weights,values,0,capacity,values.length);
    }

    HashMap<String,Integer> map = new HashMap();
    private int dfs(int[] weights, int[]values, int index, int capacity, int n){
        if(index == n || capacity<=0){
            return 0;
        }
        String key = index + " " + capacity;
        Integer v = map.get(key);
        if(v!=null){
            return v;
        }
        int value = dfs(weights,values,index+1,capacity,n);
        if(weights[index]<=capacity){
            value = Math.max(value,values[index] + dfs(weights,values,index+1,capacity-weights[index],n));
        }
        map.put(key,value);
        return value;
    }

    public static void main(String[] args) {
        int []weights ={1,2,3};
        int[]values={1,5,3};
        int capacity = 5;
        Knapsack ks = new Knapsack();
        ks.solve(weights,values,capacity);
    }
}
