public class HTreeConstruction {
    static public void drawline(double x1,double y1,double x2, double y2){
        System.out.println("Line is drawn by the point: " + "(" + x1 + "," + y1 + ") " + "and " + "(" + x2 + "," + y2 + ")");

    }
    public static void drawTree(double x, double y ,double length,double depth){
        if(depth == 0) return;
        double x0 = x - length/2;
        double x1 = x+ length/2;
        double y0 = y - length/2;
        double y1 = y + length/2;

        // draw the 3 line segments of the H - Tree
        drawline(x0,y0,x0,y1); //left segment
        drawline(x1,y0,x1,y1); //right segment
        drawline(x0,y,x1,y); //connecting segment

        // at each stage, the length of segments decrease by a factor of √2

        double newlength = length/Math.sqrt(2);
        //decrement depth by 1 and draw an H-tree
        // at each of the tips of the current 'H'

        drawTree(x0,y0,newlength,depth-1); // lower left
        drawTree(x0,y1,newlength,depth-1);
        drawTree(x1,y0,newlength,depth-1);
        drawTree(x1,y1,newlength,depth-1);

    }
    public static void main(String[] args) {

        drawTree(0,0,8,2);
    }
}
