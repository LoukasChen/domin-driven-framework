package com.csp.core.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseContext<T, R> {

    private T request;

    private R result;
}
