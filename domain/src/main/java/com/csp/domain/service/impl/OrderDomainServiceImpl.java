package com.csp.domain.service.impl;

import com.csp.domain.product.CreateOrderProductScheme;
import com.csp.domain.service.OrderDomainService;
import com.csp.domain.utils.ProductUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Component
public class OrderDomainServiceImpl implements OrderDomainService {

    @Override
    public void assemblyCreateOrder() {
        ProductUtils.run(
                List.of(),
                CreateOrderProductScheme.class,
                CreateOrderProductScheme::assemblyCreateOrder
        );
    }
}
