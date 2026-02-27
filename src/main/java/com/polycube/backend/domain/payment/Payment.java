package com.polycube.backend.domain.payment;

import com.polycube.backend.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private int originalPrice;
    private int discountAmount;
    private int finalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method;

    @Builder
    public Payment(String itemName, int originalPrice, int discountAmount, PaymentMethod method) {
        this.itemName = itemName;
        this.originalPrice = originalPrice;
        this.discountAmount = discountAmount;
        this.finalPrice = originalPrice - discountAmount;
        this.method = method;
    }
}