package com.company;

class Node {
    String key;
    int value;
    Node next;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList(){
        head = null;
    }

    public void push_front(Node newNode){
        if(head == null){
            head = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.next = temp;
        }
    }

    public int get(String key){
        Node cur = head;
        while(cur != null){
            if(cur.key.equals(key)){
                return cur.value;
            }
            cur = cur.next;
        }
        return -1;
    }
}

class HashTable{

    LinkedList[] a;
    int size;

    HashTable(int size){
        this.size = size;
        a = new LinkedList[size];
        for(int i = 0; i < size; i++){
            a[i] = new LinkedList();
        }
    }

    public int get_hash(String data){
        int hash = 0;
        for(int i = 0; i < data.length(); i++){
            hash += data.charAt(i);
        }
        return hash % size;
    }

    public void insert(String key, int value){
        a[get_hash(key)].push_front(new Node(key, value));
    }

    public int get(String key){
        return a[get_hash(key)].get(key);
    }

}

