package com.csp.core.template;

import com.csp.core.context.BaseContext;
import com.csp.core.session.SessionContextFactory;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
public interface ManagerTemplate {

    default <T, R, C extends BaseContext<T, R>> R execute(ManagerCallback<T, R, C> callback) {
        try {
            begin();
            return doExecute(callback);
        } finally {
            after();
        }
    }

    <T, R, C extends BaseContext<T, R>> R doExecute(ManagerCallback<T, R, C> callback);

    default void after() {
        SessionContextFactory.clear();
    }

    default void begin() {
        if (SessionContextFactory.get() == null) {
            SessionContextFactory.init();
        }
    }

}
