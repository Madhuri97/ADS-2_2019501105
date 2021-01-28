public class QMain {
    public static void main(String[] args) {
        QueueG <Integer> qg = new QueueG <Integer>();
        qg.Enqueue(20);
        qg.Enqueue(10);
        qg.Enqueue(11);
        int a = qg.Dequeue();
        int b = qg.Dequeue();
        System.out.println(a);
        System.out.println(b);
    } 
}