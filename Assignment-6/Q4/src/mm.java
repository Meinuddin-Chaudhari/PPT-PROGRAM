
//	public static void main (String[] args) {  
//
//
//}  	
class mm{
public static String func(int arr[] , int st, int en)
    {
          if( st == en ){

              System.out.print( arr[ st ] );

              return;
          }
     
        int mid = (st+en)/2;

        System.out.print( arr[mid] );

        func(arr, st, mid - 1 );

        func( arr, mid + 1, en );
     
    }	

public static void main (String[] args) {  


}  	
}