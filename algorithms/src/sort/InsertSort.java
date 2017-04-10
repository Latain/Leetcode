package sort;
/*
 * Insert Sort(O(N^2))
 * ≤Â»Î≈≈–Ú
 */

public class InsertSort<T extends Comparable<? super T>> {
	public void insertSort(T[] array){
		int j;
		for(int i=1;i<array.length;i++){
			T temp=array[i];
			for(j=i;j>0 && temp.compareTo(array[j-1])<0;j--)
				array[j]=array[j-1];
			array[j]=temp;
		}
	}
	
	public static void main(String[] args){
		Integer[] array=new Integer[]{4,3,9,4,6,1,3,5,6,7,8,5,2,8};
		InsertSort<Integer> is=new InsertSort<Integer>();
		is.insertSort(array);
		for(Integer element:array)
			System.out.print(element+" ");
	}
}
