package com.csp.core.template;

import com.csp.common.enums.ProductEnum;
import com.csp.common.enums.SolutionEnum;
import com.csp.common.exception.BizException;
import com.csp.core.context.BaseContext;
import com.csp.core.session.SessionContextFactory;
import com.csp.core.utils.SessionContextUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc:
 * @author: csp
 * @date: 2024/6/23
 */
@Component
public class ManagerTemplateDefaultImpl implements ManagerTemplate {

    @Override
    public <T, R, C extends BaseContext<T, R>> R doExecute(ManagerCallback<T, R, C> callback) {
        R result;
        C context;
        try {
            context = callback.buildContext();
            callback.initSessionContext(context);
            boolean checkIdempotent = callback.checkIdempotent(context);
            if (checkIdempotent) {
                return context.getResult();
            }

            List<ProductEnum> productEnums = callback.decideProducts(context);
            SessionContextUtils.setProductCodes(productEnums);

            SolutionEnum solutionCode = callback.decideSolution(context);
            SessionContextUtils.setSolutionCode(solutionCode);

            String lockKey = getLockKey();
            if (lockKey != null) {
                // 加分布式锁，再执行
                result = callback.execute(context);
            } else {
                result = callback.execute(context);
            }
        } catch (BizException e) {
            // 业务指标采集、日志打印
            throw e;
        } catch (Throwable throwable) {
           // 转化为统一异常
            throw throwable;
        }
        return result;
    }

    private String getLockKey() {
        return null;
    }

}
