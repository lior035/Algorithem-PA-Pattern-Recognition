import java.util.Comparator;

public class Point implements Comparable<Point> 
{
    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new By_SLOPE_ORDER() ;       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y)
    {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() 
    {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that)
    {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that)
    {
         double div;
         double divider;
         
         //check all cases:
         
         if ((this.y == that.y) &&(this.x == that.x))
             return Double.NEGATIVE_INFINITY; // same point - insturcted to return this value
        
         else
         {
             div = (double)(that.y - this.y);
             divider = (double) (that.x - this.x);
             
             if (div == 0)
             {
                 double a = 1.0;
                 double ret = (a-a)/a; // positive zero
                 return ret;
             }
             
             else if (divider == 0)
                 return Double.POSITIVE_INFINITY;
             else
                 return div/divider;
         }
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    @Override
    public int compareTo(Point that) 
    {
        if (this.y<that.y)
            return -1;
        else if (this.y > that.y)
            return 1;
        
        else
        {
            //(this.y == that.y)
            
            if  (this.x<that.x)
               return -1;
            else if (this.x == that.x)
               return 0;
            else            //(this.x > that.x)
                return 1;
        }
    }

    // return string representation of this point
    @Override
    public String toString() 
    {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

  
    //inner class
    private class By_SLOPE_ORDER implements Comparator<Point>
    {

        @Override
        public int compare(Point o1, Point o2) 
        {
           double sloapPoint1;
           double sloapPoint2;
           
           
           sloapPoint1 = Point.this.slopeTo(o1);
           sloapPoint2 = Point.this.slopeTo(o2);
           
           //check all cases possible:
           
           if (sloapPoint1 == sloapPoint2)
               return 0;
           
           else if (sloapPoint1 < sloapPoint2)
               return -1;
           
           else
               return  1;
           
        }
        
    }
    
      // unit test
    public static void main(String[] args)
    {
        Point p1 = new Point (0,0);
        Point p2 = new Point (1,1);
        Point p3 = new Point (2,2);
        Point p4 = new Point (0,5);
        Point p5 = new Point (1,0);
        
        System.out.println(p2.compareTo(p3));
        System.out.println(p3.compareTo(p2));
        System.out.println(p2.compareTo(p2));
        System.out.println(p1.compareTo(p5));
        
        System.out.println(p2.SLOPE_ORDER.compare(p1, p3));
        System.out.println(p2.slopeTo(p3));
        System.out.println(p2.slopeTo(p2));
        System.out.println(p1.slopeTo(p4));
        System.out.println(p2.slopeTo(p4));
    }
    
}