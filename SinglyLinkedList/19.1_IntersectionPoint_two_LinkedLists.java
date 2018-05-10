import java.util.HashMap;

class Node{
    Integer data;
    Node next;
    Node(Integer d){ 
        data = d;  
        next = null; 
    }
}
 
// Linked List class
class LinkedList{
    Node head1;  // head of list
    Node head2;

    void  getIntersectionPoint(){

       HashMap<Integer,Integer> list1_hm = new HashMap<Integer,Integer>();

       HashMap<Integer,Integer> list2_hm = new HashMap<Integer,Integer>();


        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1!=null && temp2!=null) {

            if(temp1.data==temp2.data){
                System.out.println("There is intersection between both the lists");
                return ;
            }

            if(list1_hm.containsKey(temp2.data)){
                System.out.println("There is intersection between both the lists");
                return;
            }

            else{
                list1_hm.put(temp1.data,1);
            }

            
            if(list2_hm.containsKey(temp1.data)){
                System.out.println("There is intersection between both the lists");
                return;
            }

            else{
                list2_hm.put(temp2.data,1);
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
       }
    
        System.out.println("There is No intersection between both the lists");
      

    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list = new LinkedList();

        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(15);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);


        list.getIntersectionPoint();

    }
}