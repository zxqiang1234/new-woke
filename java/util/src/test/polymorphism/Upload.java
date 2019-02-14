package test.polymorphism;

/**
 * @description: 上传工具类
 * @author: xuqiang
 * @createDate: 2018-09-19 10:00
 **/
public class Upload {

    public void sendPress(Circle circle){
        System.out.println("圆形");
    }

    public void  sendPress(Rectangle rectangle){
        System.out.println("长方形");
    }

    public  void  sendPush(AbstractShape shape){
        if (shape instanceof Circle){
            System.out.println("圆形");
        }
        if (shape instanceof  Rectangle){
            System.out.println("长方形");
        }
    }
}
