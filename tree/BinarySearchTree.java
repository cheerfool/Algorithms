package tree;

public class BinarySearchTree {
	Node head;
	void add(int newValue){
		Node newNode= new Node(newValue);
		
		Node pre = null;
		Node cur= head;
		while(cur!=null){
			pre= cur;
			if(newValue< cur.value)
				cur= cur.left;
			else
				cur= cur.right;
		}
		if(pre==null){
			head= newNode;
		}else{
			if(newValue< pre.value)
				pre.left= newNode;
			else
				pre.right= newNode;
		}
	}
	
	void addR(int newValue){
		head= addToTree(newValue, head);
	}
	
	Node addToTree(int newValue, Node root){
		if(root==null)
			return new Node(newValue);
		if(newValue< root.value)
			root.left= addToTree(newValue, root.left);
		else
			root.right= addToTree(newValue, root.right);
		return root;
	}
	
	int find(int value){
		Node cur= head;
		while(cur!=null){
			if(value== cur.value)
				return cur.attr;
			else if(value< cur.value)
				cur= cur.left;
			else if(value> cur.value)
				cur= cur.right;
		}
		return -1;
	}
	
	void delete(int target){
		head= deleteNode(target, head);
	}
	
	Node deleteNode(int target, Node root){
		if(root==null)
			return null;
		if(target< root.value)
			root.left= deleteNode(target, root.left);
		else if(target> root.value)
			root.right= deleteNode(target, root.right);
		else{
			if(root.left==null && root.right==null)
				return null;
			else if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else{
				Node cur= root.left;
				while(cur.right!=null)
					cur= cur.right;
				cur.right= root.right;
				return root.left;
			}
		}
		return root;
	}
	
}
