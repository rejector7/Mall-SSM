package cn.jtruan.mallssm.dto;

import lombok.Getter;


@Getter
public enum QueueEnum {
    /**
     * 两个队列：消息延迟队列 & 消息队列
     *
     * 延迟队列中订单超时将会被转发至消息队列，进行取消订单操作。
     */
    QUEUE_ORDER_CANCEL("mall.order.direct", "mall.order.cancel", "mall.order.cancel"),
    QUEUE_ORDER_CANCEL_TTL("mall.order.direct.ttl", "mall.order.cancel.ttl", "mall.order.cancel.ttl");

    private String exchange;
    private String name;
    private String routeKey;

    /**
     *
     * @param exchange：交换机
     * @param name：队列名称
     * @param routeKey：路由键
     */
    QueueEnum(String exchange, String name, String routeKey) {
        this.exchange = exchange;
        this.name = name;
        this.routeKey = routeKey;
    }
}
