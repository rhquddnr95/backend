package com.polycube.backend.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 결제 이력 저장을 위한 리포지토리
 * JpaRepository를 상속
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // 기본 CRUD 외에 확장 가능
}