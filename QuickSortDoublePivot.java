import javax.swing.*;
import java.util.*;
import java.util.Arrays;

public class twoPivotQuickSort {

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
	
	public static int[] partition(int[] A, int p, int r, int[] B)
	{
		int pivot1 = A[p];
		B[0]=pivot1;
		int pivot2 = A[r];
		B[0]=pivot2;
		
		if (pivot1>pivot2){
	          swapNumber(A, p, r);
	          pivot1=A[p];
	          pivot2=A[r];
	          B[0]=pivot1;
	          B[1]=pivot2;
	          
	          //sort(input, lowIndex, highIndex);
	      }
	      else if (pivot1==pivot2){
	          while (pivot1==pivot2 && p<r){
	              p++;
	              pivot1=A[p];
	              B[0]=pivot1;
	          }
	      }
	      
	      int i=p+1;
	      int lt=p+1;
	      int gt=r-1;
	      
	      while (i<=gt){
	          
	          if ( A[i]< pivot1){
	              swapNumber(A, i++, lt++);
	          }
	          else if (pivot2< A[i]){
	              swapNumber(A, i, gt--);
	          }
	          else{
	              i++;
	          }
	      }
	      lt = lt-1;
	      gt=gt+1;
	      
	      swapNumber(A, p, lt);
	      swapNumber(A, r, gt);
	      
	      B[0]=lt;
	      B[1]=gt;
		
		return B;
	}
	public static void quickSort(int[] A, int p, int r,int[] B)
	{
		if(p<r){
			int pivot1 = B[0], pivot2=B[1];
			B = partition(A,p,r,B);
			quickSort(A,p,pivot1-1,B);
			quickSort(A,pivot1+1,pivot2-1,B);
			quickSort(A,pivot2+1,r,B);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int A[] = {9,4,18,14,16,17,20,1,11,19,3,7,8,10,13,15,6,2,5,12};
		int B[] = new int[2];
		int length = A.length-1;
		
		B[0]=A[0];
		B[1]=A[length];

		quickSort(A,0,length,B);
		printAll(A);
		
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("\n\nRunning Time: "+ duration + " ns");
	}

}
