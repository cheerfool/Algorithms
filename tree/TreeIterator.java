package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeIterator {
	void leverOrder(Node root){
		Queue<Node> queue= new LinkedList<Node>();
		if(root==null)
			return;
		queue.offer(root);
		int size;
		System.out.println("LevelOrder: ");
		while((size=queue.size())>0){
			System.out.print("[");
			for(int i=0; i<size; i++){
				Node temp= queue.poll();
				System.out.print(temp.value+", ");
				if(temp.left!=null)
					queue.offer(temp.left);
				if(temp.right!=null)
					queue.offer(temp.right);
			}
			System.out.println("]");
		}
	}
	
	void preOrder(Node root){
		System.out.print("PreOrder: ");
		Stack<Node> stack= new Stack<Node>();
		while(root!=null || stack.size()>0){
			while(root!=null){
				System.out.print(root.value+", ");
				stack.push(root);
				root= root.left;
			}
			root= stack.pop();
			root= root.right;
		}
		System.out.println();
	}
	
	void inOrder(Node root){
		System.out.print("InOrder: ");
		Stack<Node> stack= new Stack<Node>();
		while(root!=null || stack.size()>0){
			while(root!=null){
				stack.push(root);
				root= root.left;
			}
			root= stack.pop();
			System.out.print(root.value+", ");
			root= root.right;
		}
		System.out.println();
	}
	
	void postOrder(Node root){
		System.out.print("PostOrder: ");
		Stack<Node> stack= new Stack<Node>();
		Node pre=null;
		while(root!=null || stack.size()>0){
			while(root!=null){
				stack.push(root);
				root= root.left;
			}
			Node tempRight= stack.peek().right;
			if(tempRight==null || tempRight==pre){
				root= stack.pop();
				System.out.print(root.value+", ");
				pre= root;
				root= null;
			}else{
				root= tempRight;
			}
		}
		System.out.println();
	}
	
	
}
