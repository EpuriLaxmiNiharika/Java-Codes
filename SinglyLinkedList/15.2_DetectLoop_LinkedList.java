import java.util.HashMap;

class Node
{
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 
// Linked List class
class LinkedList
{
    Node head;  // head of list
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
         Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    public void detectLoop(){
        
        if(head==null) return;
        if(head.next == null) return;
	    
	    Node slow_ptr = head;
	    Node fast_ptr = head;

	    while (fast_ptr!=null) {

	    	if(fast_ptr.next!=null){
		    		fast_ptr = fast_ptr.next.next;
		    		slow_ptr = slow_ptr.next;
		    	}	

	    	if(fast_ptr!=null){
	    		if(slow_ptr.data==fast_ptr.data){
			    	System.out.println("there is  LOOP");
			    	break;
			    }
	    	}
	    	else{
	    		System.out.println("there is No LOOP");
	    		break;
	    	}
	    }

	   
    }


    public void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
         System.out.print("\n");
    }
 
    /* Drier program to test above functions. Ideally
       this function should be in a separate user class.
       It is kept here to keep code compact */
    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList llist = new LinkedList();

  		llist.push(10);
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3); 
        llist.push(2);
		llist.push(1);

		llist.head.next.next.next.next.next.next.next.next.next.next = llist.head.next.next.next;
		
        llist.detectLoop();
    }
}