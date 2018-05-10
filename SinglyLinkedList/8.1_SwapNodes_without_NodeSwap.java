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
    }

    public void swap(int value1, int value2){
       if(value2==value1) return;

        Node prevX,prevY;
        Node tempX,tempY;

        tempX = head;
        tempY = head;

        prevX = null ; prevY = null;


        if(value1==value2) return;

        while (tempX!=null) {

            if(tempX.data == value1) break;
            prevX = tempX;
            tempX = tempX.next;
        }


        while (tempY!=null) {

            if(tempY.data == value2) break;
            prevY = tempY;
            tempY = tempY.next;
        }

        if (tempY==null || tempX==null) {
            return;
        }


        if(prevX==null){ // value1 is at head of linkedlist
            Node head_next = head.next;

            tempX.next = tempY.next;
            prevY.next = tempX;

            head = tempY;
            tempY.next = head_next;        
        }

        else if(prevY==null){// value2 is at head of linkedlist
            Node head_next = head.next;
            tempY.next = tempX.next;
            prevX.next = tempY;
            head = tempX;
            tempX.next = head_next;

        }

        else if(tempY.next==tempX){ // when value2 and value1 are adjacent

            Node temp_x_next_backup = tempX.next;
            prevY.next = tempX;
            tempX.next = tempY;
            tempY.next = temp_x_next_backup;
        }

        else if(tempX.next==tempY){ // when value1 and value2 are adjacent

            Node temp_y_next_backup = tempY.next;
            prevX.next = tempY;
            tempY.next = tempX;
            tempX.next = temp_y_next_backup;
        }

        else{

            Node temp_y_next_backup = tempY.next;

            prevX.next = tempY;
            tempY.next = tempX.next;

            prevY.next = tempX;
            tempX.next = temp_y_next_backup;
        }

        printList(head);
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
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);
        llist.swap(2,4);
    }
}