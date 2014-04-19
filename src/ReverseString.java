/*

You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

public class ReverseString {
    

    public String reverseWords(String s) {
        String result = null; 
         for (int i = s.length()-1; i >=0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }
    
}
