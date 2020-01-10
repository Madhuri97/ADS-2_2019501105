/**
 * @author Taheniyath
 */
class Solution{
	/**
	 * 
	 * @param  arr double arr[]
	 * @return arr
	 * This method finds the median of the elements in the array when every element is added.
	 * Here we are using both min heap and max heap for the implementation.
	 * Time complexity : O(n).
	 */
	public static double[] dynamicMedian(double[] arr){
		double median = 0;
		int n = arr.length;
		MaxPQ<Double>max = new MaxPQ();
		MinPQ<Double>min = new MinPQ();
		for(int i= 0;i<n;i++){
			if(arr[i]>median){
				min.insert(arr[i]);
			}else{
				max.insert(arr[i]);
			}
			if(min.size()>max.size()+1){
				max.insert(min.delMin());
			}
			if(max.size()>min.size()+1){
				min.insert(max.delMax());
			}
			if(min.size() == max.size()){
				median=(min.min()+max.max())/2;
			}else if(min.size()>max.size()){
				median = min.min();
			}else{
				median = max.max();
			}
			arr[i] = median;

		}
		return arr;
	}
}