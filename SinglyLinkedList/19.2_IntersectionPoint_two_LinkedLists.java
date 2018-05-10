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

        Node temp1 = head1;
        Node temp2 = head2;

        if(temp1==null){
            System.out.println(" Linkedlist1 is empty");
            return; 
        }

        if(temp2==null){
            System.out.println(" Linkedlist2 is empty");
            return; 
        }


        if(temp2==temp1){
            System.out.println("There is intersection between two linkedlists");
            return;
        }


        int size1 = 0;
        int size2 = 0;

        while (temp1!=null || temp2!=null) {
        
            if(temp1!=null){
                size1++;
                temp1 = temp1.next;
            }
            if(temp2!=null){
                size2++;
                temp2 = temp2.next;
            }
        }


        temp1 = head1;
        temp2 = head2;

        int diff = size1 - size2;

        if(size2>size1){
            diff = size2 - size1;
            int count = 1;
            while(count<=diff){
                temp2 = temp2.next;
                count++;
            }
        }

        else{
            int count = 1;
            while(count<=diff){
                temp1 = temp1.next;
                count++;
            }
        }


        while(temp1!=null){

            if(temp1.data == temp2.data){
                System.out.println("Intersection there");
                return;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;

        }

        System.out.println("Intersection Not there");
    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list = new LinkedList();

        list.head1 = new Node(3);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(15);
        list.head1.next.next.next.next = new Node(30);
 
        // creating second linked list
        list.head2 = new Node(10);
        list.head2.next = new Node(15);
        list.head2.next.next = new Node(30);


        list.getIntersectionPoint();

    }
}