
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


    static Node mergeLists(LinkedList list1, LinkedList list2){

        if(list1.head == null){
            if(list2.head == null){
                return null;
            }
            return list2.head;
        }

        else if(list2.head==null){
            if(list1.head == null){
                return null;
            }
            return list1.head;
        }

        else{
            LinkedList new_lst = new LinkedList();
            Node temp = new_lst.head;
            Node temp_1 = list1.head;
            Node temp_2 = list2.head;

            if(temp_1.data<temp_2.data){

                new_lst.head  =  new Node(temp_1.data);
                temp_1 = temp_1.next;
            }
            else{
                new_lst.head =  new Node(temp_1.data);
                temp_2 = temp_2.next;
            }

            temp = new_lst.head;
            while(temp_1!=null || temp_2!=null){
             // System.out.println("hello!!");
                if(temp_1==null){
                    temp.next = temp_2;
                    printList(new_lst.head);
                    break;
                }
                else if(temp_2==null){
                    temp.next = temp_1;
                    printList(new_lst.head);
                    break;
                }
                else{
                    if(temp_1.data<temp_2.data){
                        temp.next = new Node(temp_1.data);
                        temp_1 = temp_1.next;
                    }

                    else{
                        temp.next = new Node(temp_2.data);
                        temp_2 = temp_2.next;
                    }
                }
                temp = temp.next;
            }


            return temp;

        }
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

        list1.push(55); // 15 25 55 
        list1.push(25); 
        list1.push(15);


        list2.push(30); // 10 20 30
        list2.push(20);
        list2.push(10);


        mergeLists(list1,list2);

    }
}