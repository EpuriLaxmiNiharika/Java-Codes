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
    int size;
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
        size ++;
    }

    public void reverseLinkedList(Node headNode, Node prev){
        
        if(headNode == null) {
            head = prev;
            return ;
        }
        
        Node temp_cur_next = headNode.next;        
        
        headNode.next = prev;
        
        reverseLinkedList(temp_cur_next,headNode);
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
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.push(6);
        llist.reverseLinkedList(llist.head,null);
        llist.printList(llist.head);
    }
}