package com.polycube.backend.contoller;

import com.polycube.backend.application.PaymentService;
import com.polycube.backend.domain.member.Member;
import com.polycube.backend.domain.order.Order;
import com.polycube.backend.domain.payment.Payment;
import com.polycube.backend.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> process(@RequestBody PaymentRequest request) {
        // 1. DTO를 도메인 객체(Member, Order)로 변환
        Member member = new Member(request.memberId(), request.memberLevel());
        Order order = new Order(request.itemName(), request.itemPrice(), member);

        // 2. 서비스 호출
        Payment result = paymentService.processPayment(order, request.method());

        return ResponseEntity.ok(result);
    }
}