package tree;

public class Node {
	int value;
	int attr;
	Node left;
	Node right;
	Node(int x){
		value= x;
		attr= value+1000;
	}
}
