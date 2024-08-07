package com.kjb.service.impl;

import com.kjb.entities.Storage;
import com.kjb.mapper.StorageMapper;
import com.kjb.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author kjb~
 * @version 1.0.0
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService{

    @Resource
    private StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("开始扣库存");
        storageMapper.decrease(productId,count);
        log.info("结束扣库存");
    }
}
