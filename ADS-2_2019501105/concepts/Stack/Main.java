public class Main {
    public static void main(String[] args) {
        StackG <Integer> sg = new StackG <Integer>();
        sg.push(20);
        sg.push(10);
        sg.push(11);
        // sg.pop();
        int a = sg.pop();
        int b = sg.pop();
        System.out.println(a);
        System.out.println(b);
    }
}