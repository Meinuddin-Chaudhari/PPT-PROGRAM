public class mm {
    public int trap(int[] A) {
        if(A==null||A.length==0) return 0;
        int n=A.length;
        int[] left=new int[n];
        int[] right=new int[n];
        int maxHeight=0;
        for(int i=0;i<n;i++){
            left[i]=maxHeight;
            maxHeight=Math.max(maxHeight,A[i]);
        }
        maxHeight=0;
        for(int i=n-1;i>=0;i--){
            right[i]=maxHeight;
            maxHeight=Math.max(maxHeight,A[i]);
        }
        int total=0;
        for(int i=0;i<n;i++){
            int height=Math.max(Math.min(left[i],right[i])-A[i],0);
            total +=height;
        }
        return total;
    }
}