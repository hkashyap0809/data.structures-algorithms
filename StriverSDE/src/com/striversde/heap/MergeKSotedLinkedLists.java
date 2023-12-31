package com.striversde.heap;

import java.util.PriorityQueue;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class MergePairList{
    int num;
    int idx;
    MergePairList(int num, int idx){
        this.num = num;
        this.idx = idx;
    }
}
public class MergeKSotedLinkedLists {
   public ListNode mergeKLists(ListNode[] lists) {
       
       PriorityQueue<MergePairList> pq = new PriorityQueue<>((a,b)-> a.num - b.num);
       int n = lists.length;

       for(int i=0;i<n;i++){
           if ( lists[i] != null ){
               pq.add(new MergePairList(lists[i].val,i));
               lists[i] = lists[i].next;
           }
       }

       ListNode head = new ListNode(-1);
       ListNode tempHead = head;

       while( !pq.isEmpty() ){
    	   MergePairList topEl = pq.poll();
           int topNum = topEl.num;
           int topIdx = topEl.idx;

           tempHead.next = new ListNode ( topNum );
           tempHead = tempHead.next;

           if ( lists[topIdx] != null ){
               pq.add(new MergePairList(lists[topIdx].val,topIdx));
               lists[topIdx] = lists[topIdx].next;
           }
       }
       return head.next;

   }
}