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
		String str= "HElLo";
		str= str.toLowerCase();
		print(str);
		
		int[] freq= new int[256]; 
		Set<String> set= new HashSet<String>();
		for(int i=0; i<str.length(); i++){
			//int ch= str.charAt(i);
			//int j= ch;
			freq[str.charAt(i)]++;
			print(freq[str.charAt(i)]);
			
		}
		
		
//		char[] dic= new char[26];
//		for(char ch: dic){
//			int i= ch;
//			print(i);
//		}
//		
//		int[] li= new int[10];
//		for(int l: li)
			//print(l);
//		print(list.indexOf(null)+", "+list.remove(0));
//		for(int i=0; i<list.size(); i++){
//			print(list.get(i));
//		}
//		
		
	}
	
	static void print(Object o){
		System.out.println(o);
	}

    public int lengthOfLongestSubstring(String s) {
        int size= s.length();
        if(size==0)
            return 0;
        else if(size==1)
            return 1;
            
        int[] count= new int[256];
        int left=0;
        int right=1;
        int len= 1;
        int max= 1;
        count[s.charAt(0)]=1;
        while(left<right && right<size){
            char chr= s.charAt(right);
            if(count[chr]==0){
                count[chr]++;
                len++;
                if(len> max)
                    max= len;
            }else{
                while(left<right){
                    char chl= s.charAt(left);
                    left++;
                    if(chl==chr)
                        break;
                    else
                        count[chl]--;
                }
            }
            right++;
        }
        return max;
    }
}
