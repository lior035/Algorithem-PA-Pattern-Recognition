
import java.util.Arrays;

public class Fast
{
   
   public static void main(String[] args)
   {
       int k;
       int ind;
       int currRun =0;
       int startSub = 0;
       int count = 0;  
       int minIndex = 0;
       int total=0;
       
       String argFileName = args[0];
       In in = new In (argFileName);
       
       k = in.readInt();
       Point[] points = new Point [k];
       Point[] copy = new Point[ k];
       double[] slopes = new double [k];

       k = 0;
       
       while (!in.isEmpty())
       {
           int x = in.readInt();
           int y = in.readInt();
           points[k] = new Point (x,y);
           copy[k] = new Point (x,y);
           k++;
       }
       
        //drew points:
       StdDraw.setXscale(0, 32768);
       StdDraw.setYscale(0, 32768);
       
       for (k = 0; k<points.length; k++)
           points[k].draw();
     
        Arrays.sort(copy);
       for (ind = 0; ind<points.length; ind++)
       {
          Arrays.sort(points, copy[ind].SLOPE_ORDER);
          
          //calc slops:
          for (int i = 0; i<points.length; i++)
            slopes[i] = copy[ind].slopeTo(points[i]);
   
          currRun = 1;
          startSub = 1;
          count = 0;
          
          while (currRun < slopes.length)
          {
              if (currRun == points.length-1) // edge case
              {
                  if (count>=2)
                  {
                      Arrays.sort(points,startSub, currRun+1);
                      int indicator = copy[ind].compareTo(points[startSub]);
                      if (indicator <0)
                      {
                          System.out.print (copy[ind] + " -> ");
                         // copy[ind].drawTo(points[startSub]);
                          for (; startSub<=currRun-1; startSub++)
                          {
                              System.out.print (points[startSub] + " -> ");
                         //     points[startSub].drawTo(points[startSub+1]);
                          }
                          copy[ind].drawTo(points[startSub]);
                          System.out.println(points[startSub++]);
                          
                          count = 0;
                          currRun++;
                          startSub = currRun;
                          total++;
                      }
                      
                      else
                      {
                          currRun++;
                          startSub = currRun;
                          count =0;
                      }
                  }
                  
                  break;
                   
              }
              
              else
              {
                  if (slopes[currRun]==slopes[currRun+1])
                  {
                      count++;
                      currRun++;
                  }
                  
                  else if (count>=2)
                  {
                     
                      Arrays.sort(points,startSub, currRun+1);
                      int indicator = copy[ind].compareTo(points[startSub]);
                      if (indicator <0)
                      {
                          System.out.print (copy[ind] + " -> ");
                         // copy[ind].drawTo(points[startSub]);
                          for (; startSub<=currRun-1; startSub++)
                          {
                              System.out.print (points[startSub] + " -> ");
                          //    points[startSub].drawTo(points[startSub+1]);
                          }
                          copy[ind].drawTo(points[startSub]);
                          System.out.println(points[startSub++]);
                          
                          count = 0;
                          currRun++;
                          startSub = currRun;
                          total++;
                      }
                      
                      else
                      {
                          currRun++;
                          startSub = currRun;
                          count =0;
                      }
                  }
                  
                  else
                  {
                      count = 0;
                      currRun++;
                      startSub = currRun;
                  }
              }
          }
           
           
           
       }
       
    //System.out.println("total " + total);
   }
}
  