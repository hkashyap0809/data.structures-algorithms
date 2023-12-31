package com.datastructures.graph;

public class CheckDisjoint {
	public static void main(String[] args) {
		System.out.println(args.length);
		DisjointSet disjointSet = new DisjointSet(7);
		disjointSet.printRankSizeParent();
		
		disjointSet.unionByRank(1, 2);
		disjointSet.printRankSizeParent();
		disjointSet.unionByRank(2, 3);
		disjointSet.printRankSizeParent();
		disjointSet.unionByRank(4, 5);
		disjointSet.printRankSizeParent();
		disjointSet.unionByRank(6, 7);
		disjointSet.printRankSizeParent();
		disjointSet.unionByRank(5, 6);
		disjointSet.printRankSizeParent();
		
		if( disjointSet.findParent(3) == disjointSet.findParent(7))
			System.out.println("same");
		else
			System.out.println("not same");
		
		disjointSet.unionByRank(3, 7);
		disjointSet.printRankSizeParent();
		
		if( disjointSet.findParent(3) == disjointSet.findParent(7))
			System.out.println("same");
		else
			System.out.println("not same");
		disjointSet.printRankSizeParent();
	}

}
