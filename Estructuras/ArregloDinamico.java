import java.lang.reflect.Array;

public class ArregloDinamico {
    public static void main(String[] args) {
        Integer arr[]= new Integer[5];
        DynamicArray<Integer> dynamicArray= new DynamicArray<Integer>(arr);
        dynamicArray.pushBack(1);
        dynamicArray.pushBack(2);
        dynamicArray.pushBack(2);
        dynamicArray.pushBack(2);
        dynamicArray.pushBack(2);
        dynamicArray.pushBack(2);

        System.out.println(dynamicArray.capacity);
        System.out.println(dynamicArray.size);


        
    }
}

class DynamicArray<T>{
    T[] arr;
    int capacity;
    int size=0;

    public DynamicArray(T[] ar){
        arr=ar;
        capacity=arr.length;

    }

    public void set(int i,T item){
        if (i<0 || i>=size){
            System.out.println("indice fuera del rango");
        }else{
            arr[i]=item;
        }
    }
    
    public T get(int i){
        if (i<0 || i>=size){
            System.out.println("Indice fuera del rango");
            throw new RuntimeException("Indice fuera del arreglo");
        }else{
            return arr[i];
        }
    }

    public void remove(int i){
        if (i<0 || i>=size){
            System.out.println("Indice fuera del rango");
            throw new RuntimeException("Indice fuera del arreglo");
        }else{
            for (int j=i;j<size-1;j++){
                arr[j]=arr[j+1];
            } 
            size--; 
        }
    }

    public void pushBack(T item){
        if (size==capacity){
            T[] newArr= (T[]) Array.newInstance(arr.getClass().getComponentType(), capacity*2);
            for (int i=0; i<size-1;i++){
                newArr[i]=arr[i];
            }
            arr=newArr;
            capacity=capacity*2;
        }
        arr[size]=item;
        size++;
    }

    public int size(){
        return size;
    }

}
