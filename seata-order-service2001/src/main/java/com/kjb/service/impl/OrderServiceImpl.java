package com.kjb.service.impl;

import com.kjb.apis.AccountFeignApi;
import com.kjb.apis.StorageFeignApi;
import com.kjb.entities.Order;
import com.kjb.mapper.OrderMapper;
import com.kjb.service.OrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author kjb~
 * @version 1.0.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name = "kjb-create-order", rollbackFor = Exception.class)
    public void create(Order order) {

        // 事务id
        String xid = RootContext.getXID();
        // 开始
        System.out.println("====开始====");
        order.setStatus(0);
        int i = orderMapper.insertSelective(order);

        if (i > 0) {  // 说明插入成功
            //  查询刚插入记录的主键id
            Order selectOne = orderMapper.selectOne(order);
            // 扣减库存
            storageFeignApi.decrease(selectOne.getProductId(), selectOne.getCount());

            // 扣减金额
            accountFeignApi.decrease(selectOne.getUserId(),selectOne.getMoney());

            //设置状态
            Long id = selectOne.getId();
            selectOne.setStatus(1);

            Example example = new Example(Order.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",selectOne.getId());
            criteria.andEqualTo("status",0);


            int i1 = orderMapper.updateByExampleSelective(selectOne, example);

            if (i1 > 0) {
                log.info("status为： 1");
                System.out.println("修改成功");
            }

            System.out.println("====结束====,xid: "+ xid);

        }

    }
}
