package com.csp.core.utils;

import com.csp.common.enums.ProductEnum;
import com.csp.common.enums.SolutionEnum;
import com.csp.common.exception.BizException;
import com.csp.core.context.SessionContext;
import com.csp.core.session.SessionContextFactory;

import java.util.List;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
public interface SessionContextUtils {

    static List<ProductEnum> getProductCodes() {
        SessionContext context = SessionContextFactory.get();
        if (context == null) {
            throw new BizException();
        }
        return context.getProductList();
    }

    static SolutionEnum getSolutionCode() {
        SessionContext context = SessionContextFactory.get();
        if (context == null) {
            throw new BizException();
        }
        return context.getSolutionCode();
    }

    static void setProductCodes(List<ProductEnum> productList) {
        SessionContext context = SessionContextFactory.get();
        if (context == null) {
            throw new BizException();
        }
        context.setProductList(productList);
    }

    static void setSolutionCode(SolutionEnum solutionCode) {
        SessionContext context = SessionContextFactory.get();
        if (context == null) {
            throw new BizException();
        }
        context.setSolutionCode(solutionCode);
    }

}
