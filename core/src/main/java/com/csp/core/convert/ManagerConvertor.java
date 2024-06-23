package com.csp.core.convert;

import com.csp.client.model.req.CreateOrderReqDTO;
import com.csp.client.model.res.CreateOrderResDTO;
import com.csp.domain.model.req.CreateOrderReqBO;
import com.csp.domain.model.res.CreateOrderResBO;
import org.mapstruct.Mapper;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Mapper(componentModel = "spring")
public interface ManagerConvertor {

    CreateOrderReqBO convert(CreateOrderReqDTO reqDTO);

    CreateOrderResDTO convert(CreateOrderResBO resBO);
}
