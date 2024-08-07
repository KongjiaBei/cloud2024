package com.kjb.controller;

import cn.hutool.core.bean.BeanUtil;
import com.kjb.entities.Pay;
import com.kjb.entities.PayDTO;
import com.kjb.mapper.PayMapper;
import com.kjb.retutnformat.ReturnData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kjb~
 * @version 1.0.0
 */

@RestController
@Tag(name = "支付模块", description = "支付的CRUD")
public class PayController {

    @Resource
    PayMapper payMapper;

    @Operation(summary = "新增", description = "新增支付记录的方法")
    @PostMapping("/pay/add")
    public ReturnData<String> add(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        int insert = payMapper.insertSelective(pay);
        return ReturnData.success("添加了" + insert + "条记录");
    }

    @Operation(summary = "删除", description = "删除支付记录的方法")
    @DeleteMapping("/pay/delete/{id}")
    public ReturnData<String> deleteById(@PathVariable("id") Integer id) {
        int i = payMapper.deleteByPrimaryKey(id);
        return ReturnData.success("删除了" + i + "条记录");
    }

    @Operation(summary = "修改", description = "修改支付记录的方法")
    @PutMapping("/pay/update")
    public ReturnData<String> update(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtil.copyProperties(payDTO, pay);
        int i = payMapper.updateByPrimaryKeySelective(pay);
        return ReturnData.success("修改了" + i + "条记录");
    }

    @Operation(summary = "查询", description = "查询支付记录的方法")
    @GetMapping("/pay/get/{id}")
    public ReturnData<PayDTO> getById(@PathVariable("id") Integer id)  {
        Pay pay = payMapper.selectByPrimaryKey(id);
        PayDTO payDTO = new PayDTO();
        BeanUtil.copyProperties(pay,payDTO);
        return ReturnData.success(payDTO);
    }



    @Operation(summary = "查询全部", description = "查询全部支付记录的方法")
    @GetMapping("/pay/getall")
    public ReturnData<List<PayDTO>> getAll() {
        List<Pay> list = payMapper.selectAll();
        List<PayDTO> payDTOS = new ArrayList<>();
        for (Pay pay : list) {
            PayDTO payDTO = new PayDTO();
            BeanUtil.copyProperties(pay,payDTO);
            payDTOS.add(payDTO);
        }
        return ReturnData.success(payDTOS);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/get/info")
    public ReturnData<String> getInfo(@Value("${kjb.info}") String info) {
        return ReturnData.success(info + "--" + port);
    }

}
