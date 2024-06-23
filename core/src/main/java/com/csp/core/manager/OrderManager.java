package com.csp.core.manager;

import com.csp.common.enums.ProductEnum;
import com.csp.common.enums.SolutionEnum;
import com.csp.core.context.CreateOrderContext;
import com.csp.core.process.CreateOrderProcess;
import com.csp.core.template.ManagerCallback;
import com.csp.core.template.ManagerTemplate;
import com.csp.core.utils.ProcessUtils;
import com.csp.domain.model.req.CreateOrderReqBO;
import com.csp.domain.model.res.CreateOrderResBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Component
@RequiredArgsConstructor
public class OrderManager {

    private final ManagerTemplate managerTemplate;

    public CreateOrderResBO createOrder(CreateOrderReqBO reqBO) {
        return managerTemplate.execute(new ManagerCallback<CreateOrderReqBO, CreateOrderResBO, CreateOrderContext>() {

            @Override
            public CreateOrderContext buildContext() {
                return CreateOrderContext.builder().request(reqBO).build();
            }

            @Override
            public void initSessionContext(CreateOrderContext ctx) {
                //
            }

            @Override
            public boolean checkIdempotent(CreateOrderContext ctx) {
                return false;
            }

            @Override
            public List<ProductEnum> decideProducts(CreateOrderContext ctx) {
                return List.of();
            }

            @Override
            public SolutionEnum decideSolution(CreateOrderContext ctx) {
                return null;
            }

            @Override
            public CreateOrderResBO execute(CreateOrderContext ctx) {
                return ProcessUtils.getProcess(CreateOrderProcess.class).execute(ctx);
            }
        });
    }

}
