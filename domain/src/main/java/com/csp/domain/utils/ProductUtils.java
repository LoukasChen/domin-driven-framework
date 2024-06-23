package com.csp.domain.utils;

import com.csp.common.enums.ProductEnum;
import com.csp.common.exception.BizException;
import com.csp.domain.product.ProductScheme;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.context.ApplicationContext;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
public class ProductUtils {

    private static Map<Class<?>, Map<ProductEnum, List<ProductScheme>>> productSchemeMap;

    public ProductUtils(ApplicationContext ctx) {
        productSchemeMap = ctx.getBeansOfType(ProductScheme.class)
                .entrySet()
                .stream()
                .flatMap(it -> ClassUtils.getAllInterfaces(it.getValue().getClass()).stream().map(t ->
                        new AbstractMap.SimpleEntry<>(t, it.getValue()))
                )
                .collect(Collectors.groupingBy(
                        AbstractMap.SimpleEntry::getKey,
                        Collectors.groupingBy(
                                it -> it.getValue().product(),
                                Collectors.mapping(Map.Entry::getValue, Collectors.toList())
                        )
                ));
    }

    public static <S extends ProductScheme> S get(
            ProductEnum productEnum,
            Class<S> clazz
    ) {
        if (productEnum == null) {
            return null;
        }
        if (productSchemeMap == null) {
            throw new BizException();
        }
        List<ProductScheme> productSchemes = productSchemeMap.getOrDefault(clazz, new HashMap<>()).get(productEnum);
        if (CollectionUtils.isEmpty(productSchemes)) {
            return null;
        }
        if (productSchemes.size() > 1) {
            throw new BizException();
        }
        return (S) productSchemes.get(0);
    }

    public static <T extends ProductScheme, R> List<R> execute(
            List<ProductEnum> productList,
            Class<T> clazz,
            Function<T, R> executable
    ) {
        return ListUtils.emptyIfNull(productList)
                .stream()
                .map(it -> get(it, clazz))
                .filter(Objects::nonNull)
                .map(executable)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static <T extends ProductScheme> void run(
            List<ProductEnum> productList,
            Class<T> clazz,
            Consumer<T> consumer
    ) {
        ListUtils.emptyIfNull(productList)
                .stream()
                .map(it -> get(it, clazz))
                .filter(Objects::nonNull)
                .forEach(consumer);
    }

}
