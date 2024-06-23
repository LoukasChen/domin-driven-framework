package com.csp.core.process;

import com.csp.common.enums.ProductEnum;
import com.csp.common.enums.SolutionEnum;

import java.util.Set;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
public interface Process<T, R> {

    Set<SolutionEnum> solutions();

    default Set<ProductEnum> products() {
        return Set.of();
    }

    R execute(T ctx);
}
