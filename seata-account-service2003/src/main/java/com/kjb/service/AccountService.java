package com.kjb.service;

import com.kjb.mapper.AccountMapper;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Param;

/**
 * @author kjb~
 * @version 1.0.0
 */
public interface AccountService {

   // 扣减余额
   void decrease(Long money, Long userId);

}
