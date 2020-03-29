package xyz.lnews.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.lnews.orderservice.common.TxResponse;
import xyz.lnews.orderservice.entity.Order;
import xyz.lnews.orderservice.service.OrderService;

@RestController
@RequestMapping("/order/")
public class OrderServiceController {

    @Autowired
    private OrderService service;

    @PostMapping("/placeOrder/")
    public TxResponse placeOrder(@RequestBody Order order){
        return service.placeOrder(order);
    }
}
