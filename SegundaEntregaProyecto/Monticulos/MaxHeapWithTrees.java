package SegundaEntregaProyecto.Monticulos;

public class MaxHeapWithTrees {

    private Node root, lastNode;

    class Node{

        public int data, height;
        public Node left, right, parent;

    }

    public MaxHeapWithTrees(){
        root = null;
        lastNode = root;
    }

    public int getMax() throws Exception{
        if(root == null)
            throw new Exception("The heap is empty");
            return root.data;
    }

    public int extractMax() throws Exception{

        if(root == null)
            throw new Exception("There are no elements in the heap");

        if(lastNode == root){

            int dataMax = root.data;
            root = null;
            lastNode = null;
            return dataMax;

        }

        int dataMax = root.data;
        root.data = lastNode.data;
        
        Node parent = lastNode.parent;

        lastNode = getPenultimateNode();

        if(parent.right == null){
            parent.left.parent = null;
            parent.left = null;
        } else {
            parent.right.parent = null;
            parent.right = null;
        }
        
        siftDown(root);

        while(parent != null){

            updateHight(parent);
            parent = parent.parent;

        }

        return dataMax;

    }

    private void updateHight(Node node){

        if(node.left == null && node.right == null)
            node.height = 1;
        else if(node.left == null)
            node.height =  1 + node.right.height;
        else if(node.right == null)
            node.height = 1 + node.left.height;
        else
            node.height = 1 + Math.max(node.left.height, node.right.height);

    }

    private void siftUp(Node node){

        if(node.parent != null){

            int dataNode = node.data;
            int dataParentNode = node.parent.data;

            if(dataNode > dataParentNode){

                node.parent.data = dataNode;
                node.data = dataParentNode;
                siftUp(node.parent);

            }

        }

    }

    private void siftDown(Node node){

        if(node.left != null && node.right != null){

            int dataNode = node.data;
            int dataLeftNode = node.left.data;
            int dataRightNode = node.right.data;

            if(dataLeftNode > dataRightNode){

                if(dataNode < dataLeftNode){

                    node.left.data = dataNode;
                    node.data = dataLeftNode;
                    siftDown(node.left);

                }

            } else {

                if(dataNode < dataRightNode){

                    node.right.data = dataNode;
                    node.data = dataRightNode;
                    siftDown(node.right);

                }

            }

        } else if(node.left != null){

            int dataNode = node.data;
            int dataLeftNode = node.left.data;

            if(dataNode < dataLeftNode){

                node.left.data = dataNode;
                node.data = dataLeftNode;
                siftDown(node.left);

            }

        } else if(node.right != null){

            int dataNode = node.data;
            int dataRightNode = node.right.data;

            if(dataNode < dataRightNode){

                node.right.data = dataNode;
                node.data = dataRightNode;
                siftDown(node.right);

            }

        }

    }

    private Node createNext(){

        if(lastNode == null)

            return root = new Node();

        else if(lastNode.parent == null){

            Node newNode = new Node();
            lastNode.left = newNode;
            newNode.parent = lastNode;
            return newNode;

        }else if(lastNode.parent.right == null){

            Node newNode = new Node();
            lastNode.parent.right = newNode;
            newNode.parent = lastNode.parent;
            return newNode;

        }else{

            Node n = lastNode.parent;

            while(n.left.height == n.right.height && n != root){

                n = n.parent;
            
            }

            if(n == root && n.left.height == n.right.height){

                while(n.left != null)
                    n = n.left;
                
                Node newNode = new Node();
                n.left = newNode;
                newNode.parent = n;

                return newNode;

            } else {

                n = n.right;

                while(n.left != null)
                    n = n.left;
                
                Node newNode = new Node();
                n.left = newNode;
                newNode.parent = n;

                return newNode;

            }

        }

    }

    public Node insert(int key){

        lastNode = createNext();

        lastNode.data = key;

        siftUp(lastNode);

        Node n = lastNode;

        while(n != null){

            updateHight(n);

            n = n.parent;

        }

        return lastNode;

    }

    public Node getPenultimateNode(){

        if(lastNode == null)
            return null;
        else if(lastNode.parent == null)
            return lastNode;
        else if(lastNode.parent.right != null)
            return lastNode.parent.left;
        else {

            Node n = lastNode.parent;
            
            while(n != root && (n.right == null || n.left.height != n.right.height))
                n = n.parent;
            
            if(n == root && (n.right == null || n.left.height != n.right.height)){

                while(n.right != null)
                    n = n.right;
                
                return n;

            } else {

                n = n.left;

                while(n.right != null)
                    n = n.right;

                return n;

            }

        }

    }

    public void remove(Node node) throws Exception{
       
        if(!inHeap(node))
            throw new Exception("the node is not in the heap");

        node.data = getMax() + 1;

        siftUp(node);
        
        extractMax();

        node = null;

    }

    private boolean inHeap(Node node){

        Node n = node;

        while(n.parent != null)
            n = n.parent;

        return n == root;

    }

    public void changePriority(Node node, int priority) throws Exception{

        if(!inHeap(node))
            throw new Exception("The node is not in the heap");

        node.data = priority;

        if(node.parent != null && node.data > node.parent.data)
            siftUp(node);
        else
            siftDown(node);

    }

    private String HeapByLevelToString(Node node){


        if(node != null)
            return "nodo: " + node.data + " hijos: (" + HeapByLevelToString(node.left) + " / " + HeapByLevelToString(node.right) + ")";
        else
            return "nulo";

    }

    public void printHeapByLevel(){

        System.out.println(HeapByLevelToString(root));

    }

}