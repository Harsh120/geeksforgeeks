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
