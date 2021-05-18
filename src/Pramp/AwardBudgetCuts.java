package Pramp;

import java.util.Arrays;

public class AwardBudgetCuts {

    static double findGrantsCap(double[] grantsArray, double newBudget) {
        // your code goes here
        // algorithm
        // give 1 to every element
        // until

        Arrays.sort(grantsArray);//[2,50,100,120,1000]
        double x =0;
        double cap = 0;
        double sum =0;
        for(int i=0;i<grantsArray.length;i++){ // i =0; i =1
            x = (newBudget - sum)/(grantsArray.length-i) ; // x = 190/5 - 0 ; x = 38  // x = (190-2)/4 47;
            if(x<grantsArray[i]){ // 38 < ? 2 not  47 < 100?
                cap = x;
                break;
            }
            else{
                cap = grantsArray[i]; // cap = 2;
                sum+= grantsArray[i];
            }
        }

        return cap;



    }
    /**
     public static double findsmall(double [] grantsArray){
     int sm = grantsArray[0];
     for(int i: grantsArray){
     if(i<sm) sm = i;
     }

     return sm;
     }
     */
    public static void main(String[] args) {
        double [] arr = {2, 100, 50, 120, 1000};
        double x = findGrantsCap(arr,900);
        System.out.println(x);
    }

}
