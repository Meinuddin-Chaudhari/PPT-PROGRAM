class mm
{
    static int binarySearch(int[] a , int target)
    {
        int l = 0 , r = a.length - 1 , mid , ans = -1;
        while(l <= r)
        {
            mid = l + (r - l) / 2;
            if(a[mid] == target)
                return mid;
            if(a[mid] < target)
            {
                l = mid + 1;
                ans = mid + 1;
            }
            else
            {
                ans = mid;
                r = mid - 1;
            }
        }
        return ans;
    }
    static int searchInsert(int[] a , int target)
    {
        return binarySearch(a , target);
    }
    public static void main(String args[])
    {
        int a[] = {1 , 3 , 5 , 7 , 9} , target = 8;
        System.out.println(searchInsert(a , target));
    }
}