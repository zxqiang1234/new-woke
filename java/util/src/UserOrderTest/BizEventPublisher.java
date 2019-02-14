package UserOrderTest;

public interface BizEventPublisher {
    void publishEvent(Object eventData);

    /**
     * 发布异步事件
     * @param eventData
     */
    void publishEventAsync(Object eventData);
}
