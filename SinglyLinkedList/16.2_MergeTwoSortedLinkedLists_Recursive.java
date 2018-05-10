
class Node{
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 
// Linked List class
class LinkedList{
    Node head;  // head of list
    int size;
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
         Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
        size++;
    }

    
    public void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
         System.out.print("\n");
    }
 
 }
   
  
class MergeLinkedLists{ // merge Two sorted Linked lists


    static Node merge(Node head1, Node head2){

        if(head1 == null)
            return head2;


        if(head2 == null) return head1;


        if(head1.data<head2.data){ // we are modifying head1. So, we are returning head1
            head1.next = merge(head1.next,head2);
            return head1;
        }

        else{
            head2.next = merge(head1,head2.next);
            return head2;
        }

    }

    static void mergeLists(LinkedList l1, LinkedList l2){

        merge(l1.head,l2.head);
    }

    static public void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
         System.out.print("\n");
    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list2.push(30);
        list2.push(20);
        list2.push(10);

        list1.push(55);
        list1.push(25);
        list1.push(15);

        mergeLists(list1,list2);
        printList(list1.head);

    }
}