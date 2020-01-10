abstract class Shape {

    String name;
    Shape (String name) {
        this.name = name;
    }
    //non abstract method
    public String definition() {
        return "I belong to a shape, Im inheriting class Shape.";
    }

    abstract String getAreaFormula();
    abstract double getArea();
    abstract double getNoOfSide();
}

class Square extends Shape {
    double side = 2.0;
    Square(final int s, final String n) {
        super(n);
        this.side = s;
    }
    String getAreaFormula(){
        return "side * side";
    }
    double getArea(){
        return side * side;
    }
    double getNoOfSide(){
        return 4;
    }
}
class Circle extends Shape {
    double radius;
    static double Pi = 3.14;
    Circle(final double r, final String n) {
        super(n);
        this.radius = r;
    }
    String getAreaFormula(){
        return "Pi * r * r";
    }
    double getArea(){
        return Pi * radius * radius;
    }
    double getNoOfSide(){
        return 0;
    }
}

class Rectangle extends Shape {
    double length;
    double breadth;
    Rectangle(final double len, final double brea, final String n) {
        super(n);
        this.length = len;
        this.breadth = brea;
    }
    String getAreaFormula(){
        return "length * breadth";
    }
    double getArea(){
        return length * breadth;
    }
    double getNoOfSide(){
        return 4;
    }
}
final class UtilityClass {
    public static void main(String[] args) {
        Square square =  new Square(4, "square");
        System.out.println();
        System.out.println("My name is : " + square.name);
        System.out.println("Area of square : " + square.getAreaFormula());
        System.out.println();
        Circle circle = new Circle(3, "Circle");
        System.out.println();
        System.out.println("My name is : " + circle.name);
        System.out.println("Area of circle" + circle.getAreaFormula());

    }
}