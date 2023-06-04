import java.io.*;
import java.lang.*;

class GFG
{
	public static int Nth_of_AP(int a,
								int d,
								int N)
	{
		return ( a + (N - 1) * d );
	}

	public static void main(String[] args)
	{
		int a = 2;
		
		int d = 1;
		
		int N = 5;

		System.out.print("The "+ N +
						"th term of the series is : " +
						Nth_of_AP(a, d, N));
	}
}
