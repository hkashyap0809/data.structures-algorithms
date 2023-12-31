package com.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class FlightTuple{
    int stop;
    int node;
    int price;
    FlightTuple(int stop, int node, int price){
        this.stop = stop;
        this.node = node;
        this.price = price;
    }
}
class FlightPair{
    int to;
    int price;
    FlightPair(int to, int price){
        this.to = to;
        this.price = price;
    }
}
public class ChespestFlightWithinKstops {
    public List<List<FlightPair>> createGraph(int n, int[][] flights){
        List<List<FlightPair>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add( new ArrayList<>());
        }
        for(int[] flight : flights ){
            graph.get(flight[0]).add(new FlightPair(flight[1],flight[2]));
        }
        return graph;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<FlightPair>> graph = createGraph(n,flights);
        PriorityQueue<FlightTuple> queue = new PriorityQueue<>((a,b)->a.stop-b.stop);
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        queue.add(new FlightTuple(0,src,0));
        dist[src]=0;
        
        while( !queue.isEmpty() ){
            FlightTuple topEl = queue.poll();
            int stop = topEl.stop;
            int node = topEl.node;
            int price = topEl.price;

            if( node == dst ) {
                dist[node] = Math.min( dist[node] , price );
                continue;
            }
            for( FlightPair neighbour : graph.get(node) ){
                if( dist[neighbour.to] > price + neighbour.price && stop < k+1 ){
                    queue.add( new FlightTuple(stop+1, neighbour.to , price + neighbour.price) );
                    System.out.println((stop+1)+" "+neighbour.to+" "+( price + neighbour.price));
                    dist[ neighbour.to ] =  price + neighbour.price;
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}