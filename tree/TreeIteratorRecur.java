package tree;

public class TreeIteratorRecur {
	private void pre(Node root){
		if(root!=null){
			System.out.print(root.value+", ");
			pre(root.left);
			pre(root.right);
		}
	}
	
	private void in(Node root){
		if(root!=null){
			in(root.left);
			System.out.print(root.value+", ");
			in(root.right);
		}
	}
	
	private void post(Node root){
		if(root!=null){
			post(root.left);
			post(root.right);
			System.out.print(root.value+", ");
		}
	}
	
	void preOrder(Node root){
		System.out.print("PreOrder(r): ");
		pre(root);
		System.out.println();
	}
	
	void inOrder(Node root){
		System.out.print("InOrder(r): ");
		in(root);
		System.out.println();
	}
	
	void postOrder(Node root){
		System.out.print("PostOrder(r): ");
		post(root);
		System.out.println();
	}
}
