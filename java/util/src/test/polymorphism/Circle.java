package test.polymorphism;

public class Circle extends AbstractShape {
    /**
     * 半径
     */
    private double radius = 0;
    private final static double PI = 3.14;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*PI*radius;
    }
}
