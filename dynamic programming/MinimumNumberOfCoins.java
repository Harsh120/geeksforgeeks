/*
Question link: https://practice.geeksforgeeks.org/problems/-minimum-number-of-coins

Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consist of an Integer value N denoting the amount to get change for.

Output:
Print all the denominations needed to make the change in a separate line.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 106

Example:
Input:
1
43

Output:
20 20 2 1

Explanation:
Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.
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
	        int sum = Integer.parseInt(br.readLine());
	        int[] coin ={1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
	        
	        int[][] table = new int[coin.length][sum+1];
	        for(int i=0;i<=sum;i++)
	        {
	            table[0][i]=i;
	        }
	        for(int i=0;i<coin.length;i++)
	        {
	            table[i][0]=0;
	        }
	        for(int i=1;i<coin.length;i++)
	        {
	            for(int j=1;j<=sum;j++)
	            {
	              if(j>=coin[i])
	              {
	                  table[i][j] = Math.min(table[i-1][j],1+table[i][j-coin[i]]);
	              }
	              else
	              {
	                  table[i][j] = table[i-1][j];
	              }
	            }
	        }
		    
		//To Print coins
	        int numcoin = table[coin.length-1][sum];
	        int i = coin.length-1;
	        int j = sum;
	        while(numcoin>0)
	        {
	            if(i>0 && j>0)
	            {
    	            if(table[i-1][j]==numcoin)
    	            {
    	                i = i-1;
    	            }
    	            else
    	            {
    	                System.out.print(coin[i]+" ");
    	                numcoin--;
    	                j = j - coin[i];
    	            }
	            }
	            else
	            {
	                System.out.print(coin[i]+" ");
	                numcoin--;
	            }
	        }
	        System.out.println();
	        
	 }
}
}
