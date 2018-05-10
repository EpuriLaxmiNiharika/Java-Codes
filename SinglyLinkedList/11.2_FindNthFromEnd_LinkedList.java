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

    public void getNthNode_from_end(int n){
     	if(n>size){
            System.out.println("n exceeds size of LinkedList");
            return ;
        }
        else{
            if(size==0){
                System.out.println("Empty LinkedList");
                return ;
            }
            else{
                int count = 1; Node ahead_ptr = head ; Node behind_ptr = head;
                while(count<=n){
                    ahead_ptr = ahead_ptr.next;
                    count++;
                }
                if(ahead_ptr == null){
                    System.out.println("Nth element from end "+head.data);
                }

                else if(ahead_ptr.next==null){
                    System.out.println("Nth element from end"+ behind_ptr.data);
                }
                else{
                    while(ahead_ptr!=null){
                        behind_ptr = behind_ptr.next;
                        ahead_ptr = ahead_ptr.next;
                    }

                    System.out.println("Nth element from end"+ behind_ptr.data);
                }
            }
        }
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
        llist.push(6);
        llist.getNthNode_from_end(1);
    }
}