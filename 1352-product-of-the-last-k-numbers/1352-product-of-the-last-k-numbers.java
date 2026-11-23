class ProductOfNumbers {
    class Node {
        Node next;
        Node prev;
        int val;

        public Node(int val){
            this.val = val;
        }
    }

    List<Node> list;
    Node head;
    Node tail;

    public ProductOfNumbers() {
        list = new LinkedList<>();
        head = null;
    }

    public void add(int num) {
        Node node = new Node(num);
        if(head == null){
            head = node;
            tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    public int getProduct(int k) {
        int product = 1;
        Node temp = tail;
        for(int i = 0; i<k; i++){
            if(temp == null) break;
            product *= temp.val;
            temp = temp.prev;
        }

        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */