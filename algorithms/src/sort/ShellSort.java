package sort;
/*
 * Shell Sort(o(N^2))
 * Ï£¶ûÅÅÐò
 */

public class ShellSort<T extends Comparable<? super T>> {
	public void shellSort(T[] array){
		int j;
		for(int gap=array.length/2;gap>0;gap/=2){
			for(int i=gap;i<array.length;i++){
				T temp=array[i];
				for(j=i;j>=gap && temp.compareTo(array[j-gap])<0;j-=gap)
					array[j]=array[j-gap];
				array[j]=temp;
			}
		}
	}
	
	public static void main(String[] args){
		Integer[] array=new Integer[]{9,8,7,6,5,4,3,2,1,0,2,9,6,4,8,3,2};
		ShellSort<Integer> ss=new ShellSort<Integer>();
		ss.shellSort(array);
		for(int ele:array){
			System.out.print(ele+" ");
		}
	}
}
