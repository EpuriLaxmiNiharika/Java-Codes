Other methods:

1) Run two for loops. 

		for (int i=0; i<n; i++) {
		        
		     // Check if str[i] is present before it  
		     int j;  
		     for (j=0; j<i; j++) 
		        if (str[i] == str[j])
		           break;
		      
		     // If not present, then add it to
		     // result.
		     if (j == i)
		        str[index++] = str[i];
		   }
		return str


2) Use Hashing technique

3) Do sorting first. Then traverse by remove duplicates

4) 