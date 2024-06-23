package com.csp.core.context;

import com.csp.common.enums.ProductEnum;
import com.csp.common.enums.SolutionEnum;
import lombok.Data;

import java.util.List;
import java.util.UUID;

/**
 * @author: csp
 * @date: 2024/6/23
 */
@Data
public class SessionContext {

    private String id;

    private String traceId;

    private List<ProductEnum> productList;

    private SolutionEnum solutionCode;

    public static SessionContext getInstance() {
        SessionContext context = new SessionContext();
        context.setId(UUID.randomUUID().toString().replace("-", ""));
        return context;
    }
}
