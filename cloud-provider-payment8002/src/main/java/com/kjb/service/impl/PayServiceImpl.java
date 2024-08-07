package com.kjb.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.kjb.entities.Pay;
import com.kjb.entities.PayDTO;
import com.kjb.mapper.PayMapper;
import com.kjb.service.PayService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kjb~
 * @version 1.0.0
 */
@Service
public class PayServiceImpl implements PayService {

    @Resource
    private PayMapper payMapper;

    @Override
    public String add(Pay pay) {
        int insert = payMapper.insert(pay);
        return "添加成功,id：" + insert;
    }

    @Override
    public String delete(Integer id) {
        int i = payMapper.deleteByPrimaryKey(id);
        return "删除成功:" + i;
    }

    @Override
    public String update(Pay pay) {
        int i = payMapper.updateByPrimaryKey(pay);
        return "修改成功" + i;
    }

    @Override
    public PayDTO getById(Integer id) {
        Pay pay = payMapper.selectByPrimaryKey(id);
        PayDTO payDTO = new PayDTO();
        BeanUtil.copyProperties(pay,payDTO);
        return payDTO;
    }

    @Override
    public List<PayDTO> getAll() {
        List<Pay> list = payMapper.selectAll();
        ArrayList<PayDTO> payDTOS = new ArrayList<>();
        for (Pay pay : list) {
            PayDTO payDTO = new PayDTO();
            BeanUtil.copyProperties(pay,payDTO);
            payDTOS.add(payDTO);
        }
        return payDTOS;
    }


}
