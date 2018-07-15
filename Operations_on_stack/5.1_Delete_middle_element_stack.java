import java.util.*;

class DeleteMiddle{

	static void deleteMiddle(Stack<Integer> stack, int count, int size){

		if(stack.isEmpty()){
			return;
		}

		int popped = stack.pop();
		deleteMiddle(stack,count+1,size);
		if(count!=size/2){
			stack.push(popped);
		}
	}

	public static void main(String[] args) {
		
		Stack<Integer> st =
                  new Stack<Integer>();
     
        st.push( 1 );
        st.push( 2 );
        st.push( 3 );
        st.push( 4 );
        st.push( 5 );
        st.push( 6 );
        st.push( 7 );

        System.out.println();

		for(Integer e:st){
			System.out.print(e+" ");
		}

        deleteMiddle(st,0,st.size());

        System.out.println();

		for(Integer e:st){
			System.out.print(e+" ");
		}
	}
}