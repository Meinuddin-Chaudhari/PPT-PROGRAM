
import java.util.Vector;

class Test
{
	static int removeConsecutiveSame(Vector <String > v)
	{
		int n = v.size();
	
		for (int i=0; i<n-1; )
		{
			if (v.get(i).equals(v.get(i+1)))
			{
				v.remove(i);
				v.remove(i);
	
				if (i > 0)
					i--;
	
				n = n-2;
			}
	
			else
				i++;
		}
	
		return v.size();
	}
	
	public static void main(String[] args)
	{
		Vector<String> v = new Vector<>();

		v.addElement("tom"); v.addElement("jerry");
		v.addElement("jerry");v.addElement("tom");

		System.out.println(removeConsecutiveSame(v));
	}
}
