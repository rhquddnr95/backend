package com.polycube.backend.dto;

import com.polycube.backend.domain.member.Level;
import com.polycube.backend.domain.payment.PaymentMethod;

/**
 * 결제 요청을 받기 위한 DTO
 */
public record PaymentRequest(
        String itemName,
        int itemPrice,
        Long memberId,
        Level memberLevel,
        PaymentMethod method
) {}