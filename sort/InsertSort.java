package sort;

public class InsertSort {
	public void sort(int[] list){
		int len= list.length;
		for(int i=1; i<len; i++){
			int temp= list[i];
			int j= i-1;
			while(j>=0 && temp<list[j]){
				list[j+1]=list[j];
				j--;
			}
			list[j+1]=temp;
		}
	}
}
