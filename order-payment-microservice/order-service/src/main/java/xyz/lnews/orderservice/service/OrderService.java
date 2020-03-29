package xyz.lnews.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.lnews.orderservice.common.Payment;
import xyz.lnews.orderservice.common.TxResponse;
import xyz.lnews.orderservice.entity.Order;
import xyz.lnews.orderservice.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TxResponse placeOrder(Order order){
        repository.save(order);
        Payment paymentReq = new Payment();
        paymentReq.setOrderId(order.getId());
        paymentReq.setAmount(order.getQuantity()*order.getPrice());
        Payment paymentRes =
                template.postForObject("http://localhost:61115/payment/doPay/",
                paymentReq, Payment.class);
        TxResponse txResponse = new TxResponse();
        txResponse.setOrder(order);
        txResponse.setStatus(paymentRes.getPaymentStatus());
        txResponse.setAmount(paymentRes.getAmount());
        txResponse.setTxId(paymentRes.getTxId());
        return txResponse;
    }
}
