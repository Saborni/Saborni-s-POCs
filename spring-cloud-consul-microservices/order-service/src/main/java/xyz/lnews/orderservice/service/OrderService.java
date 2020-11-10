package xyz.lnews.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import xyz.lnews.orderservice.common.Payment;
import xyz.lnews.orderservice.common.TxResponse;
import xyz.lnews.orderservice.entity.Order;
import xyz.lnews.orderservice.repository.OrderRepository;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Optional<URI> serviceUrl(String service) {
        return discoveryClient.getInstances(service)
                .stream()
                .findFirst()
                .map(si -> si.getUri());
    }

    public TxResponse placeOrder(Order order) throws ServiceUnavailableException{
        repository.save(order);
        Payment paymentReq = new Payment();
        paymentReq.setOrderId(order.getId());
        paymentReq.setAmount(order.getQuantity() * order.getPrice());

        /*//URI url = serviceUrl("payment-service");
        URI url= discoveryClient.getInstances("payment-service").stream()
                .map(a->a.getUri()).findFirst()
                .map(s->s.resolve("/payment/doPay/")).get();
        "http://payment-service/payment/doPay/" */

        URI url = serviceUrl("payment-service")
                .map(s -> s.resolve("/payment/doPay/"))
                .orElseThrow(ServiceUnavailableException::new);
        Payment paymentRes = template.postForObject(url,
                        paymentReq, Payment.class);
        TxResponse txResponse = new TxResponse();
        txResponse.setOrder(order);
        txResponse.setStatus(paymentRes.getPaymentStatus());
        txResponse.setAmount(paymentRes.getAmount());
        txResponse.setTxId(paymentRes.getTxId());
        return txResponse;
    }
}
