package test.mediationTest;

public class HuangSan extends Monarch{
    @Override
    public void execute(String name, String method) {
        if("self".equals(method)){
            if("laoji".equals(name)){
                ((LaoJi)super.officials.get(name)).self();
            }else {
                ((HeEr)super.officials.get(name)).self();
            }
        }else {
            if("laoji".equals(name)){
                ((LaoJi)super.officials.get(name)).out();
            }else {
                ((LaoJi)super.officials.get(name)).out();
            }
        }
    }
}
