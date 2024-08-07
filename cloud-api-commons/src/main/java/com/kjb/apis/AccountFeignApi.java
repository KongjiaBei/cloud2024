package com.kjb.apis;

import com.kjb.retutnformat.ReturnData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kjb~
 * @version 1.0.0
 */
@FeignClient("seata-account-service")
public interface AccountFeignApi {

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     * @return
     */
    @PostMapping("/account/decrease")
    ReturnData decrease(@RequestParam("userId") Long userId,
                        @RequestParam("money") Long money);
}
