package tree;

import java.util.Random;

public class _test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=10;
		Random rdm= new Random(510);
		BinarySearchTree bst= new BinarySearchTree();
		for(int i=0; i<size; i++)
			bst.add(rdm.nextInt(100));
		Node root= bst.head;
		TreeIterator it= new TreeIterator();
		TreeIteratorRecur itr= new TreeIteratorRecur();
		it.leverOrder(root);
		it.preOrder(root);
		itr.preOrder(root);
		it.inOrder(root);
		itr.inOrder(root);
		it.postOrder(root);
		itr.postOrder(root);
		
		find(bst, 34);
		find(bst, 65);
		find(bst, 56);
		find(bst, 60);
		System.out.println("Done.\n");
	}
	
	static void find(BinarySearchTree bst, int x){
		System.out.println("Find "+x+": "+bst.find(x));
	}

}
