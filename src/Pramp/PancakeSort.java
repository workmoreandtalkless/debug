package Pramp;

public class PancakeSort {



        public static void flip(int[] arr, int k ){
            help(arr,0,k);
        }
        public static void help(int[] arr, int b, int e ){
            int i = b;
            int j = e;
            while(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        static int[] pancakeSort(int[] arr) {
            // your code goes here


            for(int size = arr.length-1; size>0; --size){
                int mi = findMax(arr, size);
                //if(mi != size - 1){
                flip(arr,mi);
                flip(arr,size);
                //}
            }

            return arr;

        }
        public static int findMax(int[] arr, int n){
            int mi = 0;
            for(int i=0;i<=n;i++){
                if(arr[i]> arr[mi]) mi = i;
            }
            return mi;
        }
        /**
         1,5,4,3,2. size =5   mi =1  mi!= 5-1. flip(arr,1) 5,1,4,3,2. flip(arr,4) 3,4,1,5,2 //
         1,5,4,3,2            mi =1
         1.flip(mi)  ==>  5,1,4,3,2
         flip(size) ==> 2,3,4,1,5

         2.2,3,4,1,5  mi =2 (4)
         flip(mi)  ==> 4,3,2,1,5
         flip(size)==> 1,2,3,4,5



         3,4,1,5,2  size =4   mi =1  mi!= 4-1  flip(arr,1) 4,3,1,5,2. flip(arr,3) 1,3,4,5,2
         1,3,4,5,2  size =3   mi =2  mi == 3 -1
         1,3,4,5,2. size =2   mi =1  mi ==1
         1,3,4,5,2. size =1.  mi = 0
         */
        public static void main(String[] args) {
            int [] arr = {10,9,8,7,6,5,4,3,2,1};
            PancakeSort ps = new PancakeSort();
            for (int i:
                    ps.pancakeSort(arr) ) {
                System.out.print(i);
            }
        }

    }
