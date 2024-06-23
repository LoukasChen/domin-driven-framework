package com.csp.core.session;

import com.csp.core.context.SessionContext;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
public class SessionContextFactory {

    private static final ThreadLocal<SessionContext> sessionContextThreadLocal = new ThreadLocal<>();

    public static SessionContext init() {
        SessionContext sessionContext = SessionContext.getInstance();
        sessionContextThreadLocal.set(sessionContext);
        return sessionContext;
    }

    public static SessionContext get() {
        return sessionContextThreadLocal.get();
    }

    public static void set(SessionContext context) {
        if (context == null) {
            context = SessionContext.getInstance();
        }
        sessionContextThreadLocal.set(context);
    }

    public static void clear() {
        sessionContextThreadLocal.remove();
    }
}
