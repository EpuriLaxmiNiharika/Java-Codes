/*
	we pre-process next larger and next smaller elements in O(n) time and O(n) space and 
	then check for each element if it has same next-small and great elements in O(n).


	THIS APPROACH WILL FAIL BECAUSE THE ORDER OF ELEMENTS IS NOT SAME IN BOTH THE ARRAYS.
*/

import java.util.*;
import java.util.Map.*;

class Node{

	int value;

	Node left;
	Node right;

	Node(int value){

		this.value = value;
	}
}


class BST{

	Node root;

	class Element{

		int ele;
		int next_smaller;
		int next_larger;

		Element(int ele){
			this.ele = ele;
		}
	}


	void isSameBST(int[] a, int[] b){

		HashMap<Integer,Element> elements1 = new HashMap<Integer,Element>();
		HashMap<Integer,Element> elements2 = new HashMap<Integer,Element>();

		nextGreaterElements(elements1,a);
		nextSmallerElements(elements1,a);

		nextGreaterElements(elements2,b);
		nextSmallerElements(elements2,b);

		for(Entry<Integer,Element> entry: elements1.entrySet()){
			int key = entry.getKey();
			Element val = entry.getValue();
			Element val2  = elements2.get(key);
			System.out.println(val.next_smaller+"---"+key+"---"+val.next_larger);
			System.out.println(val2.next_smaller+"---"+key+"---"+val2.next_larger);
			System.out.println("!!!!");
		}
	}
	
	void compareElements(HashMap<Integer,Element> hm1,HashMap<Integer,Element> hm2){

		 for(Entry<Integer,Element> entry: hm1.entrySet()){
		 	int key = entry.getKey();
		 	Element val1 = entry.getValue();
		 	Element val2  = hm2.get(key);
		 	
		 	if(val1.next_smaller!=val2.next_smaller){
		 		System.out.println("no");
		 		return;
		 	}

		 	if(val1.next_larger!=val2.next_larger){
		 		System.out.println("no");
		 		return;
		 	}
		 }
		 System.out.println("yes");
	}	



	void nextGreaterElements(HashMap<Integer,Element> hm, int[] arr){

		Stack<Integer> stack  = new Stack<Integer>();
		stack.push(arr[0]);

		for(int i =1;i<arr.length;i++){
			int next = arr[i];
			if(!stack.isEmpty()){
				int top = stack.pop();
				while (top<next) {
					Element ele = hm.get(top);
					if(ele==null){
						ele = new Element(top);
					}
					ele.next_larger = next;
					hm.put(top,ele);
					if(!stack.isEmpty()){
						top = stack.pop();
					}
					else{
						break;
					}
				}

				if(top>next){
					stack.push(top);
				}
			}
			stack.push(next);
		}

		while(!stack.isEmpty()){
			int top = stack.pop();
			Element ele = hm.get(top);
			if(ele==null){
				ele = new Element(top);
			}
			ele.next_larger = -1;
			hm.put(top,ele);
		}
	}

	void nextSmallerElements(HashMap<Integer,Element> hm, int[] arr){

		Stack<Integer> stack  = new Stack<Integer>();
		stack.push(arr[0]);

		for(int i =1;i<arr.length;i++){
			int next = arr[i];
			if(!stack.isEmpty()){
				int top = stack.pop();
				while (top>next) {
					Element ele = hm.get(top);
					if(ele==null){
						ele = new Element(top);
					}
					ele.next_smaller = next;
					hm.put(top,ele);
					if(!stack.isEmpty()){
						top = stack.pop();
					}
					else{
						break;
					}
				}

				if(top<next){
					stack.push(top);
				}
			}
			stack.push(next);
		}

		while(!stack.isEmpty()){
			int top = stack.pop();
			Element ele = hm.get(top);
			if(ele==null){
				ele = new Element(top);
			}
			ele.next_smaller = -1;
			hm.put(top,ele);
		}
	}


	public static void main(String[] args) {
		
		BST bst = new BST();

		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
  	 	int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};

   		bst.isSameBST(a,b);
	}
}