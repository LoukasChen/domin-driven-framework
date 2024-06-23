package com.csp.core.utils;

import com.csp.common.enums.ProductEnum;
import com.csp.common.enums.SolutionEnum;
import com.csp.common.exception.BizException;
import com.csp.core.process.Process;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Component
public class ProcessUtils {

    private static ApplicationContext applicationContext;

    @Autowired
    public ProcessUtils(ApplicationContext applicationContext) {
        ProcessUtils.applicationContext = applicationContext;
    }

    public static <P extends Process<?, ?>> P getProcess(Class<P> clazz) {
        if (applicationContext == null) {
            throw new BizException();
        }

        List<ProductEnum> productCodes = SessionContextUtils.getProductCodes();
        SolutionEnum solutionCode = SessionContextUtils.getSolutionCode();

        List<P> processList = applicationContext.getBeansOfType(clazz)
                .values()
                .stream()
                .filter(it -> it.solutions().contains(solutionCode))
                .collect(Collectors.toList());

        return Optional
                .ofNullable(processList.get(0))
                .or(() -> processList
                        .stream()
                        .filter(p -> p.products().containsAll(productCodes))
                        .findAny()
                        .or(() -> processList.stream()
                                .filter(it -> CollectionUtils.isEmpty(it.products()))
                                .findAny()))
                .orElseThrow(() -> new BizException());
    }

}
