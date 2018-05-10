
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


    public void reverseList(){
        reverse(head);
    }
 

    public void reverse(Node node){

        if(node==null){
            return ;
        }

        reverse(node.next);
        System.out.print(node.data+" ");
    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list1 = new LinkedList();

        list1.push(55);
        list1.push(25);
        list1.push(15);

        list1.reverseList();
     //   list1.printList(list1.head);

    }
}