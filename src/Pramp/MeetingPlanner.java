package Pramp;

public class MeetingPlanner {
    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        // your code goes here
        // int []ans = new int[2];



        int indexa =0;
        int indexb =0;
        // go through the slotsA and slotsB
        while(indexa<slotsA.length && indexb<slotsB.length){
            int curA=0,curB=0;
            int compS = slotsA[indexa][0] - slotsB[indexb][0];
            int compE = slotsA[indexa][1] - slotsB[indexb][1];
            //if compare larger than 0, the first element of slots A[i][0] > B[i][0];
            // compare the start time and end time seprately
            if(compS>=0&&compE<=0){
                curA = slotsA[indexa][0];
                curB = slotsA[indexa][1];
            }
            else if(compS<=0&&compE<=0){
                curA = slotsB[indexb][0];
                curB = slotsA[indexa][1];

            }
            else if(compS>=0&&compE>=0){
                curA = slotsA[indexa][0];
                curB = slotsB[indexb][1];
            }
            else if(compS<=0&&compE>=0){
                curA = slotsB[indexb][0];
                curB = slotsB[indexb][1];
            }

            // find the length is larger than the dur
            int length = curB - curA;
            if(length>=dur){
                return new int[]{curA, curA + dur};

            }

            indexa++;
            indexb++;
        }

        return new int[]{};


        // return the res.
    }

    public static void main(String[] args) {
        int [][] arrA = {{10,50},{60,120},{140,210}};
        int [][] arrB ={{0,15},{60,70}};
        int dur =8;

        MeetingPlanner mp = new MeetingPlanner();
       int []arr= mp.meetingPlanner(arrA,arrB,dur);
     }
}
