package com.kjb.controller;

import com.kjb.retutnformat.ReturnData;
import com.kjb.service.AccountService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public ReturnData decrease(Long money, Long userId) {
        accountService.decrease(money, userId);
        return ReturnData.success("AccountController成功扣减余额");
    }
}
