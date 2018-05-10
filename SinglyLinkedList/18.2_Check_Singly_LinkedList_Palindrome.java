/*
A simple solution is to use a stack of list nodes. This mainly involves three steps.
1) Traverse the given list from head to tail and push every visited node to stack.
2) Traverse the list again. For every visited node, pop a node from stack and compare data of popped node with currently visited node.
3) If all nodes matched, then return true, else false.

Time complexity of above method is O(n), but it requires O(n) extra space. Following methods solve this with constant extra space.

*/


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
 
    /* Inserts a new Node at front of the list. */
    public void push(String new_data)
    {
         Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

    
    public void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(" "+temp.data);
            temp = temp.next;
        }
         System.out.print("\n");
    }


    void checkPalindrome_List(){
        Stack <String> stack = new Stack<String>();

        Node temp = head;

        while(temp!=null){
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while(temp!=null){

            String data =stack.pop();

            if(!temp.data.equals(data)){
                System.out.println("Not palindrome");
                break;
            }
            temp = temp.next;
        } 

        if(temp==null){
             System.out.println("palindrome");
        } 
    }

    public static void main(String[] args){
        /* Start with the empty list */
        LinkedList list1 = new LinkedList();

        list1.push("R");
        list1.push("A");
        list1.push("D");
        list1.push("A");
        list1.push("R");
        list1.checkPalindrome_List();

    }
}