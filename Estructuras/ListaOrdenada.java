public class ListaOrdenada {
    public static void main(String[] args) {
        Integer [] arr = new Integer[5];
        OrderList<Integer> orderList = new OrderList<Integer>(arr);
        orderList.eliminar(4);
        orderList.insertar(4);
        orderList.insertar(3);
        orderList.insertar(30);
        orderList.insertar(15);



        orderList.show();
    }
}

class OrderList<T extends Comparable<T>> {
    public int size=0;
    public int N;
    public static int pos=0;
    public T[] arr;
    
    public OrderList(T[] ar){
        arr=ar;
        N=arr.length;
    }

    public void insertar(T x){
        if(!isFull()){
            int pos = 0;
            while(pos < size && arr[pos].compareTo(x) < 0) {
                pos++;
            }
            if(pos < size && arr[pos].compareTo(x) == 0) {
                System.out.println("El elemento ya existe");
            } else {
                for(int j = size; j > pos; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[pos] = x;
                size++;
                System.out.println("Se añadió el elemento");
            }
        } else {
            System.out.println("La lista está llena");
        }
    }
    

    public void eliminar(T x){
        if (!isEmpty()) {
            int pos = buscar(x);
            if (pos != -1) {
                for (int j = pos; j < size - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[size - 1] = null; 
                size--;
            } else {
                System.out.println("No se encontró el elemento");
            }
        } else {
            System.out.println("La lista está vacía");
        }
    }
    
    

        public int buscar(T item){
            pos = 0;
            while(pos < size && arr[pos].compareTo(item) < 0) {
                pos++;
            }
            if (pos < size && arr[pos].compareTo(item) == 0) {
                return pos;
            } else {
                return -1;
            }
        }

    public boolean isEmpty(){
        return size <= 0;
    }

    public boolean isFull(){
        return size >= N;
    }

    public void show(){
        String lis="";
        for(int i=0; i<N; i++){
            lis=lis+arr[i]+" ";
        }
        System.out.println(lis);
    }
}
