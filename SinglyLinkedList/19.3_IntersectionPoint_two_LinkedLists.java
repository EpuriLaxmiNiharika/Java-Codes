
METHOD1:


This solution requires modifications to basic linked list data structure. Have a visited flag with each node. 
Traverse the first linked list and keep marking visited nodes. Now traverse second linked list, 
If you see a visited node again then there is an intersection point, return the intersecting node. 
This solution works in O(m+n) but requires additional information (mark node as visited or not) with each node



METHOD2:

Traverse both list1, list2. Store the address of the last nodes in both the lists.
If both addresses are same => there is intersection point somewhere in the list
else => No intersection point