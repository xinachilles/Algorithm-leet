
import java.util.ArrayList;

/*

/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * 
 * */

/**
 * 1.  find the longest sequence 
 * 
 * */

class Point{
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  
    
  } 
public class FindMaxPoints {
	
public int maxPoints(Point[] points) {
	return longestIncreasingSubsequence(points);
	
    }

private int longestIncreasingSubsequence(Point[] points)
{
	ArrayList<Point>[] solutions = new ArrayList[points.length];
	longestIncreasingSubsequence(points, solutions, 0);
	
	return 0;
}

private void longestIncreasingSubsequence(Point[] points,ArrayList<Point>[] solutions, int current_index)
{
	if(current_index>=points.length || current_index < 0) return; 
	
	Point current_point= points[current_index];
        /* Find longest sequence we can append current_element to */
        ArrayList<Point> best_sequence = null;
	for( int i =0; i<current_index;i++)
	{
		best_sequence = findBestSequence(solutions[i],best_sequence);
		
	}
	ArrayList<Point> new_solution = new ArrayList<>();
        if(best_sequence !=null){
            new_solution.addAll(best_sequence);
        }
        if(new_solution.size()<2 || IsSameLine( new_solution.get(0), new_solution.get(1),current_point) ) 
        {
            new_solution.add(current_point);    
        }
        
        solutions[current_index] = new_solution;
        longestIncreasingSubsequence(points, solutions, current_index+1);
        
}
ArrayList<Point> findBestSequence( ArrayList<Point> s1, ArrayList<Point> s2 ){
    if( s1 == null) return s2;
    if(s2 == null) return s1;
    if(s2.size()>s1.size()){
        return s2;
    }
    else{
        return s1;
    } 
}
private double slope(Point first,Point second)
{
	if(first.y == second.y)
	{
		return 0;
	}
	else{
		return (first.x-second.y) /(first.y -second.y);
		
	}
}


private boolean IsSameLine(Point first,Point second,Point third )
{
        return slope(first, second) == slope(second,third);	
}

}	
 

