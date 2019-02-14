package test.polymorphism;

public class client {
    public static void main(String[] args) {

////        new ThreadFactoryB
////        new ThreadPoolExecutor(5,200,OL,TimeUnit.MILLISECONDS,LinearConvolveKernel)
//
//        Runnable runnable1 = ()->{
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().getName()+" "+i);
//            }
//        };
//        Runnable runnable2 = ()->{
//            for (char i = 'a'; i < 'z'; i++) {
//                System.out.println(Thread.currentThread().getName()+" "+i);
//            }
//        };
//        pool.submit(runnable1);
//        pool.submit(runnable2);
//        pool.submit(runnable2);
//        pool.shutdown();

/*
int[] intArray = new int[]{1,56,-5,33};
Arrays.sort(new int[]{1,56,-5,33});
System.out.println(Arrays.toString(new int[]{1,56,-5,33}));

Double sumValue=0.0;
for (int i=0;i<new int[]{1,56,-5,33}.length;i++){
sumValue+=new int[]{1,56,-5,33}[i];
}
System.out.println(sumValue);
*/
        Circle circle = new Circle(0.3);

        ShapeCaculate shapeCaculate = new ShapeCaculate();
//        shapeCaculate.calPerimeter(circle);
        AbstractShape shape = new Rectangle(2, 5);
//        shapeCaculate.calArea(shape);
        Upload upload = new Upload();
        upload.sendPress(circle);
        upload.sendPush(shape);
    }


}
