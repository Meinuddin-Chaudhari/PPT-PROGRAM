int size(Node *h)
{
    int c=0;
    while(h) { c++; h=h->next;} return c; }


int getNthFromLast(Node *head, int n)
{
      int l=size(head);
      if(n>l) return -1;
      int k=l-n;
      while(k--)
      {
          head=head->next;
      }
      return head->data;
}