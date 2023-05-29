import java.io.*;

class ar {
	
	static void findClosest(int A[], int B[], int C[],
								int p, int q, int r)
	{
		int diff = Integer.MAX_VALUE; // Initialize min diff
	
		int res_i =0, res_j = 0, res_k = 0;
	
		int i = 0, j = 0, k = 0;
		while (i < p && j < q && k < r)
		{
			int minimum = Math.min(A[i],
						Math.min(B[j], C[k]));
			int maximum = Math.max(A[i],
						Math.max(B[j], C[k]));
	
			if (maximum-minimum < diff)
			{
				res_i = i;
				res_j = j;
				res_k = k;
				diff = maximum - minimum;
			}
	
			if (diff == 0) break;
	
			if (A[i] == minimum) i++;
			else if (B[j] == minimum) j++;
			else k++;
		}
	
		System.out.println(A[res_i] + " " +
						B[res_j] + " " + C[res_k]);
	}

	public static void main (String[] args)
	{
		int A[] = {1, 4, 10};
		int B[] = {2, 15, 20};
		int C[] = {10, 12};
	
		int p = A.length;
		int q = B.length;
		int r = C.length;
	
		findClosest(A, B, C, p, q, r);
	}
}

// This code is contributed by Ajit.
