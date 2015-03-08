package sort;

public class SelectSort {
	public void sort(int[] list){
		int len= list.length;
		for(int i=0; i<len-1; i++){
			int smlIndex= i;
			int sml= list[i];
			for(int j=i; j<len; j++){
				if(list[j]<sml){
					smlIndex=j;
					sml=list[j];
				}
			}
			list[smlIndex]=list[i];
			list[i]=sml;
		}
	}
}
