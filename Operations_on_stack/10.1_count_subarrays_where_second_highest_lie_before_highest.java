BRUTE FORCE:

1. Find all the subarrays.
2. For each subarray, find second largest and largest element.
3. Check if second largest element lie before largest element.
4. If so, check if such index pair is already counted or not. If not store the pair and increment the count by 1, else ignore.
Time Complexity: O(n2).