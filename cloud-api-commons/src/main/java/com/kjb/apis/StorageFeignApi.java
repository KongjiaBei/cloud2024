package com.kjb.apis;

import com.kjb.retutnformat.ReturnData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kjb~
 * @version 1.0.0
 */

@FeignClient("seata-storage-service")
public interface StorageFeignApi {

    /**
     * 扣减库存
     */
    @PostMapping("/storage/decrease")
    ReturnData decrease(@RequestParam("productId") Long productId,
                        @RequestParam("count") Integer count);
}
