package com.csp.domain.product;

import com.csp.common.enums.ProductEnum;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Component
public class CreateOrderDefaultProductSchemeImpl implements CreateOrderProductScheme {

    @Override
    public ProductEnum product() {
        return null;
    }

    @Override
    public void assemblyCreateOrder() {

    }
}
