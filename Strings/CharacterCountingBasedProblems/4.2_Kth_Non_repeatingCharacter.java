Method1: O(n^2)

A Simple Solution is to run two loops. Start traversing from left side. 
For every character, check if it repeats or not. 
If the character doesn’t repeat, increment count of non-repeating characters. 
When the count becomes k, return the character.



Method2: O(n) + o(256log(256)) [for sorting] - time, o(1) - space 

Store the frequency of characters in string in an array.

Sort the array. 

Then while traversing the array print the kth non repeating char(frequency=1) (need not be at index k).


