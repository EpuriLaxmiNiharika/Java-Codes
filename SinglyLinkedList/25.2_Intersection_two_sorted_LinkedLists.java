
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

    public static Node findIntersectionList(Node head1, Node head2){
               //     System.out.println("HEAD: "+head1.data);

        if(head1==null || head2==null){
            return null;
        }

        if(head1.data==head2.data){
              Node new_node = new Node(head1.data);
              new_node.next = findIntersectionList(head1.next, head2.next);
           //   System.out.println("hey: "+head1.data);
              return new_node;
        }

        else if(head1.data<head2.data){
      //      System.out.println("HEAD1: "+head1.data);
            return findIntersectionList(head1.next,head2);
        }

        else{
//             System.out.println("HEAD: "+head1.data);

            return findIntersectionList(head1,head2.next);
        }   
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

        Node temp = findIntersectionList(llist1.head,llist2.head);
        printList(temp);
    }
}