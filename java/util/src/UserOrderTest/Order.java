package UserOrderTest;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2019-01-31 11:27
 **/
public class Order {
    private long orderId;
    private long userId;
    public Order(long orderId, long userId) {
        this.setOrderId(orderId);
        this.setUserId(userId);
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
