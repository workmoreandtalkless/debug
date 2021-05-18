package Week1;

public class getMin {

        public double getMinDistSum(int[][] positions) {
            double min = Double.MAX_VALUE;
            //(x,y) is the center of the current area, delta is the distance we search from the center
            double x =50,y=50,delta=50;
            //track the best point we found
            double min_x = x, min_y = y;

            while (delta>=10e-4){
                //"delta/100" is the incremental step, so the time cost will be 200*200 for each loop.
                for(double i= x-delta;i<=x+delta;i+=delta/100){
                    for(double j= y-delta;j<=y+delta;j+=delta/100){
                        double d = dist(positions,i,j);
                        if(d<=min){
                            min=d;
                            min_x=i;
                            min_y=j;
                        }
                    }
                }
                //reset the center for the searching area to (min_x,min_y), set delta to the incremental step delat/100
                x=min_x;
                y=min_y;
                delta/=100;
            }
            return min;
        }

        public double dist(int [][] positions , double x, double y){
            double ans =0;
            for(int [] p: positions){
                double d = Math.pow(p[0]-x,2)+Math.pow(p[1]-y,2);
                ans+= Math.sqrt(d);
            }
            return ans;
        }

}
