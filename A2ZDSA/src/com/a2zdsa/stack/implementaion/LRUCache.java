package com.a2zdsa.stack.implementaion;

import java.util.HashMap;


public class LRUCache {
	static class CacheNode{

		int key;
		int data;
		CacheNode next;
		CacheNode prev;
		CacheNode(){
			this.key = Integer.MIN_VALUE;
			this.data = Integer.MIN_VALUE;
			this.next = null;
			this.prev=null;
		}
		CacheNode(int key, int data){
			this.key = key;
			this.data = data;
			this.next = null;
			this.prev=null;
		}

	}
	static class CacheDoublyLinkedList{
		private CacheNode cacheHead;
		private CacheNode cacheTail;
		private int size;
		CacheDoublyLinkedList(){
			size = 0;
			cacheHead = new CacheNode();
			cacheTail = new CacheNode();
			cacheHead.next = cacheTail;
			cacheTail.prev = cacheHead;
		}

		public int size() {
			return size;
		}

		public CacheNode getCacheHead() {
			return cacheHead;
		}
		public CacheNode getCacheTail() {
			return cacheTail;
		}

		public void insertAtStart(CacheNode cacheNode) {
			CacheNode nextNode = cacheHead.next;

			cacheNode.next = nextNode;
			cacheHead.next = cacheNode;
			nextNode.prev = cacheNode;
			cacheNode.prev = cacheHead;
			size++;

		}

		public void insertLast(CacheNode cacheNode) {
			CacheNode secondLastNode = cacheTail.prev;

			secondLastNode.next = cacheNode;
			cacheNode.prev = secondLastNode;

			cacheNode.next = cacheTail;
			cacheTail.prev = cacheNode;
			size++;

		}

		public void deleteLast() {
			CacheNode thirdLastNode = cacheTail.prev.prev;

			thirdLastNode.next = cacheTail;
			cacheTail.prev = thirdLastNode;
			size--;
		}

		public void deleteNode(CacheNode cacheNode) {
			CacheNode prevNode = cacheNode.prev;
			CacheNode nextNode = cacheNode.next;

			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			size--;
		}

		public CacheNode getLastNode(){
			if(size > 0 ){
				return cacheTail.prev;
			}
			return null;
		}

		public void printDoublyLinkedList(){
			CacheNode tempHead = cacheHead;
			while(tempHead != null ){
				System.out.print(tempHead.data+" -> ");
				tempHead = tempHead.next;
			}
			System.out.println();
		}
	}

	private int capacity;
	private HashMap<Integer,CacheNode> hashMap;
	CacheDoublyLinkedList cacheDoublyLinkedList;
	public LRUCache(int capacity) {
		this.capacity = capacity;
		hashMap = new HashMap<Integer, CacheNode>();
		cacheDoublyLinkedList = new CacheDoublyLinkedList();
	}

	public int get(int key) {
		if( hashMap.containsKey(key) ) {
			CacheNode cacheNode = hashMap.get(key); 
			int ans = cacheNode.data;

			//make it recently used
			cacheDoublyLinkedList.deleteNode(cacheNode);
			CacheNode newCacheNode = new CacheNode(key,ans);
			cacheDoublyLinkedList.insertAtStart(newCacheNode);
			hashMap.put(key, newCacheNode);
			return ans;
		}else {
			return -1;
		}
	}

	public void put(int key, int value) {

		if( hashMap.containsKey(key) ) {
			//key is already present

			CacheNode oldCacheNode = hashMap.get(key);
			cacheDoublyLinkedList.deleteNode(oldCacheNode);
			hashMap.remove(key);

			CacheNode newCacheNode = new CacheNode(key,value);
			cacheDoublyLinkedList.insertAtStart(newCacheNode);
			hashMap.put(key, newCacheNode);

		}else {
			//key is not present

			if(cacheDoublyLinkedList.size() < capacity ) {
				//there is space
				CacheNode cacheNode = new CacheNode(key,value);
				cacheDoublyLinkedList.insertAtStart(cacheNode);

				hashMap.put(key, cacheNode);
			}else {

				//no space
				CacheNode lastNode = cacheDoublyLinkedList.getLastNode();
				hashMap.remove(lastNode.key);
				cacheDoublyLinkedList.deleteLast();

				CacheNode newCacheNode = new CacheNode(key,value);
				cacheDoublyLinkedList.insertAtStart(newCacheNode);
				hashMap.put(key, newCacheNode);
			}
		}
	}
}


