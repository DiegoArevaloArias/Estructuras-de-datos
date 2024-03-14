public class StackGeneric {
    public static void main(String[] args) {
        Integer ar[]= new Integer[5];
        Stack<Integer> stack = new Stack<Integer>(ar);
        System.out.println(stack.isFull());
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(4);
        
        System.out.println(stack.isFull());
        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        stack.push(78);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
 
    }


    
}

class Stack <T> {
    public   T [] arr;
    public static  int top=0;
    Stack  (T[] ar ){
        arr=ar;
    }

    public void push(T x){
        if (isFull()){
            System.out.println("La pila esta llena");

        }else{
            top+=1;
            arr[top-1]=x;
            

        }

    }
    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("La pila esta vacia");            
        }else{
            top-=1;
            return arr[top];
        }
        
    }

    public boolean isEmpty(){
        return top==0;

    }
    public boolean isFull(){
        return top==arr.length;

    }

}
