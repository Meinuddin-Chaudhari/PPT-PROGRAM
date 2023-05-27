class mm {
  public static void main(String[] args) {
    int[] input = {1, 2, 2, 3};
    System.out.println(isMonotonic(input)); // true
  }

  public static boolean isMonotonic(int[] array) {
    boolean isIncreasing = true;
    boolean isDecreasing = true;

    for (int i = 1; i < array.length; i++) {
      if (array[i] < array[i - 1]) {
        isDecreasing = false;
      }

      if (array[i] > array[i - 1]) {
        isIncreasing = false;
      }
    }

    return isIncreasing || isDecreasing;
  }
}