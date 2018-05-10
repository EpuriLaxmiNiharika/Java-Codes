import java.util.HashMap;

class Node
{
    int data;
    Node next;
    boolean visited;
    Node(int d)  { 
        data = d;  
        next = null;
        visited = false;
    }
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
     
	   Node temp = head;
       while(temp!=null && !temp.visited){
        temp.visited = true;
        temp = temp.next;

       }

       if(temp.visited){
            System.out.print("LOOP FOUND\n");
            return;
       }
        
        System.out.print("LOOP NOT FOUND\n");

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