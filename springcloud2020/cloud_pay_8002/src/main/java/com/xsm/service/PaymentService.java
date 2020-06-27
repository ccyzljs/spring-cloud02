package com.xsm.service;

import com.xsm.model.Payment;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */
public interface PaymentService {

    Payment selectPaymentById(Long id);

    int create(Payment payment);

}
