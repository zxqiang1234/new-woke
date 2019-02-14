package test.tunnel;

/**
 * Created by xuqiang on 2018-04-20.
 */
public class Girl implements  Factory{
    @Override
    public void add() {
        System.out.println("新增");
    }

    @Override
    public void uodate() {
        System.out.println("修改");

    }

    @Override
    public void delect() {
        this.add();
        System.out.println("删除");
    }


}
