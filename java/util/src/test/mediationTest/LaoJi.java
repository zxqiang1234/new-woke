package test.mediationTest;

/**
 * 官员老纪
 */
public class LaoJi extends Official{
    /**
            * 每个官员必然要与君主有联系
     *
             * @param monarch
     */
    public LaoJi(Monarch monarch) {
        super(monarch);
    }

    /**
     * 做好本职工作
     */
    public void self(){
        System.out.println("启奏皇上，臣老纪参与编写的四库全书已经完成。");
    }

    /**
     * 参其他官员或与其他官员合作
     */
    public void out(){
        System.out.println("启奏皇上，臣老纪要参和二一本，秀女选拔工作到现在还没完成，理应当革职查办。");
        super.monarch.execute("heEr","self");
    }
}
