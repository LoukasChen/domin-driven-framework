package com.csp.core.template;

import com.csp.common.enums.SolutionEnum;
import com.csp.core.context.BaseContext;
import com.csp.common.enums.ProductEnum;

import java.util.List;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
public interface ManagerCallback<T, R, C extends BaseContext<T, R>> {
    /**
     * 构建上下文
     */
    C buildContext();

    /**
     * 初始化会话上下文
     */
    void initSessionContext(C ctx);

    /**
     * 幂等检查
     */
    boolean checkIdempotent(C ctx);

    /**
     * 决策产品方案
     */
    List<ProductEnum> decideProducts(C ctx);

    /**
     * 决策解决方案
     */
    SolutionEnum decideSolution(C ctx);

    /**
     * 执行
     */
    R execute(C ctx);

}
