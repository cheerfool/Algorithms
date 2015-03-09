package data_structure;

public class MyArrayList {
	int capacity= 20;
	int size=0;
	Object[] list;
	MyArrayList(){
		list= new Object[capacity];
	}
	MyArrayList(int n){
		if(n>capacity){
			capacity= n;
			list= new Object[capacity];
		}
	}
	
	int size(){
		return size;
	}
	
	void add(Object o){
		if(size+1>capacity)
			enlarge();
		list[size++]= o;
	}
	
	Object get(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		else
			return list[index];
	}
	
	Object remove(int index){
		if(index<0 || index>=size)
			throw new IndexOutOfBoundsException();
		Object temp= list[index];
		int moveLength= size-index-1;
		if(moveLength>0)
			System.arraycopy(list, index+1, list, index, moveLength);
		list[size-1]=null;
		size--;
		return temp;
	}
	
	int indexOf(Object o){
		if(o==null){
			for(int i=0; i<size; i++){
				if(list[i]==null)
					return i;
			}
		}else{
			for(int i=0; i<size; i++){
				if(list[i].equals(o))
					return i;
			}
		}
		return -1;
	}
	
	void enlarge(){
		capacity= capacity*2+1;
		Object[] newList= new Object[capacity];
		System.arraycopy(list, 0, newList, 0, size);
		list= newList;
	}
	
}
