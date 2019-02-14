package test.mediationTest;

/**
 * 大臣
 */
public class Official {
    protected Monarch monarch;

    public Official(Monarch monarch) {
        this.monarch = monarch;
    }

    public Monarch getMonarch() {
        return monarch;
    }

    public void setMonarch(Monarch monarch) {
        this.monarch = monarch;
    }
}
