package test.polymorphism;

public class ShapeCaculate {
    public void calArea (AbstractShape shape) {
        System.out.println(shape.getArea());
    }

    /**
     * 可以计算任意shape子类的周长
     */

    public void calPerimeter(AbstractShape shape) {
        System.out.println(shape.getPerimeter());
    }

}
