package com.striversde.linkedlistandarrays;

import java.util.HashMap;

class CacheNode {
	int key;
	int value ;
	CacheNode prev;
	CacheNode next;
	CacheNode(){
		this.key = Integer.MIN_VALUE;
		this.value = Integer.MIN_VALUE;
		this.prev = null;
		this.next = null;
	}
	CacheNode(int key, int value){
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}

class CacheLinkedList{
	public CacheNode head = new CacheNode();
	public CacheNode tail = new CacheNode();

	CacheLinkedList(){
		head.next=tail;
		head.prev=null;
		tail.prev=head;
		tail.next=null;
	}
	CacheNode insertAfterHead(int key, int value){
		CacheNode newNode = new CacheNode(key,value);
		CacheNode tempNode = head.next;
		head.next=newNode;
		newNode.prev=head;
		newNode.next=tempNode;
		tempNode.prev=newNode;
		return newNode;
	}

	public void deleteNode(CacheNode node){
		CacheNode previousNode = node.prev;
		CacheNode nextNode = node.next;
		previousNode.next = nextNode;
		nextNode.prev=previousNode;	
	}

	CacheNode deleteLRU(){
		CacheNode node = tail.prev;
		CacheNode previousNode = node.prev;
		previousNode.next=tail;
		tail.prev=previousNode;
		return node;
	}


	void print(){
		CacheNode temp = head;
		while(temp!=null){
			System.out.print("("+temp.key+","+temp.value+")");
			if(temp.next!=null)
				System.out.print(" -> ");
			temp=temp.next;
		}
		System.out.println();
	}
}
class LRUCache {

	int capacity;
	HashMap<Integer, CacheNode> cache = new HashMap<>();
	CacheLinkedList cacheList = new CacheLinkedList();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(cache.containsKey(key) ){
			// key found
			CacheNode node = cache.get(key);
			int value = node.value;
			cacheList.deleteNode(node);
			cache.remove(key);
			CacheNode newNode = cacheList.insertAfterHead(key,value);
			cache.put(key,newNode);
			return newNode.value;
		}else{
			return -1;
		} 
	}

	public void put(int key, int value){
		if(cache.containsKey(key)){
			// key found
			CacheNode node = cache.get(key);
			cacheList.deleteNode(node);
			CacheNode newNode = cacheList.insertAfterHead(key,value);

			cache.remove(key);
			cache.put(key,newNode);
		}else{
			if(capacity<=cache.size()){
				CacheNode deletedNode = cacheList.deleteLRU();
				cache.remove(deletedNode.key);
				CacheNode newNode = cacheList.insertAfterHead(key,value);
				cache.put(key,newNode);

			}else{
				CacheNode newNode = cacheList.insertAfterHead(key,value);
				cache.put(key,newNode);
			}
		} 
	}
}