public class GetWinner {

        public int getWinner(int[] arr, int k) {
            int win_count=0;
            int winner=0;

            int l=arr.length;
            int max=findmax(arr);

            int p1=0;
            int p2=1;
            if(l<=k){
                return max;
            }
            while(p1<arr.length&&p2<arr.length&&win_count<k){


                if(arr[p1]<arr[p2]){
                    if(winner!=arr[p2]) win_count=0;
                    winner=arr[p2];
                    win_count++;
                    if(win_count==k) return winner;
                    if(p1<p2) p1=p2+1;
                    else p1=p1+1;
                    if(p1==arr.length||p2==arr.length) return max;
                }
                else{
                    if(winner!=arr[p1]) win_count=0;
                    winner=arr[p1];
                    win_count++;
                    if(win_count==k) return winner;
                    if(p1<p2) p2=p2+1;
                    else p2=p1+1;
                    if(p1==arr.length||p2==arr.length) return max;
                }



            }
            return winner;
        }
        public int findmax(int []arr){
            int max=arr[0];
            for(int a:arr){
                if(a>max) max=a;
            }
            return max;
        }



    public static void main(String[] args) {
        int []arr1={1,9,8,2,3,7,6,4,5};
        int k=7;

        GetWinner getwinner = new GetWinner();
       int x= getwinner.getWinner(arr1,k);
       System.out.println(x);
    }
}
