package test.mediationTest;

public class ClientTest {
    public static void main(String[] args) {

        //创建一个君主
        Monarch monarch = new HuangSan();

        //创建两个官员
        LaoJi laoJi = new LaoJi(monarch);
        HeEr heEr = new HeEr(monarch);

        //君主和两个官员建立关系
        monarch.addOfficial("laoji",laoJi);
        monarch.addOfficial("heEr",heEr);

        //有本奏上，无本退朝。
        laoJi.out();
        System.out.println("---------------启奏完毕");


        heEr.out();
        System.out.println("---------------启奏完毕");
    }
}
