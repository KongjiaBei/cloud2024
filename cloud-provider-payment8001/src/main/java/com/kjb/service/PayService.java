package com.kjb.service;

import com.kjb.entities.Pay;
import com.kjb.entities.PayDTO;

import java.util.List;

/**
 * @author kjb~
 * @version 1.0.0
 */


public interface PayService {

    String add(Pay pay);

    String delete(Integer id);

    String update(Pay pay);

    PayDTO getById(Integer id);

    List<PayDTO> getAll();

}
