//Question link : https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
/*
Given K sorted arrays arranged in form of a matrix. The task is to merge them. You need to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays. The function should return a pointer to the merged sorted arrays.

Input:
The first line of input contains the number of test cases, then T test cases follows. Each test case will contain an integer N denoting the number of sorted arrays. Then in the next line contains all the elements of the array separated by space.

Output:
The output will be the sorted merged array.

User Task:
The task is to complete the function mergeKArrays() which takes two arguments, and returns pointer to the modified array.

Constraints:
1 <= T <= 50
1 <= N <= 103
1 <= K <= 10

Example:
Input:
1
3
1 2 3 4 5 6 7 8 9 

Output:
1 2 3 4 5 6 7 8 9

Explanation:
Testcase 1:
Above test case has 3 sorted arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],

             [4, 5, 6],

             [7, 8, 9]]
The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
*/

import java.util.*;
class Merge{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			GfG g = new GfG();
			ArrayList<Integer> arr= g.mergeKArrays(a, n);
			printArray(arr,n*n);
		}
	}
	public static void printArray(ArrayList<Integer> arr, int size){
		for(int i = 0; i < size ; i++)
			System.out.print(arr.get(i)+" ");
		System.out.println();
	}
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class GfG
     {
        public static void mergesort(ArrayList<Integer> list, int[][] arrays, int index, int k)
         {
                int[] L = new int[list.size()];
                int[] R = new int[k];
                
                for(int i=0;i<list.size();i++)
                {
                    L[i] = list.get(i);
                }
                for(int i=0;i<k;i++)
                {
                    R[i] = arrays[index][i];
                }
                
                int i=0;
                int j=0;
                
                
                list.clear();
                while(i<L.length && j<R.length)
                {
                    if(L[i]<=R[j])
                    {
                        list.add(L[i]);
                        i++;
                    }
                    else
                    {
                        list.add(R[j]);
                        j++;
                    }
                }
                
                while(i<L.length)
                {
                    list.add(L[i]);
                    i++;
                }
                
                while(j<R.length)
                {
                    list.add(R[j]);
                    j++;
                }
         }
         
        public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
          {
             ArrayList<Integer> list = new ArrayList<Integer>();
             for(int i=0;i<k;i++)
             {
                 list.add(arrays[0][i]);
             }
             for(int i=1;i<k;i++)
             {
                 mergesort(list,arrays,i,k);
             }
             return list;
          }
}
