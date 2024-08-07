package com.kjb;

import com.kjb.entities.PayDTO;
import com.kjb.service.PayService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kjb~
 * @version 1.0.0
 */

@SpringBootTest
public class Test01 {

    @Resource
    PayService payService;

    @Test
    public void test001() {
        System.out.println("=======================================");
        PayDTO byId = payService.getById(1);
        System.out.println(byId.toString());
        System.out.println("=======================================");

    }
}
