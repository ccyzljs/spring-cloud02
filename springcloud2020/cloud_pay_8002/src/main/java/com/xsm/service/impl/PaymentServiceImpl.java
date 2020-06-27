package com.xsm.service.impl;

import com.xsm.model.Payment;
import org.springframework.stereotype.Service;
import com.xsm.dao.PaymentDao;
import com.xsm.service.PaymentService;

import javax.annotation.Resource;

/**
 * Created by xushuming
 * Created Date 2020/6/14
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment selectPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }
}
