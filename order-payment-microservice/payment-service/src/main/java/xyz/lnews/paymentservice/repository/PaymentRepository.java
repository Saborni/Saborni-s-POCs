package xyz.lnews.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.lnews.paymentservice.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
