package com.csp.common.error;

import lombok.RequiredArgsConstructor;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@RequiredArgsConstructor
public enum GlobalError implements ErrorCode {
    RPC_ERROR("RPC异常");

    private final String desc;

    @Override
    public String code() {
        return name();
    }

    @Override
    public String desc() {
        return desc;
    }
}
