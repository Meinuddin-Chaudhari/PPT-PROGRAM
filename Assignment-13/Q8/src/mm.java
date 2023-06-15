class Node
{
	int data;
	Node next, prev;
}

class GFG
{
	static Node head = null;
	static Node deleteNode(Node del)
	{
		if (head == null || del == null)
			return null;

		if (head == del)
			head = del.next;

		if (del.next != null)
			del.next.prev = del.prev;

		if (del.prev != null)
			del.prev.next = del.next;

		del = null;

		return head;
	}

	static void deleteNodeAtGivenPos(int n)
	{
		if (head == null || n <= 0)
			return;

		Node current = head;
		int i;

		for (i = 1; current != null && i < n; i++)
		{
			current = current.next;
		}
		
		if (current == null)
			return;

		deleteNode(current);
	}

	static void push(int new_data)
	{
		Node new_node = new Node();

		new_node.data = new_data;


		new_node.prev = null;

		new_node.next = head;

		if (head != null)
			head.prev = new_node;

		head = new_node;
	}

	static void printList()
	{
		Node temp = head;
		if (temp == null)
			System.out.print("Doubly Linked list empty");

		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args)
	{

		push(5);
		push(2);
		push(4);
		push(8);
		push(10);

		System.out.println("Doubly linked "
						+"list before deletion:");
		printList();

		int n = 2;
		
		deleteNodeAtGivenPos(n);
		System.out.println("Doubly linked "
						+"list after deletion:");
		printList();
	}
}

