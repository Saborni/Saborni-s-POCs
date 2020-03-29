package xyz.lnews.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lnews.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
