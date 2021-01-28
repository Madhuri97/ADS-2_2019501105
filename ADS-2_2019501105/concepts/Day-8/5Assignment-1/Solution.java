/**
 * @author Taheniyath
 * used to find wheather the given array is in min heap or not.
 */
class Solution{
	/**
	 * 
	 * @param double[] arr
	 * @return boolean
	 * finds out wheather the given array is in min heap or not.
	 * if yes return true else return false.
	 * Time complexity is : O(n)
	 */
	
	public static boolean isMinHeap(double[] arr){
		int n = arr.length;
		if(n==0){
			return false;
		}
		for(int i=n-1 ; i>=1 ; i--){
			if(arr[i]<arr[i/2]){
				return false;
			}
		}
		return true;  
	}
}