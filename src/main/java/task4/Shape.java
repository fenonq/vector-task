package task4;

public abstract class Shape implements Comparable<Shape> {

    public abstract double area();

    @Override
    public int compareTo(Shape o) {
        return (int)(Math.ceil(this.area() - o.area()));
    }

    @Override
    public String toString() {
        return String.valueOf(area());
    }

}
