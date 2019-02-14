package test.orderTest;

public class CoffeeOrder implements Order {
    /**
     * 咖啡口味
     */
    public String flavor;

    public CoffeeOrder(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public void sell() {
        System.out.println("卖出的咖啡口味是"+flavor);
    }
}
