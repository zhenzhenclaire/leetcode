package search;

import javax.swing.text.html.MinimalHTMLWriter;

public class Select {
	
	public int[] Sort(int[] array){
		int i = 0,j = 0;
		for(i = 0; i < array.length - 1;i++){
			int min = array[i];
			int minIndex = i;
			for(j = i + 1;j < array.length;j++){
				if(min > array[j]){
					min = array[j];
					minIndex = j;
				}
			}
			
			int temp = 0;
			
			temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;
		}
		return array;
	}
	
	public static void main(String[] args) {
		Select select = new Select();
		int[] array = {1,2,5,3,4};
		int[] result = select.Sort(array);
		for(int i = 0;i < result.length;i++){
			System.out.print(result[i]);
		}
	}
}
