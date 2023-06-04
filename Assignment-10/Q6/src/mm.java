class mm
{
    public static void move(int disks, int source, int auxiliary, int target)
    {
        if (disks > 0)
        {
            move(disks - 1, source, target, auxiliary);
 
            System.out.println("Move disk " + disks + " from " + source + " —> " +
                                target);
 
            move(disks - 1, auxiliary, source, target);
        }
    }
 
    public static void main(String[] args)
    {
        int n = 3;
        move(n, 1, 2, 3);
    }
}