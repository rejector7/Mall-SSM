package cn.jtruan.mallssm.service.impl;

import cn.jtruan.mallssm.component.CancelOrderSender;
import cn.jtruan.mallssm.dto.OrderParam;
import cn.jtruan.mallssm.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OmsPortalOrderServiceImpl implements OmsPortalOrderService {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);

    @Autowired
    private CancelOrderSender cancelOrderSender;

    @Override
    public Object generateOrder(OrderParam orderParam) {
        LOGGER.info("process generateOrder");
        //下单完成后开启一个延迟消息，用于当用户没有付款时取消订单（orderId应该在下单后生成）
        sendDelayMessageCancelOrder(11L);
        return null;
    }

    @Override
    public void cancelOrder(Long orderId) {
        LOGGER.info("process cancelOrder orderId:{}",orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId){
        long delayTime =30 * 1000;
        cancelOrderSender.sendMessage(orderId, delayTime);
    }
}
