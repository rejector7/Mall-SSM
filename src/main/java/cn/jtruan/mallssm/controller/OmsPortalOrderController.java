package cn.jtruan.mallssm.controller;

import cn.jtruan.mallssm.common.api.CommonResult;
import cn.jtruan.mallssm.dto.OrderParam;
import cn.jtruan.mallssm.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前台订单接口，区别于后台管理订单接口
 */
@Controller
@RequestMapping("/order")
@ResponseBody
public class OmsPortalOrderController {
    private static Logger LOGGER = LoggerFactory.getLogger(OmsPortalOrderController.class);

    @Autowired
    private OmsPortalOrderService omsPortalOrderService;

    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    public CommonResult generateOrder(@RequestBody OrderParam orderParam){
        Object o = omsPortalOrderService.generateOrder(orderParam);
        return CommonResult.success(null, "下单成功！");
    }

}
