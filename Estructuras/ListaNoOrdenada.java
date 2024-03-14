public class ListaNoOrdenada{
    public static void main(String[] args) {
        Integer [] arr = new Integer[5];
        UnorderList<Integer> unorderList = new UnorderList<Integer>(arr);
        unorderList.eliminar(4);
        unorderList.insertar(4);
        unorderList.insertar(3);
        unorderList.insertar(30);
        unorderList.insertar(15);
        unorderList.eliminar(4);
        




        unorderList.show();
    
    }
}
class UnorderList<T extends Comparable <T>>{
    public int size=0;
    public int N;
    public static int pos=0;
    public T[] arr;
    
    public UnorderList(T[] ar){
        arr=ar;
        N=arr.length;
    }

    public void insertar (T x){
        if(!isFull()){
            arr[size]=x;
            size++;

        }
    }
    public void eliminar(T x){
        if(!isEmpty()){
            int pos = buscar(x);
            if (pos != -1){
                arr[pos]=arr[size-1];
                arr[size-1]=null;
                System.out.println("Se elimino correctamente");

            }else{
                System.out.println("No se encontro elelemento a eliminar");
            }
        }else{
            System.out.println("La lista esta vacia");
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
        return size<=0;

    }
    public boolean isFull(){
        return size>=N;
    }
    public void show(){
        String lis="";
        for(int i=0; i<N; i++){
            lis=lis+arr[i]+" ";
        }
        System.out.println(lis);
    }

}