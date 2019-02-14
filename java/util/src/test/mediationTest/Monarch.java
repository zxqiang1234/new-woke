package test.mediationTest;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 君王
 */
public abstract  class Monarch {

    protected ConcurrentHashMap<String,Official> officials = new ConcurrentHashMap<>();

    public abstract void execute(String name,String method);

    /**
     * 录用官员
     * @param name
     * @param official
     */
    public void addOfficial(String name,Official official){
        this.officials.put(name,official);
    }

    /**
     * 将官员革职查办
     * @param name
     */
    public void removeOfficial(String name){
        this.officials.remove(name);
    }
}
