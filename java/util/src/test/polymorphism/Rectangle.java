package test.polymorphism;

public class Rectangle  extends AbstractShape {
    /**
     * 长
     */
    private double lenght=0;

    private double width=0;

    public Rectangle(double lenght, double width) {
        this.lenght = lenght;
        this.width = width;
    }

    @Override
    public double getArea() {
        return lenght*width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (lenght + width);
    }
}
