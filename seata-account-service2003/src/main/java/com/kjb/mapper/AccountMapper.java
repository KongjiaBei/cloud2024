package com.kjb.mapper;

import com.kjb.entities.Account;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface AccountMapper extends Mapper<Account> {

    // 扣减余额
    public void decrease(@Param("money") Long money,
                         @Param("userId") Long userId);
}