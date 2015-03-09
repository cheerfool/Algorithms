package data_structure;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap {
	int size= 10;
	double limitFactor= 0.75;
	int count=0;
	Entry[] table;
	Object nullValue;
	
	MyHashMap(int size){
		if(size>this.size){
			this.size= size;
			table= new Entry[size];
		}
	}
	MyHashMap(){
		table= new Entry[size];
	}
	
	Object put(Object key, Object value){
		if(key==null){
			Object old= nullValue;
			nullValue= value;
			return old;
		}
		int hash= key.hashCode();
		int index= hash%table.length;
		if(index<0)
			index+= table.length;
		for(Entry e= table[index]; e!=null; e=e.next){
			if(e.key.equals(key)){
				Object old= e.value;
				e.value= value;
				return old;
			}
		}
		count++;
		if(count>size*limitFactor){
			rehash();
			index= hash % table.length;
			if(index<0)
				index+= table.length;
		}
		Entry e= new Entry(key, value, table[index]);
		table[index]= e;
		return e;
	}
	
	Object get(Object key){
		if(key==null)
			return nullValue;
		int hash=key.hashCode();
		int index= hash%table.length;
		if(index<0)
			index+= table.length;
		for(Entry e= table[index]; e!=null; e=e.next){
			if(e.key.equals(key))
				return e.value;
		}
		return null;	
	}
	
	boolean containsKey(Object key){
		if(key==null)
			return nullValue!=null;
		int index= key.hashCode()%table.length;
		if(index<0)
			index+= table.length;
		for(Entry e= table[index]; e!=null; e=e.next){
			if(e.key.equals(key))
				return true;
		}
		return false;
	}
	
	Set<Entry> entrySet(){
		Set<Entry> entryset= new HashSet<Entry>();
		for(int i=0; i<table.length; i++){
			for(Entry e= table[i]; e!=null; e=e.next){
				entryset.add(e);
			}
		}
		return entryset;
	}
	
	void rehash(){
		size= size*2+1;
		Entry[] newTable= new Entry[size];
		for(Entry oldEntry: this.entrySet()){
			int index= oldEntry.key.hashCode() % newTable.length;
			if(index<0)
				index+= newTable.length;
			oldEntry.next= newTable[index];
			newTable[index]= oldEntry;
		}
		table= newTable;
	}
}

class Entry{
	Object key;
	Object value;
	Entry next;
	Entry(Object key, Object value, Entry next){
		this.key= key;
		this.value= value;
		this.next= next;
	}
}