package xyz.lnews.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.lnews.orderservice.common.TxResponse;
import xyz.lnews.orderservice.entity.Order;
import xyz.lnews.orderservice.service.OrderService;

import javax.naming.ServiceUnavailableException;

@RestController
@RequestMapping("/order/")
public class OrderServiceController {

    @Autowired
    private OrderService service;

    @PostMapping("/placeOrder")
    public TxResponse placeOrder(@RequestBody Order order) throws ServiceUnavailableException{
        return service.placeOrder(order);
    }

    @ExceptionHandler({ ServiceUnavailableException.class })
    public String handleException() {
        return "ServiceUnavailableException!";
    }
}
