package sort;

public class _test {
	static MergeSort sorter= new MergeSort();
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int list[] = {34,567,22,3,4,8,1111,-5,-10,-66,40123,12,45,366,7878,34,876,10};
		int len=20000;
		int lista[]= new int[len];
		int listb[]= new int[len];
		int listw[]= new int[len];
		for(int i=0; i<len; i++){
			listb[i]=i;
			listw[i]=len-i;
			if(i%2==0)
				lista[i]=i;
			else
				lista[i]=len-i;
		}
		sortp(list);
		int average= sort(lista);
		int best= sort(listb);
		int worst= sort(listw);
		System.out.println("Average case: "+average);
		System.out.println("Worse case: "+worst);
		System.out.println("Best case: "+best);
	}
	
	static int sort(int[] list){
		long start = System.currentTimeMillis();
		sorter.sort(list);
		long end = System.currentTimeMillis();
		return (int) (end-start);
	}
	
	static int sortp(int[] list){
		int time = sort(list);
		System.out.print("time: "+time+". {");
		for(int i:list){
			System.out.print(i+", ");
		}
		System.out.println("}");
		return time;
	}
}
