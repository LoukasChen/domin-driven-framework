package com.csp.client;

import com.csp.client.model.req.CreateOrderReqDTO;
import com.csp.client.model.InvokeInfoDTO;
import com.csp.client.model.res.CreateOrderResDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @desc: HSF Api 接口
 * @author: csp
 * @date: 2024/6/23
 */
public interface OrderService {

    @NotNull CreateOrderResDTO createOrder(
            @NotNull @Valid CreateOrderReqDTO reqDTO,
            @NotNull @Valid InvokeInfoDTO invokeInfoDTO
    );

}
