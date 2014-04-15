
import java.util.ArrayList;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huyoucai
 */
/*
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".

*/
class Point{
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  
    
  } 
public class Solution {
 
    public String reverseWords(String s) {
        String result = null; 
         for (int i = s.length()-1; i >=0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }
    
    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    Some examples:\
    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    */
    public int evalRPN(String[] tokens) {
        Stack value = new Stack();
  //    try{ 
        for (int i = 0; i < tokens.length; i++) {
              if(isNumeric(tokens[i])){
                  value.push(tokens[i]);
              }else{
                 // we just considered the operation and ignore the function
                  int a = (Integer)value.pop();
                  int b =(Integer)value.pop();
                  switch(tokens[i]){
                      case "+":
                         value.push(a+b);
                      case "-":
                          value.push(a-b);
                      case "*":
                          value.push(a*b);
                       case "/":
                           value.push(a/b);
                       
                  }
              
              }
                     
        }
  //    }catch( runtimeexception e)  
          
    return 0;
    }
    
private boolean isNumeric(String str)  
{  
  try  
  {  
    int d = Integer.parseInt(str);  
  }  
  catch(NumberFormatException nfe)  
  {  
    return false;  
  }  
  return true;  
}


/*

You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

*/

/*Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * 
 * */

/**
 * 1.  find the longest sequence 
 * 
 * */	
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
        new_solution.add(current_point);
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
	if(slope(first, second) == slope(second,third)) 
	{
		return true;
	}
	else{
		return false; 
	}	
}

}	
