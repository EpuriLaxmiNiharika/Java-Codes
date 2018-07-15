Method 1 (Divide the array in slots of size n/k)
A simple way to implement k stacks is to divide the array in k slots of size n/k each, and fix the slots for different stacks, i.e., use arr[0] to arr[n/k-1] for first stack, and arr[n/k] to arr[2n/k-1] for stack2 where arr[] is the array to be used to implement two stacks and size of array be n.

The problem with this method is inefficient use of array space. 

A stack push operation may result in stack overflow even if there is space available in arr[]. 

	For example, say the k is 2 and array size (n) is 6 and we push 3 elements to first and do not push anything to second second stack. 
		When we push 4th element to first, there will be overflow even if we have space for 3 more elements in array.