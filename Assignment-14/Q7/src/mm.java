import java.util.*;
public class mm {
	ListNode head = null;

	class ListNode {
		int val;
		ListNode next;

		public ListNode(int val)
		{
			this.val = val;
			next = null;
		}
	}
	
	public int[] nextLargerLL(ListNode head)
	{
		int count = sizeOfLL(head);
		int[] ans = new int[count];
		int k = 0;
		ListNode j;
		int temp = 0;

		while (head != null) {
			if (head.next == null) {
				ans[k] = 0;
				break;
			}
			j = head.next;
			if (head.val < j.val) {
				ans[k] = j.val;
				k++;
			}
			else if (head.val
					>= j.val) { // if head.val is greater
								// than or equal to j.val
				while (
					j != null
					&& head.val
						>= j.val) { // search j.val such
									// that it is greater
									// than head.val
					j = j.next;
				}
				if (j != null) {
					ans[k] = j.val;
					k++;
				}
				else { // it means we have not found any
					ans[k] = 0;
					k++;
				}
			}
			else {
				ans[k] = 0;
				k++;
			}
			head = head.next;
		}
		return ans;
	}

	public void push(int new_data)
	{
		ListNode new_node = new ListNode(new_data);

		new_node.next = head;

		head = new_node;
	}

	public void printList()
	{
		System.out.println(Arrays.toString(nextLargerLL(head)));
	}
	
	public static void main(String[] args)
	{
		linkedList ll = new linkedList();

		ll.push(5);
		ll.push(0);
		ll.push(3);
		ll.push(1);
		ll.push(2);

		ll.nextLargerLL(ll.head);
		ll.printList();
	}

	public int sizeOfLL(ListNode head)
	{
		int count = 0;
		while (head != null) {
			count = count + 1;
			head = head.next;
		}
		return count;
	}
}
