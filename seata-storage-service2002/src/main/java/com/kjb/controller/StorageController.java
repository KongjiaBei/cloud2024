package com.kjb.controller;

import com.kjb.mapper.StorageMapper;
import com.kjb.retutnformat.ReturnData;
import com.kjb.service.StorageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kjb~
 * @version 1.0.0
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public ReturnData decrease(Long productId, Integer count) {
        storageService.decrease(productId,count);
        return ReturnData.success("扣减库存成功");
    }
}
