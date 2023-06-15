class Node
{
    int data;
    Node next;
 
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
 
class mm
{
    static class NodeWrapper
    {
        public Node node;
 
        NodeWrapper(Node node) {
            this.node = node;
        }
    }
 
    public static Node push(Node head, int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }
 
    public static void printList(String msg, Node head)
    {
        System.out.print(msg + ": ");
        while (head != null)
        {
            System.out.print(head.data + " —> ");
            head = head.next;
        }
 
        System.out.println("null");
    }
 
    public static Node reverse(NodeWrapper curr, int k)
    {
        Node prev = null;
 
        while (curr.node != null && k-- > 0)
        {
            Node next = curr.node.next;
 
            curr.node.next = prev;
 
            prev = curr.node;
            curr.node = next;
        }
 
        return prev;
    }
 
    public static Node skipKNodes(NodeWrapper curr, int k)
    {
        Node prev = null;
 
        while (curr.node != null && k-- > 0)
        {
            prev = curr.node;
            curr.node = curr.node.next;
        }
 
        return prev;
    }
 
    public static Node reverseAlternatingKNodes(Node head, int k)
    {
        Node prev = null;
 
        NodeWrapper curr = new NodeWrapper(head);
 
        while (curr.node != null)
        {
            Node lastNode = curr.node;
 
            Node frontNode = reverse(curr, k);
 
            if (prev == null) {
                head = frontNode;
            }
            else {
                prev.next = frontNode;
            }
 
            lastNode.next = curr.node;
 
            prev = skipKNodes(curr, k);
        }
 
        return head;
    }
 
    public static void main(String[] args)
    {
        Node head = null;
 
        int n = 10;
        while (n > 0) {
            head = push(head, n--);
        }
 
        int k = 2;
 
        printList("Original linked list ", head);
        head = reverseAlternatingKNodes(head, k);
        printList("Resultant linked list", head);
    }
}