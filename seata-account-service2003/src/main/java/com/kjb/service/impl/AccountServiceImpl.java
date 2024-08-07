package com.kjb.service.impl;

import com.kjb.mapper.AccountMapper;
import com.kjb.service.AccountService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author kjb~
 * @version 1.0.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;
    @Override
    public void decrease(Long money, Long userId) {
        log.info("AccountServiceImpl开始扣减余额");
        accountMapper.decrease(money,userId);

        //模拟事故
        myTimeOut();
//        int i = 10 / 0;
        log.info("AccountServiceImpl结束扣减余额");
    }

    private void myTimeOut() {
        try {
//            TimeUnit.SECONDS.sleep(65);
            Thread.sleep(65 * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
