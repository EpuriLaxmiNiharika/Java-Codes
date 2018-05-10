
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
    static LinkedList new_lst = new LinkedList();

 
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

    public static Node deleteAlternateNodes(LinkedList list1){
        
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
         System.out.print("\n");
    }
 
   
    public static void main(String[] args){
        LinkedList llist1 = new LinkedList();
        llist1.push(6);
        llist1.push(5);
        llist1.push(4);
        llist1.push(3);        
        llist1.push(2);
        llist1.push(0);

        Node temp = deleteAlternateNodes(llist1);
        printList(temp);
    }
}