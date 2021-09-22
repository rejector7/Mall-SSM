package cn.jtruan.mallssm.config;

import cn.jtruan.mallssm.dto.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 进行消息队列的配置
 * 主要工作有：
 * 设置交换机
 * 绑定队列和交换机
 *
 * 整个配置中存在两个交换机，两个队列
 * 交换机之间可以互相转发
 *
 * 交换机可以绑定多个队列，但是这里每个交换机只绑定了一个队列。
 *
 * 所以这里并不是利用单个交换机，根据不同的路由键分别转发到两个队列，而是各自绑定，从一个交换机转发到另一个交换机。
 */
@Configuration
public class RabbitConfig {

    /**
     * 订单实际取消队列绑定的交换机
     * @return
     */
    @Bean("orderExchange")
    DirectExchange orderExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_ORDER_CANCEL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 订单延迟消息队列绑定的交换机
     */
    @Bean("orderTtlExchange")
    DirectExchange orderTtlExchange(){
        return (DirectExchange) ExchangeBuilder.directExchange(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getExchange())
                .durable(true)
                .build();
    }

    /**
     * 实际订单取消队列
     * @return
     */
    @Bean
    public Queue orderQueue(){
        return new Queue(QueueEnum.QUEUE_ORDER_CANCEL.getName());
    }

    @Bean
    public Queue orderTtlQueue(){
        return QueueBuilder
                .durable(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getName())
                .withArgument("x-dead-letter-exchange", QueueEnum.QUEUE_ORDER_CANCEL.getExchange())//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey())//到期后转发的路由键
                .build();
    }

    /**
     * 通过路由键，将队列绑定到交换机上
     * @param directExchange
     * @param
     * @return
     */
    @Bean
    Binding orderBinding(@Qualifier("orderExchange") DirectExchange directExchange, Queue orderQueue){
        return BindingBuilder
                .bind(orderQueue)
                .to(directExchange)
                .with(QueueEnum.QUEUE_ORDER_CANCEL.getRouteKey());
    }

    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlExchange, Queue orderTtlQueue){
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlExchange)
                .with(QueueEnum.QUEUE_ORDER_CANCEL_TTL.getRouteKey());
    }



}
