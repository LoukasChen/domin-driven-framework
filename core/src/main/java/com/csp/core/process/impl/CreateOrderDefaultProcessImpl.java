package com.csp.core.process.impl;

import com.csp.common.enums.SolutionEnum;
import com.csp.core.context.CreateOrderContext;
import com.csp.core.process.CreateOrderProcess;
import com.csp.domain.model.req.CreateOrderReqBO;
import com.csp.domain.model.res.CreateOrderResBO;
import com.csp.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Component
@RequiredArgsConstructor
public class CreateOrderDefaultProcessImpl implements CreateOrderProcess {

    private final OrderDomainService orderDomainService;

    @Override
    public Set<SolutionEnum> solutions() {
        return Set.of();
    }

    @Override
    public CreateOrderResBO execute(CreateOrderContext ctx) {
        // 校验
        preCheck(ctx);
        // 组装单据
        assemblyOrder(ctx);
        // 决策
        decide(ctx);
        // 组织创建事件
        assemblyCreateEvent(ctx);
        // 保存数据
        save(ctx);
        // 构建返回结果
        return buildResult(ctx);
    }

    private CreateOrderResBO buildResult(CreateOrderContext ctx) {
        return new CreateOrderResBO();
    }

    private void save(CreateOrderContext ctx) {

    }

    private void assemblyCreateEvent(CreateOrderContext ctx) {

    }

    private void decide(CreateOrderContext ctx) {

    }

    private void assemblyOrder(CreateOrderContext ctx) {
        orderDomainService.assemblyCreateOrder();
    }

    private void preCheck(CreateOrderContext ctx) {

    }

}
