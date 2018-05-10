
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

    public static void findIntersectionList(LinkedList list1, LinkedList list2){
        
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        LinkedList new_list = new LinkedList();

        while(temp1!=null && temp2!=null){

            if(temp1.data==temp2.data){
                new_list.push(temp2.data);
                temp2 = temp2.next;
                temp1 = temp1.next;
            }

            else if(temp1.data<temp2.data){
                temp1 = temp1.next;
            }

            else{
                temp2 = temp2.next;
            }   
        }
       
       printList(new_list.head);
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

        LinkedList llist2 = new LinkedList();
        llist2.push(7);
        llist2.push(5);
        llist2.push(3);
        llist2.push(0);

        findIntersectionList(llist1,llist2);
    }
}