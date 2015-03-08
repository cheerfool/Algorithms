package sort;

public class BubleSort {
	public void sort(int[] list){
		int len= list.length;
		for(int i=len-1; i>0; i--){
			boolean order= true;
			for(int j=1; j<=i; j++){
				if(list[j-1]>list[j]){
					int temp= list[j];
					list[j]= list[j-1];
					list[j-1]= temp;
					order= false;
				}
			}
			if(order)
				break;
		}
	}
	
	public void sort2(int[] list){
		int len= list.length;
		for(int last=len-1; last>0; ){
			int cur= -1;
			for(int j=1; j<=last; j++){
				if(list[j-1]>list[j]){
					int temp= list[j];
					list[j]= list[j-1];
					list[j-1]= temp;
					cur= j-1;
				}
			}
			last= cur;
		}
	}
}
