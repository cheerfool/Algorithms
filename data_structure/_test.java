package data_structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;


public class _test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		MyHashMap map= new MyHashMap();
//		for(int i=0; i<93; i++){
//			Integer freq= (Integer) map.get(i%20);
//			if(freq==null)
//				map.put(i%20, 1);
//			else
//				map.put(i%20, freq+1);
//		}
//		
//		for(Entry e: map.entrySet()){
//			print(e.key+":"+e.value);
//		}
//		
//		print(map.size+", "+map.count);
//		print(map.table[2].key+ ", " +map.table[3].value);
		
		HashMap<String, String> map= new HashMap<String, String>();
		
		
		//LinkedList<String> list= new LinkedList<String>();
		//MyLinkedList list= new MyLinkedList();
		MyArrayList list= new MyArrayList();
		
		list.add("haha");
		list.add(null);
		list.add(null);
		list.add("yes");
		for(int i=0; i<30; i++)
			list.add("I'm "+i);
		
		print(list.indexOf(null)+", "+list.remove(0));
		for(int i=0; i<list.size(); i++){
			print(list.get(i));
		}
		
		
	}
	
	static void print(Object o){
		System.out.println(o);
	}

}
