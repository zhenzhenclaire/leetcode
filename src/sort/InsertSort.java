package sort;

import search.Select;

public class InsertSort {
	int[] array;
	
	public InsertSort(int[] array) {
		super();
		this.array = array;
	}
	
	public void insert(){
		for(int i = 1;i < array.length;i++){
			int temp = array[i];
			int j = i - 1;
			while(j >= 0 && temp <= array[j]){
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;	
		}
	}
	
	public void Select(){
		for(int i = 0;i < array.length;i++){
			int min = i;
			for(int j = i + 1; j < array.length;j++){
				if(array[min] > array[j]){
					min = j;
				}
			}
			swap(min, i);
		}
	}
	
	public void swap(int i,int j){
		int min = i;
		int temp = array[j];
		array[j] = array[min];
		array[min] = temp;
	}
	
	public void BinarySelect(){
		for(int i = 0;i < array.length / 2;i++){
			int min = i;
			int max = array.length - i - 1;
			for(int j = i + 1;j < array.length - i;j++){
				if(array[min] > array[j]){
					min = j;
					continue;
				}
				if(array[j] > array[max]){
					max = j;
				}
			}
			swap(min, i);
			swap(max, array.length - i - 1);
		}
	}
	
	public void Bubble(){
		for(int i = 0; i < array.length - 1;i++){
			for(int j = 0; j < array.length -1 - i;j++){
				if(array[j] > array[j + 1]){
					swap(j, j + 1);
				}
			}
		}
	}
	
	public void BinaryBubble(){
		int low = 0, high = array.length - 1;
		
		while(low < high){
			for(int i = low;i < high;i++){
				if(array[i] > array[i + 1]){
					swap(i, i + 1);
				}
			}
			high--;
			for(int j = high;j > low;j--){
				if(array[j] < array[j - 1]){
					swap(j, j - 1);
				}
			}
			low++;
		}
	}
	
	public int partition(int low, int high){
		int temp = array[low];
		while(low < high){
			while(low < high && array[high] > temp)	high--;
			swap(high, low);
			while(low < high && array[low] < temp)	low++;
			swap(low, high);
		}
		return low;
	}
	
	public void qSort(int low, int high){
		if(low < high){
			int partIndex = partition(low,high);
			qSort(low, partIndex - 1);
			qSort(partIndex + 1, high);
		}
		
	}
	
	public static void main(String[] args) {
		int[] array = {48,38,65,97,76,13,27,49}; 
		InsertSort iSort = new InsertSort(array);
//		iSort.insert();
//		iSort.Select();
//		iSort.BinarySelect();
//		iSort.Bubble();
//		iSort.BinaryBubble();
		iSort.qSort(0, array.length - 1);
		for(int i = 0;i < array.length;i++){
			System.out.print(array[i] + " ");
		}
	}
}
