package sort;

public class QuickSort {
	public void sort(int[] list){
		qsort(list, 0, list.length-1);
	}
	
	void qsort(int[] list, int low, int high){
		if(low<high){
			int middle= getMiddle(list, low, high);
			qsort(list, low, middle-1);
			qsort(list, middle+1, high);
		}
	}
	
	int getMiddle(int[] list, int low, int high){
		int temp= list[low];
		while(low<high){
			while(low<high && temp<=list[high])
				high--;
			list[low]=list[high];
			//low++;
			while(low<high && temp>=list[low])
				low++;
			list[high]=list[low];
			//high--;
		}
		list[low]=temp;
		return low;
	}
}
