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

    public void reverseLinkedList(LinkedList list1, LinkedList list2){
        
        Node temp1 = list1.head;
      
        temp1 = temp1.next;

        Node temp2 = list2.head;
        while(temp1 != null || temp2 != null){
         //      System.out.println("temp2 :"+temp2.data+" temp1: "+temp1.data);

            printList(list1.head);
            if(temp1.next==null){
                temp1.next = temp2;
                break;
            }

            if(temp2 ==null){
                break;
            }
            if(temp2.data < temp1.data){
            //     System.out.println("temp2 :"+temp2.data+" temp1: "+temp1.data);

                temp1.next = new Node(temp2.data);
                temp2 = temp2.next;
            }
            else{
                temp1 = temp1.next;
            }
        }

        printList(list1.head);
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
        llist.push(12);
        llist.push(9);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

          LinkedList llist1 = new LinkedList();
        llist1.push(18);
        llist1.push(17);
        llist1.push(14);
        llist1.push(6);
        llist1.push(5);
        llist1.push(2);

//                System.out.println("temp2 :"+llist1.head.data);

        llist.reverseLinkedList(llist,llist1);
    }
}