package data_structure;

public class MyLinkedList {
	int size=0;
	Node header;
	
	MyLinkedList(){
		header= new Node(null,null,null);
		header.previous= header;
		header.next= header;
	}
	
	int size(){
		return size;
	}
	
	boolean contains(Object o){
		int index= indexOf(o);
		return index>=0;
	}
	
	void add(Object o){
		addBefore(header, o);
	}
	
	void add(int index, Object o){
		addBefore(getNode(index), o);
	}
	
	private Node addBefore(Node n, Object o){
		Node temp= new Node(o, n.previous, n);
		temp.previous.next= temp;
		temp.next.previous= temp;
		size++;
		return temp;
	}
	
	Object remove(int index){
		Node temp= getNode(index);
		temp.previous.next= temp.next;
		temp.next.previous= temp.previous;
		size--;
		return temp.value;
	}
	
	
	
	Object get(int index){
		return getNode(index).value;
	}
	
	private Node getNode(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Node temp= header;
		if(index< (size>>1)){
			for(int i=0; i<=index; i++)
				temp= temp.next;
		}else{
			for(int i=size; i>index; i--)
				temp= temp.previous;
		}
		return temp;
	}
	
	int indexOf(Object o){
		Node temp= header;
		if(o==null){
			for(int i=0; temp.next!=header; i++){
				temp= temp.next;
				if(temp.value==null)
					return i;
			}
		}else{
			for(int i=0; temp.next!=header; i++){
				temp= temp.next;
				if(temp.value.equals(o))
					return i;
			}
		}
		return -1;
	}
	
	int lastIndexOf(Object o){
		Node temp= header;
		if(o==null){
			for(int i=size-1; temp.previous!=null; i--){
				temp= temp.previous;
				if(temp.value==null)
					return i;
			}
		}else{
			for(int i=size-1; temp.previous!=null; i--){
				temp= temp.previous;
				if(temp.value.equals(o))
					return i;
			}
		}
		return -1;
	}
	
}

class Node{
	Object value;
	Node previous;
	Node next;
	Node(Object value, Node previous, Node next){
		this.value= value;
		this.previous= previous;
		this.next= next;
	}
}
