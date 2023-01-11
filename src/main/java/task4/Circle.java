package task4;

public class Circle extends Shape {

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return radius * radius * Math.PI;
    }

}
