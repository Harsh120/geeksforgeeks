/*
Question link : https://practice.geeksforgeeks.org/problems/relative-sorting/0/?ref=self

Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.

Note: Expected time complexity is O(N log(N)).

Input:
First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.

Output:
Print the relatively sorted array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N,M  ≤ 106
1 ≤ A1[], A2[] <= 106

Example:
Input:
1
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3

Output:
2 2 1 1 8 8 3 5 6 7 9
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    while(t-->0)
	    {
	        String line = br.readLine();
	        String[] strs = line.trim().split("\\s+");
	        int n = Integer.parseInt(strs[0]);
	        int m = Integer.parseInt(strs[1]);
	        line = br.readLine();
	        strs = line.trim().split("\\s+");
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++)
	        {
	            arr[i] = Integer.parseInt(strs[i]);
	        }
	        line = br.readLine();
	        strs = line.trim().split("\\s+");
	       
	        HashMap<Integer,Integer> hm1 = new HashMap<Integer,Integer>();
	        HashMap<Integer,Integer> hm2 = new HashMap<Integer,Integer>();  //For Bidirectional mapping you can use "BiMap" or "BidiMap" also
	        for(int i=0;i<m;i++)
	        {
	            hm1.put(Integer.parseInt(strs[i]),i-m);
	            hm2.put(i-m,Integer.parseInt(strs[i]));
	        }
	        
	        for(int i=0;i<n;i++)
	        {
	            if(hm1.containsKey(arr[i]))
	            {
	                arr[i] = hm1.get(arr[i]);
	            }
	        }
	        
	        Arrays.sort(arr);
	        
	        for(int i=0;i<n;i++)
	        {
	            if(hm2.containsKey(arr[i]))
	            {
	                arr[i] = hm2.get(arr[i]);
	            }
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<n;i++)
	        {
	            sb.append(arr[i]);
	            sb.append(" ");
	        }
	        System.out.println(sb);
	        
	    }
	 }
}
