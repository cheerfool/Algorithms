package sort;

public class MergeSort {
	public void sort(int[] list){
		msort(list, 0, list.length-1);
	}
	
	void msort(int[] list, int low, int high){
		if(low<high){
			int mid= (low+high)/2;
			msort(list, low, mid);
			msort(list, mid+1, high);
			merge(list, low, mid, high);
		}
	}
	
	void merge(int[] list, int low, int mid, int high){
		int len= high-low+1;
		int[] temp= new int[len];
		int pleft= low;
		int pright= mid+1;
		int ptemp= 0;
		
		while(pleft<=mid && pright<=high){
			if(list[pleft]<=list[pright]){
				temp[ptemp]=list[pleft];
				pleft++;
			}else{
				temp[ptemp]=list[pright];
				pright++;
			}
			ptemp++;
		}
		
		while(pleft<=mid){
			temp[ptemp]=list[pleft];
			ptemp++;
			pleft++;
		}
		
		while(pright<=high){
			temp[ptemp]=list[pright];
			ptemp++;
			pright++;
		}
		
		for(int i=0; i<len; i++)
			list[low+i]= temp[i];
	}
}
