/** Drew all 4 points line using time of n^4
/** Command line arguments input - file name with input format as described    */

import java.lang.*;
import java.util.*;

public class Brute
{
    
   public static void main(String[] args)
   {
       int k;
       int index1, index2, index3, index4;
       
       String argFileName = args[0];
       In in = new In (argFileName);
       
       k = in.readInt();
       Point[] points = new Point [k];
       k = 0;
       
       while (!in.isEmpty())
       {
           int x = in.readInt();
           int y = in.readInt();
           points[k] = new Point (x,y);
           k++;
       }
       
       //drew points:
       StdDraw.setXscale(0, 32768);
       StdDraw.setYscale(0, 32768);
       
       for (k = 0; k<points.length; k++)
           points[k].draw();
     
       Arrays.sort(points);
       
       for (index1=0; index1<points.length; index1++)
       {
           for (index2 = index1+1; index2<points.length; index2++)
           {
               for (index3 = index2+1; index3<points.length; index3++)
               {
                   for (index4 = index3+1; index4<points.length; index4++)
                   {
                       if (points[index1].slopeTo(points[index2]) == points[index2].slopeTo(points[index3]))
                       {
                           if (points[index2].slopeTo(points[index3]) == points[index3].slopeTo(points[index4]))
                           {
                               points[index1].drawTo(points[index4]);
                               System.out.println(points[index1].toString() + " -> "+
                                                  points[index2].toString() + " -> "+
                                                  points[index3].toString() + " -> "+
                                                  points[index4].toString());
                           }
                       }
                   }
               }
           }
       }
   }  
}