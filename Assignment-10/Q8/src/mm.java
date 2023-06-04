
import java.io.*;

class mm {

	static boolean isConsonant(char ch)
	{
		ch = Character.toUpperCase(ch);
	
		return !(ch == 'A' || ch == 'E' ||
				ch == 'I' || ch == 'O' ||
				ch == 'U') && ch >= 65 && ch <= 90;
	}

	static int totalConsonants(String str)
	{
		int count = 0;
		for (int i = 0; i < str.length(); i++)
	
			if (isConsonant(str.charAt(i)))
				++count;
		return count;
	}
	
	public static void main(String args[])
	{
		String str = "abc de";
		System.out.println( totalConsonants(str));
	}
}

