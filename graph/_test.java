package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class _test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=10;
		int degree= 4;
		Random rdm= new Random(500);
		HashMap<Node, LinkedList<Node>> graph= new HashMap<Node, LinkedList<Node>>();
		Node[] nodes= new Node[size];
		for(int i=0; i<size; i++)
			nodes[i]= new Node(rdm.nextInt(200));
		for(int i=0; i<size; i++){
			LinkedList<Node> list= new LinkedList<Node>();
			for(int j=0; j<rdm.nextInt(degree); j++){
				int index= rdm.nextInt(size);
				if(index!=i)
					list.add(nodes[index]);
			}
			if(i<size-1 && !list.contains(nodes[i+1]))
				list.add(nodes[i+1]);
			graph.put(nodes[i], list);
		}
		
		SearchEngine se= new SearchEngine();
		print(nodes, graph);
		Node root= nodes[0];
		se.bfs(graph, root);
		reset(nodes);
		se.dfs(graph, root);
		reset(nodes);
		se.dfsRecur(graph, root);
		
	}
	
	static void reset(Node[] nodes){
		for(Node n: nodes)
			n.visited= false;
	}
	
	static void print(Node[] nodes, HashMap<Node, LinkedList<Node>> graph){
		for(Node n: nodes){
			System.out.print(n.value+": [");
			for(Node neighbor: graph.get(n))
				System.out.print(neighbor.value+", ");
			System.out.println("]");
		}
	}
}
