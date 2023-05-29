


public int[] sortedSquares(int[] A) {
    int n = A.length;
    int[] res = new int[n];
    int index = n - 1;
    int l = 0, r = n - 1;
    while (l <= r) {
        if (Math.abs(A[l]) < Math.abs(A[r])) {
            res[index--] = A[r] * A[r];
            r--;
        } else {
            res[index--] = A[l] * A[l];
            l++;
        }
    }
    return res;
}


//O(N)time
//O(1)space
public int[] sortedSquares(int[] A) {
 int n = A.length;
 int small = 0;
 for (int i = 0; i < n; i++) {
     if (Math.abs(A[i]) < Math.abs(A[small])) {
         small = i;
     }
 }
 int[] res = new int[n];
 int index = 0;
 int l = small, r = small + 1;
 while (l >= 0 || r < n) {
     if (l < 0 || r < n && Math.abs(A[l]) > Math.abs(A[r])) {
         res[index++] = A[r] * A[r];
         r++;
     } else {
         res[index++] = A[l] * A[l];
         l--;
     }
 }
 return res;
}



//O(N*logN)time
//O(1)space
public int[] sortedSquares(int[] A) {
  int[] res = new int[A.length];
  for(int i = 0; i < A.length; i++){
      res[i] = A[i] * A[i];
  }
  Arrays.sort(res);
  return res;
}