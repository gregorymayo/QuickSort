import javax.swing.*;
import java.util.*;
import java.util.Arrays;



public class quickSort {

	public static void swapNumber(int A[],int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j]=temp;
	}
	
	public static void printAll(int A[])
	{
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	public static int partition(int[] A, int p, int r)
	{	
		int pivot = A[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++)
		{
			if(A[j]<=pivot){
				i=i+1;
				swapNumber(A,i,j);
			}	
		}
		swapNumber(A,i+1,r);
		return (i+1);
	}
	public static void quickSort(int[] A, int p, int r)
	{
		if(p<r){
			int q = partition(A,p,r);
			quickSort(A,p,q-1);
			quickSort(A,q+1,r);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int A[] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		int length = A.length-1;
		quickSort(A,0,length);
		printAll(A);
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("\n\nRunning Time: "+ duration + " ns");
	}

}
