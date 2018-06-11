https://www.geeksforgeeks.org/count-number-of-substrings-with-exactly-k-distinct-characters/

Method 1 (Brute Force)

If the length of string is n, then there can be n*(n+1)/2 possible substrings. 
A simple way is to generate all the substring and check each one whether it has exactly k unique characters or not. 
If we apply this brute force, it would take O(n*n) to generate all substrings and O(n) to do a check on each one. 
Thus overall it would go O(n*n*n).