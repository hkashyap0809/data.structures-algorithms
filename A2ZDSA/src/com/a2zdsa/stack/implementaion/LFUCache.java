package com.a2zdsa.stack.implementaion;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
	static class CacheNode{
		int key;
		int data;
		int count;
		CacheNode next;
		CacheNode prev;

		CacheNode(){
			this.key = -1;
			this.data = -1;
			this.next = null;
			this.prev = null;
			this.count = -1;
		}

		CacheNode(int key, int data, int count){
			this.count = count;
			this.key = key;
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		public void increaseCount() {
			this.count++;
		}
		public int getCount() {
			return this.count;
		}

		public int getData() {
			return this.data;
		}

		@Override
		public String toString() {
			return "[" + key + "," + data + "," + count +"]";
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

		public CacheNode getHead() {
			return cacheHead;
		};

		public CacheNode getTail() {
			return cacheTail;
		}

		public void insertAtStart(CacheNode cacheNode) {
			CacheNode nextNode = cacheHead.next;

			cacheNode.next = nextNode;
			cacheHead.next = cacheNode;
			nextNode.prev = cacheNode;
			cacheNode.prev = cacheHead;
			this.size++;
		}

		public void deleteLast() {
			CacheNode thirdLastNode = cacheTail.prev.prev;

			thirdLastNode.next = cacheTail;
			cacheTail.prev = thirdLastNode;
			this.size--;
		}

		public void deleteNode(CacheNode cacheNode) {
			CacheNode prevNode = cacheNode.prev;
			CacheNode nextNode = cacheNode.next;

			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			this.size--;
		}
		public CacheNode getLRUCacheNode() {
			if( this.size > 0 )	return cacheTail.prev;
			return null;
		}
		public void deleteLRUCacheNode() {
			if(this.size > 0 ) {
				this.deleteLast();
			}
		}

		public void printDoublyLinkedList(){
			CacheNode tempHead = cacheHead;
			while(tempHead != null ){
				System.out.print(tempHead.toString());
				tempHead = tempHead.next;
				if( tempHead != null ) {
					System.out.print("->");
				}
			}
			System.out.println();
		}

	}


	private HashMap<Integer,CacheNode> cacheMap = new HashMap<>(); //key,node
	private HashMap<Integer,CacheDoublyLinkedList> freqMap = new HashMap<>(); //freq,list-head
	private int capacity;
	private int minFreq;

	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.minFreq = 1;
	}

	private void printCache(){
		System.out.println("****************************************");
		for(Map.Entry<Integer,CacheDoublyLinkedList> entry : freqMap.entrySet() ){
			System.out.print( entry.getKey() + " ");
			entry.getValue().printDoublyLinkedList();
		}
		for(Map.Entry<Integer,CacheNode> entry : cacheMap.entrySet()){
			System.out.println(entry.getKey()+" "+entry.getValue().data);
		}
		System.out.println("****************************************");
	}

	public int get(int key) {
		System.out.println("GET "+key);

		if( cacheMap.containsKey(key) ) {

			CacheNode cacheNode = cacheMap.get(key);

			int retVal = cacheNode.getData();
			int oldFreq = cacheNode.getCount();
			cacheNode.increaseCount();
			int newFreq = cacheNode.getCount();


			freqMap.get(oldFreq).deleteNode(cacheNode);
			if( freqMap.get(oldFreq).size() == 0 ) {
				minFreq++;
			}

			if( freqMap.containsKey(newFreq) ) {
				freqMap.get(newFreq).insertAtStart(cacheNode);
			}else {
				CacheDoublyLinkedList newList = new CacheDoublyLinkedList();
				newList.insertAtStart(cacheNode);
				freqMap.put(newFreq, newList);
			}
			cacheMap.put(key, cacheNode);

			printCache();
			return retVal;
		}
		printCache();
		return -1;

	}

	public void put(int key, int value) {

		System.out.println("PUT ("+key+","+value+")");


		//if key already exists
		if( cacheMap.containsKey(key) ) {

			CacheNode cacheNode = cacheMap.get(key);

			int oldFreq = cacheNode.getCount();


			if( freqMap.get(oldFreq) != null )
				freqMap.get(oldFreq).deleteNode(cacheNode);

			if( freqMap.get(oldFreq)!=null && freqMap.get(oldFreq).size() == 0 ) {
				freqMap.remove(oldFreq);
			}

			cacheNode.increaseCount();
			int newFreq = cacheNode.count;

			if( freqMap.containsKey(newFreq) ) {

				freqMap.get(newFreq).insertAtStart(cacheNode);

			}else {
				CacheDoublyLinkedList newList = new CacheDoublyLinkedList();
				newList.insertAtStart(cacheNode);
				freqMap.put(newFreq, newList);
			}
			cacheMap.put(key, cacheNode);		
			printCache();	
		}
		else {
			//key does not exists -> new entry for the first time

			if( cacheMap.size() < capacity ) {
				//we have space to insert a new key
				minFreq = 1;

				if( freqMap.containsKey(minFreq)) {
					CacheDoublyLinkedList newList = freqMap.get(minFreq);
					CacheNode newNode = new CacheNode(key,value,minFreq);
					newList.insertAtStart(newNode);
					freqMap.put(minFreq, newList);
					cacheMap.put(key, newNode);
				}else {
					CacheDoublyLinkedList newList = new CacheDoublyLinkedList();
					CacheNode newNode = new CacheNode(key,value,1);
					newList.insertAtStart(newNode);
					freqMap.put(minFreq, newList);
					cacheMap.put(key, newNode);
				}
			}

			else {
				//remove LRU from the the minimum frequency list
				//insert the new node to the frequency = 1 list;

				CacheDoublyLinkedList minFreqCacheList = freqMap.get(minFreq);
				CacheNode removedNode = minFreqCacheList.getLRUCacheNode();


				if( removedNode != null ) {
					int removedKey = removedNode.key;
					cacheMap.remove(removedKey);
					//					minFreqCacheList.deleteNode(removedNode);
					minFreqCacheList.deleteLRUCacheNode();
				}

				minFreq = 1;
				CacheDoublyLinkedList newList = new CacheDoublyLinkedList();
				CacheNode newNode = new CacheNode(key,value,minFreq);

				newList.insertAtStart(newNode);
				freqMap.put(minFreq,newList);
				cacheMap.put(key,newNode);
			}
			printCache();

		}
	}
	public static void main(String[]args) {
		LFUCache lfuCache = new LFUCache(2);
		lfuCache.put(1, 1);
		lfuCache.put(2, 2);
		System.out.println(lfuCache.get(1));
		lfuCache.put(3, 3);
		System.out.println(lfuCache.get(2));
		System.out.println(lfuCache.get(3));
		lfuCache.put(4, 4);
		System.out.println(lfuCache.get(1));
		System.out.println(lfuCache.get(3));
		System.out.println(lfuCache.get(4));
	}
}

