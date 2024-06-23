package com.csp.service;

import com.csp.client.OrderService;
import com.csp.client.model.InvokeInfoDTO;
import com.csp.client.model.req.CreateOrderReqDTO;
import com.csp.client.model.res.CreateOrderResDTO;
import com.csp.core.convert.ManagerConvertor;
import com.csp.core.manager.OrderManager;
import com.csp.domain.model.req.CreateOrderReqBO;
import com.csp.domain.model.res.CreateOrderResBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Validated
@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderManager orderManager;

    private final ManagerConvertor managerConvertor;

    @Override
    public CreateOrderResDTO createOrder(CreateOrderReqDTO reqDTO, InvokeInfoDTO invokeInfoDTO) {
        CreateOrderReqBO reqBO = managerConvertor.convert(reqDTO);
        CreateOrderResBO resBO = orderManager.createOrder(reqBO);
        return managerConvertor.convert(resBO);
    }

}
