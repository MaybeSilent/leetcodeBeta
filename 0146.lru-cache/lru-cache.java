class LRUCache {
    
    private HashMap<Integer,Integer> keyMap = new HashMap<Integer,Integer>(1024*1024);
    private HashMap<Integer,Node> nodeMap;

    private NodeList nodeList = new NodeList();
    
    private int capacity;
    private int realSize;
    
    public LRUCache(int capacity) {
        nodeMap = new HashMap((int)(capacity/0.75F + 1.0F));
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        Node freshNode = nodeMap.get(key);
        if(freshNode != null){
            nodeList.moveToFirst(freshNode);
        }
    
        /*
        Node loop = nodeList.firstNode;
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<");
        while(loop != null){
            System.out.println(loop.key + " " + loop.val);
            loop = loop.next;
        }
        */
        
        
        if(keyMap.containsKey(key)) return keyMap.get(key);
        else return -1;
        
    }
    
    public void put(int key, int value) {
        
        
        if(keyMap.containsKey(key)){
            keyMap.put(key,value);
            Node node = nodeMap.get(key);
            node.val = value;
            nodeList.moveToFirst(node);
            return ;
        }
        
        Node node = new Node(key,value);
        if(realSize < capacity){
            keyMap.put(key,value);
            nodeMap.put(key,node);
            nodeList.add(node);
            realSize ++;
        } else {
            Node lastNode = nodeList.lastNode;
            keyMap.remove((Integer)lastNode.key);
            nodeMap.remove((Integer)lastNode.key);
            keyMap.put(key,value);
            nodeList.delete();
            nodeMap.put(key,node);
            nodeList.add(node);
        }
        
        /*
        Node loop = nodeList.firstNode;
       
        System.out.println(">>>>>>>>>>>>>>>>>>>>");
        while(loop != null){
            System.out.println(loop.key + " " + loop.val);
            loop = loop.next;
        }
        */
    }
}

class NodeList{
    Node firstNode;
    Node lastNode;
    
    public void add(Node node){
        if(lastNode == null){
            firstNode = lastNode = node;
        } else {
            node.next = firstNode;
            firstNode.prev = node;
            firstNode = node;
        }
    }
    
    public void moveToFirst(Node node){
        if(node.prev == null) return ;
        if(node.next == null){
            lastNode = lastNode.prev;
            lastNode.next = null;
        }
        if(node.next != null){
            node.prev.next = node.next;
            node.next.prev = node.prev;
        } 
        node.prev = null;
        node.next = firstNode;
        firstNode.prev = node;
        firstNode = node;

    }
    
    public void delete(){
        lastNode = lastNode.prev;
        if(lastNode != null) lastNode.next = null;
    }
}

class Node{
    Node prev;
    Node next;
    int val;
    int key;
    Node(int key,int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */