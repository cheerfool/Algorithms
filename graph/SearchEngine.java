package graph;

import java.util.HashMap; 
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchEngine {
	
	void bfs(HashMap<Node, LinkedList<Node>> graph, Node start){
		System.out.println("BFS: ");
		Queue<Node> queue= new LinkedList<Node>();
		queue.offer(start);
		start.depth=0; 
		while(queue.size()>0){
			Node temp= queue.poll();
			int r= temp.depth;
			visit(temp);
			for(Node neighbor: graph.get(temp)){
				if(neighbor.depth==Integer.MAX_VALUE){
					queue.offer(neighbor);
					neighbor.depth= r+1;
				}
			}
		}
	}
	
	void dfs(HashMap<Node, LinkedList<Node>> graph, Node start){
		System.out.println("DFS: ");
		Stack<Node> stack= new Stack<Node>();
		start.depth= stack.size();
		visit(start);
		stack.push(start);
		while(stack.size()>0){
			if(allNeighborVisited(graph, stack.peek())){
				stack.pop();
			}else{
				for(Node neighbor: graph.get(stack.peek())){
					if(!neighbor.visited){
						neighbor.depth= stack.size();
						visit(neighbor);
						stack.push(neighbor);
						break;
					}
				}
			}
		}
		//System.out.println("]");
	}
	
	void dfsRecur(HashMap<Node, LinkedList<Node>> graph, Node start){
		System.out.print("DFS (Recursive): [");
		dfsR(graph, start);
		System.out.println("]");
	}
	
	private void dfsR(HashMap<Node, LinkedList<Node>> graph, Node start){
		visitR(start);
		for(Node neighbor: graph.get(start)){
			if(!neighbor.visited){
				dfsR(graph, neighbor);
			}
		}
	}
	
	private void visitR(Node n){
		n.visited= true;
		System.out.print(n.value+", ");
	}
	
	private void visit(Node n){
		n.visited= true;
		System.out.println("["+n.value+": "+n.depth+"]");
	}
	
	private boolean allNeighborVisited(HashMap<Node, LinkedList<Node>> graph, Node n){
		for(Node neighbor: graph.get(n)){
			if(neighbor.visited== false)
				return false;
		}
		return true;
	}
	
	HashMap<Node, Integer> bfsDist(HashMap<Node, LinkedList<Node>> graph, Node start){
		System.out.println("BFS: ");
		HashMap<Node, Integer> dist= new HashMap<Node, Integer>();
		Queue<Node> queue= new LinkedList<Node>();
		queue.offer(start);
		dist.put(start, 0);
		while(queue.size()>0){
			Node temp= queue.poll();
			int r= dist.get(temp);
			visit(temp);
			for(Node neighbor: graph.get(temp)){
				if(!dist.containsKey(neighbor)){
					queue.offer(neighbor);
					dist.put(neighbor, r+1);
				}
			}
		}
		return dist;
	}
}
