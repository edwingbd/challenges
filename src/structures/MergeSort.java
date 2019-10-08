package structures;

public class MergeSort {
	void merge(int arr[], int left, int middle,  int right) {
		
		int sizeLeft=middle-left +1;
		int sizeRight=right - middle;
		
		/*Create temporal arrays right and left*/
		int leftArr[] = new int[sizeLeft];
		int rightArr[] = new int[sizeRight];
		
		/*pass the information from one array to another*/
		for (int i=0;i<sizeLeft;++i)
			leftArr[i]=arr[left+i];
		
		for (int j=0;j<sizeRight;++j)
			rightArr[j]=arr[middle+1+j];
		
		/*merge the temp arrays bak into arr[l,r]*/
		int i=0;
		int j=0;
		int k=left;
		while ((i<sizeLeft) && (j< sizeRight)){
			if (leftArr[i]<=rightArr[j]) {
				arr[k]=leftArr[i];
				i++;
			} 
			else {
				arr[k]=rightArr[j];
				j++;
			}
			k++;
		}
		
		/*Copy the remianing elements of Left[], if there are any*/
		while(i< sizeLeft ) {
			arr[k]=leftArr[i];
			i++;
			k++;
		}
		/*Copy the remianing elements of right[], if there are any*/
		while(j< sizeRight ) {
			arr[k]= rightArr[j];
			j++;
			k++;
		}	
	}
	
	void sort(int arr[],int left,int right) {
		if (left < right) {
			int middle=(left+right)/2;
			sort (arr,left,middle);
			sort (arr, middle+1,right);
			merge(arr,left,middle,right);
		}
	}
	
	void sort(int arr[]) {
		sort(arr,0,arr.length-1);
	}
	
	static void printArray(int arr[]) {
		int n=arr.length;
		for (int i=0;i<n;++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
