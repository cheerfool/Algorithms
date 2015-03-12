package graph;

public class Node {
	int value;
	int depth;
	boolean visited;
	Node(int x){
		value= x;
		depth=Integer.MAX_VALUE;
		visited= false;
	}
}
