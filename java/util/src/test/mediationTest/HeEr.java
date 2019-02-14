package test.mediationTest;

/**
 * 官员何二
 */
public class HeEr extends  Official{
    /**
     * 每个官员必然要与君主有联系
     *
     * @param monarch
     */

    public HeEr(Monarch monarch) {
        super(monarch);
    }
    /**
     * 做好本职工作
     */
    public void self(){
        System.out.println("启奏皇上，臣和二掌管的秀女选拔工作已经完成。");
    }

    /**
     * 参其他官员或与其他官员合作
     */
    public void out(){
        System.out.println("启奏皇上，臣和二要参老纪一本，四库全书到目前还没编写完成，理应问斩。");
        super.monarch.execute("laoji","self");
    }
}
