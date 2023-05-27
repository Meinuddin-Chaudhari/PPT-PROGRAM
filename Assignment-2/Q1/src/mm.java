import java.util.Arrays;


public class mm {
    /*
        Solution: First sort the input array, then pair up elements next to each other that way we dont
        loose much to Math.min() between pair  
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0 ; i < nums.length-1; i= i+2){
            sum = sum+ Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }
}