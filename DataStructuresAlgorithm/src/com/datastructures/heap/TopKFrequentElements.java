package com.datastructures.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FreqPair{
    int num;
    int freq;
    FreqPair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int num : nums ){
            hashMap.put(num, hashMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<FreqPair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        for( Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            pq.add(new FreqPair(entry.getKey(),entry.getValue()));
        }

        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = pq.poll().num;
        }
        return res;
    }
}