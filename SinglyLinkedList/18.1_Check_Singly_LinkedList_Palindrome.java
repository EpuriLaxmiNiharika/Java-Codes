
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


    boolean checkPalindrome(String s){

        for(int i = 0; i < s.length()/2; i++){
            String s1 = s.charAt(i) + "";
            String s2 = s.charAt(s.length() - 1 - i) + "";
            if(!s1.equals(s2)){
                return false;
            }
        }
        return true;

    }

    void checkPalindrome_List(){

        Node temp = head;
        String str = "";
        
        while (temp!=null) {
            str = str + temp.data;
            temp = temp.next;
        }

        boolean is_palindrome = checkPalindrome(str);

        if(is_palindrome){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
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