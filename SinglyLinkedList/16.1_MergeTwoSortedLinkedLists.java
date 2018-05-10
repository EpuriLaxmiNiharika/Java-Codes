
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


    static void merge(LinkedList list1 , LinkedList list2){

        Node head1 = list1.head;
        Node head2 = list2.head;

        
        if(head1 == null)
            return ;


        if(head2 == null) return ;


        Node temp1 = head1;
        Node temp2 = head2;

        
        if(head1.data < head2.data){ // Merge into list1

            while(temp2!=null){

                if(temp1!=null){
                    while(temp1.next!=null){
                        if(temp1.next.data<temp2.data){
                            temp1 = temp1.next;
                        }
                        else{
                            break;
                        }
                    }


                    if(temp1.next==null){

                        temp1.next = temp2;

                        break;
                    }

                    else{
                        Node new_node = new Node(temp2.data);
                        Node temp_next = temp1.next;
                        temp1.next = new_node;
                        new_node.next = temp_next;
                    }

                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
                
            }
            
            list1.printList(list1.head); 
        }

        else{ // merge into linkedlist2

            while(temp1!=null){   

                if(temp2!=null){
                    while(temp2.next!=null){
                        if(temp2.next.data < temp1.data){
                            temp2 = temp2.next;
                        }
                        else{
                            break;
                        }
                    }

                    if(temp2.next==null){
                        temp2.next= temp1;
                        break;
                    }

                    else{
                        Node temp2_next = temp2.next;
                        Node new_node = new Node(temp1.data);
                        temp2.next = new_node;
                        new_node.next = temp2_next;
                    }
                    
                    temp1 = temp1.next;
                    temp2 = temp2.next;
                }
            }
             list2.printList(list2.head); 
        }        
    }

    static void mergeLists(LinkedList l1, LinkedList l2){

        merge(l1,l2);
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
    }
}