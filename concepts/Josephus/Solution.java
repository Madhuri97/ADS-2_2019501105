// import sun.misc.Queue;

class Solution{
	public static String Josephus(int a, int b){
		// fill you code Here
		String str = "";
		QueueG <Integer> queue = new QueueG<> ();
		//adding members into queue
		for(int i = 0; i < a; i++) {
			queue.enqueue(i);
		}
		//checking the index and key value if it is not equal then 
		//we will do dequeue and enqueued that element at last
		while(!queue.isEmpty()) {
		for(int i = 1; i < b; i++) {
			if(queue.size() == 1){
				break;
			}
			queue.enqueue(queue.dequeue());
		}
		str += queue.dequeue();
	}
	return str;
	}
}