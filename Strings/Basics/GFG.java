import java.util.*;
 
class IndexOf {
     
    // Function to make the string unique
    public static String unique(String s)
    {
        String str = new String();
        int len = s.length();
         
        // loop to traverse the string and
        // check for repeating chars using
        // IndexOf() method in Java
        for (int i = 0; i < len; i++) 
        {
            // character at i'th index of s
            char c = s.charAt(i);
             
            // if c is present in str, it returns
            // the index of c, else it returns -1

            if (str.indexOf(c) < 0)
            {
                // adding c to str if -1 is returned
                str += c;
            }
        }
         
        return str;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        // Input string with repeating chars
        String s = "geeksforgeeks";
         
        System.out.println(unique(s));
    }
}