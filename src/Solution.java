
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

public class Solution {

 
    
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
}

