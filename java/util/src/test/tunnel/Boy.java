package test.tunnel;

import com.sun.istack.internal.NotNull;

/**
 * Created by xuqiang on 2018-04-04.
 */
public class Boy implements Factory {
    @NotNull
    private String sex;

    private  String name;

    public Boy() {
    }

    @Override
    public void add() {
        System.out.println("新增");

    }

    @Override
    public void uodate() {
        System.out.println("删除");
    }

    @Override
    public void delect() {
        System.out.println("修改");

    }

    public static void main(String[] args){
        Boy boy=new Boy();
        boy.add();
        System.out.println(boy.sex);
    }


}
