
class mm {

	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	void rotate(int k)
	{
		if (k == 0)
			return;

		Node head = null;
		Node current = head;

		int count = 1;
		while (count < k && current != null) {
			current = current.next;
			count++;
		}

		if (current == null)
			return;

		Node kthNode = current;

		while (current.next != null)
			current = current.next;


		current.next = head;

		head = kthNode.next;

		kthNode.next = null;
	}

	void push(int new_data)
	{

		Object head;
		Object new_node;
		new_node.next = head;

		head = new_node;
	}

	void printList()
	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[])
	{
		LinkedList llist = new LinkedList();

		for (int i = 60; i >= 10; i -= 10)
			llist.push(i);

		System.out.println("Given list");
		llist.printList();

		llist.rotate(4);

		System.out.println("Rotated Linked List");
		llist.printList();
	}
} 
