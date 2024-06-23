package com.csp.core.context;

import com.csp.domain.model.req.CreateOrderReqBO;
import com.csp.domain.model.res.CreateOrderResBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
public class CreateOrderContext extends BaseContext<CreateOrderReqBO, CreateOrderResBO> {

    private String ignore;

}
