package com.kjb.mapper;

import com.kjb.entities.Storage;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

public interface StorageMapper extends Mapper<Storage> {

    // 扣减库存
    public void decrease(@Param("productId") Long productId,
                         @Param("count") Integer count);

}