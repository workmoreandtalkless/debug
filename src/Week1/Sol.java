package Week1;

public class Sol    {
    public static void main(String[] args) {
       // int [][] arr = {{0,1},{1,0},{1,2},{2,1}};

        //getMin g= new getMin();
       /* double x=g.getMinDistSum(arr);
        System.out.println(x);

        */
       maxPro m= new maxPro();
       int [][] edges ={{0,1},{1,2},{0,2}};
       int n=3;
       double [] succProb = {0.5,0.5,0.2};
       int start =0;
       int end = 2;

       double y=m.maxProbability(n,edges,succProb,start,end);
       System.out.println(y);
    }
}
