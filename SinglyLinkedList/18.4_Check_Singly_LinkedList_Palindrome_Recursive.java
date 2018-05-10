
import java.util.Stack;

class Node{
    String data;
    Node next;
    Node(String d){ 
        data = d;  
        next = null; 
    }
}
 
// Linked List class
class LinkedList{
    Node head;  // head of list
 	int size;
    Node left;


    /* Inserts a new Node at front of the list. */
    public void push(String new_data)
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


    void checkPalindrome_List(){ // wrapper class
        if(checkPalindrome(head)){
            System.out.println("palindrome");
        }
        else{
            System.out.println("NOT palindrome");
        }
    }

    boolean checkPalindrome(Node rightNode){

        left = head;

        if(rightNode==null){
            return true;
        }

        boolean res = checkPalindrome(rightNode.next);

        if(!res){
            return false;
        }

        boolean res1 = (left.data == rightNode.data);
        
        left = left.next;

       // return res1 && res; 
      
        return res1;
    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list1 = new LinkedList();

        list1.push("R");
        list1.push("A");
        list1.push("P");
        list1.push("P");
        list1.push("R"); // R M D P R
        list1.checkPalindrome_List();

    }
}