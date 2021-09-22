package cn.jtruan.mallssm.service;

import cn.jtruan.mallssm.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OmsPortalOrderService {

    @Transactional
    Object generateOrder(OrderParam orderParam);

    @Transactional
    void cancelOrder(Long orderId);
}
